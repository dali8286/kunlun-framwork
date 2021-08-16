package com.htby.tech.kunlun.platform;

import com.htby.tech.kunlun.runtime.core.spring.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Starter4Platform
 *
 * @author vincent0116
 * @date 2018/10/24
 */
@Slf4j
@SpringBootApplication(scanBasePackages = {"com.htby.tech.kunlun.platform", "com.htby.tech.kunlun.notify"})
public class Starter4Platform {

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }

    public static void main(String[] args) {
        SpringApplication.run(Starter4Platform.class, args);
    }
}
