package com.kh.springbootintercepter.common.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor{

    // controller 시작하기 전에 진행
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("1번 preHandle");
        return true;
    }

    // controller 종료할 때 진행
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        log.info("3번 postHandle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    // view resolver 실행하기 전에
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable Exception ex) throws Exception {
        log.info("4번 afterHandle");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
