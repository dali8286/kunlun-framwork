package com.htby.tech.kunlun.notify.sms.yunxin;

import com.alibaba.fastjson.JSON;
import com.htby.tech.kunlun.utils.string.StringUtils;
import com.htby.tech.kunlun.runtime.base.exception.InternalException;
import com.htby.tech.kunlun.runtime.core.httpclient.HttpClientHandler;
import com.htby.tech.kunlun.runtime.core.httpclient.enums.ContentTypeEnum;
import com.htby.tech.kunlun.runtime.notify.NotifyResponse;
import com.htby.tech.kunlun.runtime.notify.sms.SmsNotifier;
import com.htby.tech.kunlun.runtime.notify.sms.SmsNotifyMeta;
import com.htby.tech.kunlun.runtime.notify.sms.SmsNotifyVCodeResponse;
import com.squareup.okhttp.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 网易云信短信发送
 *
 * @author vincent0116
 * @date 2018/12/10
 */
@Slf4j
public class NetEaseImSmsSender implements SmsNotifier {

    @Override
    public SmsNotifyVCodeResponse sendVerificationCode(SmsNotifyMeta smsNotifyMeta, String signName, String templateId, List<String> receivers) {
        String appId = smsNotifyMeta.getAppId();
        String appSecret = smsNotifyMeta.getAppSecret();
        String curTime = String.valueOf(System.currentTimeMillis() / 1000L);
        String nonce = String.valueOf(new Random().nextInt(999999));
        String checkSum = getCheckSum(appSecret, nonce, curTime);

        Map<String, Object> params = new HashMap<>();
        params.put("templateid", templateId);
        params.put("mobile", receivers.get(0));
        params.put("codeLen", 6);
        try {
            Request request = new Request.Builder()
                    .addHeader("AppKey", appId)
                    .addHeader("Nonce", nonce)
                    .addHeader("CurTime", curTime)
                    .addHeader("CheckSum", checkSum)
                    .url(VERIFY_CODE_SERVER)
                    .post(RequestBody.create(getContentType("application/x-www-form-urlencoded;charset=utf-8"), HttpClientHandler.getInstance().paramMap2ParamStr(params)))
                    .build();

            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new InternalException("server-system-error:" + response);
            }
            String result = response.body().string();
            NetEaseImServerResponse netEaseImServerResponse = JSON.parseObject(result, NetEaseImServerResponse.class);

            return new SmsNotifyVCodeResponse(true, result, netEaseImServerResponse.getCode()+"");
        } catch (IOException e) {
            log.error("云信短信通道发送过程出现问题", e);
        }
        return new SmsNotifyVCodeResponse(false, "", "");
    }

    @Override
    public NotifyResponse sendMessage(SmsNotifyMeta smsNotifyMeta, String signName, String templateId, List<String> receivers, String message) {
        return null;
    }


    private static String getCheckSum(String appSecret, String nonce, String curTime) {
        return encode("sha1", appSecret + nonce + curTime);
    }

    /**
     * 编码加密
     *
     * @param algorithm
     * @param value
     * @return
     */
    private static String encode(String algorithm, String value) {
        if (value == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(value.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final String VERIFY_CODE_SERVER = "https://api.netease.im/sms/sendcode.action";

    /**
     * 获取格式化文本
     *
     * @param bytes
     * @return
     */
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    public static MediaType getContentType(String type) {

        MediaType mediaType = MediaType.parse(ContentTypeEnum.FORM.getContentType());
        if (!StringUtils.isEmpty(type)) {
            mediaType = MediaType.parse(type);
        }

        return mediaType;
    }
}
