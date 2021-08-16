package com.htby.tech.kunlun.notify.sms.aliyun;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.htby.tech.kunlun.notify.sms.aliyun.enums.SendActionEnum;
import com.htby.tech.kunlun.runtime.notify.NotifyResponse;
import com.htby.tech.kunlun.runtime.notify.sms.SmsNotifier;
import com.htby.tech.kunlun.runtime.notify.sms.SmsNotifyMeta;
import com.htby.tech.kunlun.runtime.notify.sms.SmsNotifyVCodeResponse;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

/**
 * 阿里云短信发送
 *
 * @author vincent0116
 * @date 2018/12/10
 */
@Slf4j
public class AliSmsSender implements SmsNotifier {

    @Override
    public SmsNotifyVCodeResponse sendVerificationCode(SmsNotifyMeta smsNotifyMeta, String signName, String templateId, List<String> receivers) {

        if (receivers.size() <= 0) {
            throw new InternalException("发送电话号不能为空,操作失败");
        }

        String domain = smsNotifyMeta.getHost();
        String appId = smsNotifyMeta.getAppId();
        String appSecret = smsNotifyMeta.getAppSecret();
        String message = getCode();

        DefaultProfile profile = DefaultProfile.getProfile("default", appId, appSecret);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain(domain);
        request.setVersion("2017-05-25");
        request.setAction(SendActionEnum.SMS.getAction());
        request.putQueryParameter("RegionId", "default");
        request.putQueryParameter("PhoneNumbers", receivers.get(0));
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateId);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(new HashMap<String, String>(){{put("code", message);}}));

        try {
            CommonResponse response = acsClient.getCommonResponse(request);
            String resData = response.getData();
            if (response.getHttpStatus() == 200 && !StringUtils.isEmpty(response.getData())) {
                JSONObject object = JSONObject.parseObject(response.getData());
                if (object != null && "OK".equals(object.getString("Code"))) {
                    return new SmsNotifyVCodeResponse(true, resData, message);
                } else {
                    log.error("阿里云短信通道发送过程出现错误,错误报文:[{}];", resData);
                }
            }
            return new SmsNotifyVCodeResponse(false, resData, "");
        } catch (ClientException e) {
            log.error("阿里云短信通道构造过程出现错误,错误报文:[{}];", e);
        }
        return new SmsNotifyVCodeResponse(false, "", "");
    }

    @Override
    public NotifyResponse sendMessage(SmsNotifyMeta smsNotifyMeta, String signName, String templateId, List<String> receivers, String message) {
        return null;
    }

    /**
     * 获取6位验证码
     *    TODO 此方法需要重写,规定时间呃逆发送到过的验证码需要一样
     * @return
     */
    private String getCode() {
        StringBuffer result = new StringBuffer();
        char[] arr = {48,49,50,51,52,53,54,55,56,57};
        int i=1;
        while(i++<=6) {
            char msg = arr[(int) (Math.random() * 10)];
            result.append(msg);
        }
        return result.toString();
    }
}
