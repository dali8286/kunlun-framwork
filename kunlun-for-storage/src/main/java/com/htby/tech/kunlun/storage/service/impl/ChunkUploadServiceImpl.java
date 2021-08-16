package com.htby.tech.kunlun.storage.service.impl;

import com.htby.tech.kunlun.storage.dao.auto.FileDAO;
import com.htby.tech.kunlun.storage.entity.auto.FilePOExample;
import com.htby.tech.kunlun.storage.service.ChunkUploadService;
import com.htby.tech.kunlun.utils.uuid.UuidUtils;
import com.htby.tech.kunlun.runtime.base.exception.InternalException;
import com.htby.tech.kunlun.runtime.base.service.BaseService;
import com.htby.tech.kunlun.storage.bean.chunk.result.CheckFileResult;
import com.htby.tech.kunlun.storage.bean.chunk.result.CheckResult;
import com.htby.tech.kunlun.storage.bean.chunk.result.MergeResult;
import com.htby.tech.kunlun.storage.bean.chunk.result.UploadResult;
import com.htby.tech.kunlun.storage.dao.auto.FileChunkDAO;
import com.htby.tech.kunlun.storage.entity.auto.FileChunkPO;
import com.htby.tech.kunlun.storage.entity.auto.FileChunkPOExample;
import com.htby.tech.kunlun.storage.entity.auto.FilePO;
import com.htby.tech.kunlun.storage.helper.StorageConfigure;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 分片上传
 *        服务
 *
 * @author vincent0116
 * @date 2020/01/14
 */
@Slf4j
@Service
public class ChunkUploadServiceImpl extends BaseService implements ChunkUploadService {

    @Resource
    private StorageConfigure storageConfigure;
    @Resource
    private FileChunkDAO fileChunkDAO;
    @Resource
    private FileDAO fileDAO;

