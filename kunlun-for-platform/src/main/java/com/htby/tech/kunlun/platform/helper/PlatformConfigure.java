package com.htby.tech.kunlun.platform.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 平台配置
 *
 * @author vincent0116
 * @date 2019/7/26
 */
@Configuration
public class PlatformConfigure {
    private static PlatformConfigure platformInstance;

    @Bean
    public static PlatformConfigure getInstance() {
        if (platformInstance == null) {
            synchronized (PlatformConfigure.class) {
                if (platformInstance == null) {
                    platformInstance = new PlatformConfigure();
                }
            }
        }
        return platformInstance;
    }

    @Value("${env}")
    private String env;

    @Value("${file.host}")
    private String fileHost;
}
