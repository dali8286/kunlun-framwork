package com.htby.tech.kunlun.platform.web.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * 错误处理
 *
 * @author vincent0116
 * @date 2018/7/25
 */
@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry errorPageRegistry) {
        ErrorPage e403 = new ErrorPage(HttpStatus.FORBIDDEN, "/403");
        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
        ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500");
        errorPageRegistry.addErrorPages(e403, e404, e500);
    }
}
