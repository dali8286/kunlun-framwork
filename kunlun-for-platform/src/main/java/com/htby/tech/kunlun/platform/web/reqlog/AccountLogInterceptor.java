package com.htby.tech.kunlun.platform.web.reqlog;

import com.htby.tech.kunlun.utils.uuid.UuidUtils;
import com.htby.tech.kunlun.platform.web.reqlog.param.BodyReaderHttpServletRequestWrapper;
import com.htby.tech.kunlun.platform.web.security.pojo.OnlineAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;

/**
 * 操作日志拦截器
 *
 * @author vincent0116
 * @date 2019/08/01
 */
@Slf4j
@Component
public class AccountLogInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String requestId = UuidUtils.getUUID();
        request.setAttribute("startTime", System.currentTimeMillis());
        request.setAttribute("requestId", requestId);
        try {
            if (handler instanceof HandlerMethod) {
                StringBuilder sb = new StringBuilder();
                sb.append("\n-------------------操作日志----------------\n");
                sb.append("Controller：").append(((HandlerMethod) handler).getBean().getClass().getName()).append("\n");
                sb.append("Method：").append(((HandlerMethod) handler).getMethod().getName()).append("\n");
                sb.append("RequestMethod：").append(request.getMethod()).append("\n");
                //通过输入流获取POST请求中的参数
                sb.append("BodyParams：").append(new BodyReaderHttpServletRequestWrapper(request).getBodyString()).append("\n");
                sb.append("GetParams：").append(getParamString(request.getParameterMap())).append("\n");
                sb.append("URL：").append(request.getRequestURL()).append("\n");
                try {
                    sb.append("AccountId：").append(OnlineAccount.current().getAccountBasicInfo().getAccountId()).append("\n");
                    sb.append("AccountName：").append(OnlineAccount.current().getAccountBasicInfo().getAccountName()).append("\n");
                } catch (NullPointerException e) {
                    sb.append("AccountId：").append("无").append("\n");
                    sb.append("AccountName：").append("无").append("\n");
                }
                sb.append("RequestId：").append(requestId);

                log.info(sb.toString());
            }
        } catch (Exception e) {
            log.info("操作记录打印异常");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        Long startTime = (Long) request.getAttribute("startTime");
        String requestId = (String) request.getAttribute("requestId");
        Long endTime = System.currentTimeMillis();
        Long costTime = endTime - startTime;
        if (handler instanceof HandlerMethod) {
            StringBuilder sb = new StringBuilder();
            sb.append("RequestId：").append(requestId).append(" CostTime：").append(costTime).append("ms");
            log.info(sb.toString());
        }
    }

    /**
     * 获取参数
     *
     * @param map
     * @return
     */
    private String getParamString(Map<String, String[]> map) {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String[]> e : map.entrySet()) {
            sb.append(e.getKey()).append("=");
            String[] value = e.getValue();
            if (value != null && value.length == 1) {
                sb.append(value[0]).append("\t");
            } else {
                sb.append(Arrays.toString(value)).append("\t");
            }
        }
        return sb.toString();
    }
}
