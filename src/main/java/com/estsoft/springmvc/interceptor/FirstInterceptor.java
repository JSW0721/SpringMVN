package com.estsoft.springmvc.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class FirstInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("firstinterceptor.prehandle()");
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("firstinterceptor.posthandle()");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("firstinterceptor.afterhandle()");
    }
}
