package com.htby.tech.kunlun.platform.web.reqlog.param;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 参数日志过滤器
 *
 * @author vincent0116
 * @date 2019/08/01
 */
@Slf4j
@WebFilter(urlPatterns = "/*", filterName = "paramLogFilter")
public class ParamLogFilter implements Filter {

    private static final Set<String> EXCLUDE_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/dj/upload/file", "/dj/login/normal", "/dj/login/fast", "/dj/login/captcha.jpg", "/dj/login/out", "/dj/login/send/code")));

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 防止流读取一次后就没有了, 所以需要将流继续写出去
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String path = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length()).replaceAll("[/]+$", "");

        if (!EXCLUDE_PATHS.contains(path)) {
            ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper(httpServletRequest);
            filterChain.doFilter(requestWrapper, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