    private final String FILE_SEPARATOR = File.separator;
    private final String CHILD_FILE_DIR = new StringBuffer().append(FILE_SEPARATOR).append(Calendar.getInstance().get(Calendar.YEAR)).append(FILE_SEPARATOR).append(Calendar.getInstance().get(Calendar.MONTH) + 1).append(FILE_SEPARATOR).append(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)).toString();

    @Override
    public UploadResult doUpload(String fileName, String fileMd5, String mimeType, MultipartFile chunkFile, Long chunkTotal, Long chunkNo) {
        UploadResult result = new UploadResult();
        try {
            if (checkExists4Record(fileMd5, chunkTotal, chunkNo)) {
                // 直接返回相关逻辑
                CheckFileResult checkFileResult = doCheckFileExists(fileMd5);
                BeanUtils.copyProperties(checkFileResult, result);
                result.setIsChunkExists(true);
            } else {
                // 创建相关文件夹
                String wholeChunkDirPath = new StringBuffer(storageConfigure.getUploadChunkParentDir()).append(FILE_SEPARATOR).append(fileMd5).toString();
                File wholeChunkDirFile = genDirAndReturnIfNotExists(wholeChunkDirPath);

                String wholeChunkPath = new StringBuffer().append(wholeChunkDirFile.getAbsolutePath()).append(FILE_SEPARATOR).append(chunkNo).append("-").append(chunkTotal).append(storageConfigure.getUploadChunkFileExt()).toString();
                File wholeChunkFile = new File(wholeChunkPath);
                if (!wholeChunkFile.exists()) {
                    result = uploadAndMerge(fileName, fileMd5, mimeType, chunkFile.getInputStream(), wholeChunkDirFile, wholeChunkFile, chunkTotal, chunkNo);

                    //拓展逻辑：文件合并成功之后更新所有分片记录为无效
                    if (result.getIsMergeCompleted()) {
                        FileChunkPO fileChunkPO = new FileChunkPO();
                        fileChunkPO.setIsDel(tinyIntToByte(1));
                        FileChunkPOExample fileChunkPOExample = new FileChunkPOExample();
                        fileChunkPOExample.createCriteria().andFileMd5EqualTo(fileMd5).andIsDelEqualTo(tinyIntToByte(0));
                        log.info("文件合并后更新分片记录-cnt:[{}];", fileChunkDAO.updateByExampleSelective(fileChunkPO, fileChunkPOExample));
                    }
                } else {
                    CheckFileResult checkFileResult = doCheckFileExists(fileMd5);
                    BeanUtils.copyProperties(checkFileResult, result);
                    result.setIsChunkExists(true);
                }
            }
        } catch (InternalException e) {
            throw e;
        } catch (Exception e) {
            log.error("文件分片上传过程发生异常,操作失败", e);
            throw new InternalException("文件上传过程中出现错误");
        }
        return result;
    }

    /**
     * 上传并合并
     *     > 分片上传逻辑私有
     *
     * @param fileName
     * @param fileMd5
     * @param mimeType
     * @param chunkInputStream
     * @param wholeChunkDirFile
     * @param wholeChunkFile
     * @param chunkTotal
     * @param chunkNo
     * @return
     */
    private UploadResult uploadAndMerge(String fileName, String fileMd5, String mimeType, InputStream chunkInputStream, File wholeChunkDirFile, File wholeChunkFile, Long chunkTotal, Long chunkNo) {
        UploadResult result = new UploadResult();
        try {
            wholeChunkFile.createNewFile();

            long startTime = System.currentTimeMillis();
            StreamUtils.copy(chunkInputStream, new FileOutputStream(wholeChunkFile));
            log.info("文件分片上传完成-md5:[{}],chunk:[{}],total:[{}],上传耗时:[{}]ms;", fileMd5, chunkNo, chunkTotal, (System.currentTimeMillis() - startTime));

            File[] wholeChunkFiles = wholeChunkDirFile.listFiles((f, name) -> name.endsWith(storageConfigure.getUploadChunkFileExt()));
            if (wholeChunkFiles.length == chunkTotal) {
                long mergeStartTime = System.currentTimeMillis();
                MergeResult mergeResult = doMerge(fileName, fileMd5, mimeType);
                BeanUtils.copyProperties(mergeResult, result);
                log.info("文件分片合并结束-fileName:[{}],md5:[{}],total:[{}],result:[{}],合并耗时:[{}]ms;;", fileName, fileMd5, chunkTotal, result, System.currentTimeMillis()-mergeStartTime);
            }
            result.setIsUploadCompleted(true);

            FileChunkPO fileChunkPO = new FileChunkPO();
            fileChunkPO.setChunkNo(chunkNo);
            fileChunkPO.setChunkTotal(chunkTotal);
            fileChunkPO.setFileName(fileName);
            fileChunkPO.setFileMd5(fileMd5);
            fileChunkPO.setMimeType(mimeType);
            fileChunkPO.setExternalPath(wholeChunkFile.getAbsolutePath());
            fileChunkPO.setCreateTime(new Date());
            fileChunkPO.setUpdateTime(new Date());
            log.info("文件分片上传生成记录-cnt:[{}];", fileChunkDAO.insertSelective(fileChunkPO));
        } catch (InternalException e) {
            throw e;
        } catch (Exception e) {
            log.error("文件分片创建过程发生异常,操作失败", e);
            throw new InternalException("文件分片创建过程发生异常,操作失败");
        }
        return result;
    }

    /**
     * 执行合并
     *
     * @param fileName
     * @param fileMd5
     * @param mimeType
     * @return
     */
    private MergeResult doMerge(String fileName, String fileMd5, String mimeType) {
        MergeResult result =  new MergeResult();

        FilePOExample filePOExample = new FilePOExample();
        filePOExample.createCriteria().andMd5EqualTo(fileMd5);
        List<FilePO> filePOList = fileDAO.selectByExample(filePOExample);
        if (filePOList.size() >= 1) {
            // 直接赋值返回
            FilePO filePO = filePOList.get(0);
            result.setIsFileExists(true);
            result.setFileKey(filePO.getExternalPath());
            result.setFilePath(new StringBuffer().append(storageConfigure.getUploadFileHost()).append(filePO.getExternalPath()).toString());
        } else {
            // 检查源文件是否存在
            String fileDirPath = new StringBuffer().append(storageConfigure.getUploadFileParentDir()).append(CHILD_FILE_DIR).toString();
            File fileDir = genDirAndReturnIfNotExists(fileDirPath);

            String wholeFileDirPath = new StringBuffer(fileDir.getAbsolutePath()).append(FILE_SEPARATOR).append(fileMd5).toString();
            File wholeFileDir = genDirAndReturnIfNotExists(wholeFileDirPath);

            String wholeFilePath = new StringBuffer().append(wholeFileDir.getAbsolutePath()).append(FILE_SEPARATOR).append(fileName).toString();
            File wholeFile = new File(wholeFilePath);
            if (!wholeFile.exists()) {
                boolean mergeResult = mergeFileAndGenRecords(fileName, fileMd5, mimeType, wholeFile);
                result.setIsFileExists(false);
                result.setIsMergeCompleted(mergeResult);
            }
            result.setFileKey(wholeFile.getAbsolutePath());
            result.setFilePath(new StringBuffer().append(storageConfigure.getUploadFileHost()).append(FILE_SEPARATOR).append(result.getFileKey()).toString());
        }
        return result;
    }

    /**
     * 合并文件并生成记录
     *
     * @param fileName
     * @param fileMd5
     * @param mineType
     * @param wholeFile
     * @return
     */
    private boolean mergeFileAndGenRecords(String fileName, String fileMd5, String mineType, File wholeFile) {
        boolean result = false;
        if (mergeFile(fileMd5, wholeFile)) {

            FilePO filePO = new FilePO();
            filePO.setFileId(UuidUtils.getUUID());
            filePO.setFileName(fileName);
            filePO.setMimeType(mineType);
            filePO.setExt(mineType);
            filePO.setSize(wholeFile.length());
            filePO.setMd5(fileMd5);
            filePO.setExternalPath(wholeFile.getAbsolutePath());
            filePO.setCreateTime(new Date());
            filePO.setUpdateTime(new Date());
            log.info("文件合并后生成记录-cnt:[{}];", fileDAO.insertSelective(filePO));

            result = true;
        }

        return result;
    }

    /**
     * 合并文件
     *
     * @param fileMd5
     * @param wholeFile
     * @return
     */
    private boolean mergeFile(String fileMd5, File wholeFile) {
        boolean result = false;

        String tempChunkDirPath = new StringBuffer().append(storageConfigure.getUploadChunkParentDir()).append(FILE_SEPARATOR).append(fileMd5).toString();
        File tempChunkDirFile = new File(tempChunkDirPath);
        try {
            if (tempChunkDirFile.exists()) {
                File[] partFiles = tempChunkDirFile.listFiles((f, name) -> name.endsWith(storageConfigure.getUploadChunkFileExt()));

                if (partFiles.length > 0) {
                    Arrays.sort(partFiles, (File f1, File f2) -> {
                        String name1 = f1.getName();
                        String name2 = f2.getName();
                        if (name1.length() < name2.length()) {
                            return -1;
                        } else if (name1.length() > name2.length()) {
                            return 1;
                        } else {
                            return name1.compareTo(name2);
                        }
                    });

                    wholeFile.createNewFile();
                    FileChannel resultFileChannel = new FileOutputStream(wholeFile, true).getChannel();
                    long size = 0;
                    for (int i = 0; i < partFiles.length; i++) {
                        size += partFiles[i].length();
                        if (size > wholeFile.length()) {
                            log.info("分片合并进行中，正在合并第[{}]块的文件[{}];", i, partFiles[i].getName());

                            FileChannel inChannel = new FileInputStream(partFiles[i]).getChannel();
                            resultFileChannel.transferFrom(inChannel, resultFileChannel.size(), inChannel.size());
                            inChannel.close();
                        }
                    }

                    if (size < wholeFile.length()) {
                        throw new InternalException("分片文件不完整,合并失败");
                    }
                }

                tempChunkDirFile.listFiles(child -> child.delete());
                tempChunkDirFile.delete();

                result = true;
            }
        } catch (Exception e) {
            log.error("文件合并过程出现异常,合并失败", e);
            throw new InternalException("文件合并过程出现异常,合并失败");
        }
        return result;
    }

    @Override
    public CheckResult doCheckExists(String fileMd5, Long chunkTotal, Long chunkNo) {
        CheckResult result = new CheckResult();

        if (checkExists4Record(fileMd5, chunkTotal, chunkNo)) {
            String chunkParentPath =  new StringBuffer().append(storageConfigure.getUploadChunkParentDir()).append(FILE_SEPARATOR).append(fileMd5).toString();
            String chunkChildPath = new StringBuffer().append(chunkNo).append("-").append(chunkTotal).append(storageConfigure.getUploadChunkFileExt()).toString();

            File chunkFile = new File(chunkParentPath, chunkChildPath);
            if (chunkFile.exists()) {
                result.setIsChunkExists(true);
            }
        }
        return result;
    }

    /**
     * 检查是否存在分片记录
     *
     * @param fileMd5
     * @param chunkTotal
     * @param chunkNo
     * @return
     */
    private boolean checkExists4Record(String fileMd5, Long chunkTotal, Long chunkNo) {
        FileChunkPOExample fileChunkPOExample = new FileChunkPOExample();
        fileChunkPOExample.createCriteria().andFileMd5EqualTo(fileMd5).andChunkTotalEqualTo(chunkTotal).andChunkNoEqualTo(chunkNo).andIsDelEqualTo(tinyIntToByte(0));
        List<FileChunkPO> fileChunkPOList = fileChunkDAO.selectByExample(fileChunkPOExample);
        if (fileChunkPOList.size() >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public CheckFileResult doCheckFileExists(String fileMd5) {
        CheckFileResult checkFileResult = new CheckFileResult();

        FilePOExample filePOExample = new FilePOExample();
        filePOExample.createCriteria().andMd5EqualTo(fileMd5);
        List<FilePO> filePOList = fileDAO.selectByExample(filePOExample);
        if (filePOList.size() >= 1) {
            FilePO filePO = filePOList.get(0);

            checkFileResult.setIsFileExists(true);
            checkFileResult.setFileKey(filePO.getExternalPath());
            checkFileResult.setFilePath(new StringBuffer().append(storageConfigure.getUploadFileHost()).append(filePO.getExternalPath()).toString());
        }
        return checkFileResult;
    }

    /**
     * 创建目录(公用逻辑)
     *
     * @param dirPath
     * @return
     */
    private File genDirAndReturnIfNotExists(String dirPath) {
        File file = new File(dirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}