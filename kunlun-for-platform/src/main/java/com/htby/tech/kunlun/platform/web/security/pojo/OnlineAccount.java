package com.htby.tech.kunlun.platform.web.security.pojo;

import lombok.Data;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.io.Serializable;

/**
 * 当前账号
 *
 * @author vincent0116
 * @date 2019/01/20
 */
@Data
public class OnlineAccount implements Serializable {

    private boolean isOnline = true;
    private AccountBasicInfo accountBasicInfo;
    private String sessionId;
    private String ipAddr;

    public static final String ONLINE_ACCOUNT = "online_account";

    public static OnlineAccount current() {
        RequestAttributes att = RequestContextHolder.currentRequestAttributes();
        OnlineAccount onlineAccount = (OnlineAccount) att.getAttribute(ONLINE_ACCOUNT, RequestAttributes.SCOPE_SESSION);
        if (onlineAccount == null) {
            onlineAccount = new OnlineAccount();
            att.setAttribute(ONLINE_ACCOUNT, onlineAccount, RequestAttributes.SCOPE_SESSION);
        }
        return onlineAccount;
    }

    public static void clean() {
        RequestContextHolder.currentRequestAttributes().removeAttribute(ONLINE_ACCOUNT, RequestAttributes.SCOPE_SESSION);
    }

}
