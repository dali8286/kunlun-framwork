package com.htby.tech.kunlun.platform.web.security;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Session配置类
 *
 * @author vincent0116
 * @date 2018/11/15
 */
@Data
@Configuration
public class SessionConfigure {

    @Value("${sso.session.expiration}")
    private Integer sessionExpiration = 1296000;

    @Value("${sso.session.prefix}")
    private String sessionPrefix = "partyToken:";

    @Value("${sso.header.token.name}")
    private String tokenName = "party_token";

    @Value("${sso.isOpen}")
    private Boolean isOpen = true;

}
