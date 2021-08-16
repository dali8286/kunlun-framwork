package com.htby.tech.kunlun.storage.entity.auto;

import com.htby.tech.kunlun.runtime.db.entity.BasePO;

import java.util.Date;

/**
 * t_file_chunk
 *
 * @author hbxhxMybatisGenerator
 */
public class FileChunkPO extends BasePO {
    /**
     * ID
     */
    private Long id;

    /**
     * 分片编号
     */
    private Long chunkNo;

    /**
     * 分片总数
     */
    private Long chunkTotal;

    /**
     * 文件/文件夹名称
     */
    private String fileName;

    /**
     * 数据流 MD5
     */
    private String fileMd5;

    /**
     * 文件类型 image/jpg
     */
    private String mimeType;

    /**
     * 文件源路径
     */
    private String externalPath;

    /**
     * 添加者
     */
    private String creator;

    /**
     * 修改者
     */
    private String mender;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除 0-未删除 1-已删除
     */
    private Byte isDel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChunkNo() {
        return chunkNo;
    }

    public void setChunkNo(Long chunkNo) {
        this.chunkNo = chunkNo;
    }

    public Long getChunkTotal() {
        return chunkTotal;
    }

    public void setChunkTotal(Long chunkTotal) {
        this.chunkTotal = chunkTotal;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5 == null ? null : fileMd5.trim();
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType == null ? null : mimeType.trim();
    }

    public String getExternalPath() {
        return externalPath;
    }

    public void setExternalPath(String externalPath) {
        this.externalPath = externalPath == null ? null : externalPath.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getMender() {
        return mender;
    }

    public void setMender(String mender) {
        this.mender = mender == null ? null : mender.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FileChunkPO other = (FileChunkPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getChunkNo() == null ? other.getChunkNo() == null : this.getChunkNo().equals(other.getChunkNo()))
            && (this.getChunkTotal() == null ? other.getChunkTotal() == null : this.getChunkTotal().equals(other.getChunkTotal()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getFileMd5() == null ? other.getFileMd5() == null : this.getFileMd5().equals(other.getFileMd5()))
            && (this.getMimeType() == null ? other.getMimeType() == null : this.getMimeType().equals(other.getMimeType()))
            && (this.getExternalPath() == null ? other.getExternalPath() == null : this.getExternalPath().equals(other.getExternalPath()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getMender() == null ? other.getMender() == null : this.getMender().equals(other.getMender()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getChunkNo() == null) ? 0 : getChunkNo().hashCode());
        result = prime * result + ((getChunkTotal() == null) ? 0 : getChunkTotal().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getFileMd5() == null) ? 0 : getFileMd5().hashCode());
        result = prime * result + ((getMimeType() == null) ? 0 : getMimeType().hashCode());
        result = prime * result + ((getExternalPath() == null) ? 0 : getExternalPath().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getMender() == null) ? 0 : getMender().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", chunkNo=").append(chunkNo);
        sb.append(", chunkTotal=").append(chunkTotal);
        sb.append(", fileName=").append(fileName);
        sb.append(", fileMd5=").append(fileMd5);
        sb.append(", mimeType=").append(mimeType);
        sb.append(", externalPath=").append(externalPath);
        sb.append(", creator=").append(creator);
        sb.append(", mender=").append(mender);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDel=").append(isDel);
        sb.append("]");
        return sb.toString();
    }
}