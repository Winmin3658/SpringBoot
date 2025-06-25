package com.kh.springbootintercepter.common.interceptor;

import java.lang.reflect.Method;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor{
    private static final String USER_INFO = "userInfo";

    // controller 시작하기 전에 진행
    // handler: url 요청을 했을 때 실행되는 controller와 그에 해당되는 함수 정보가 있음.
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("1번 preHandle");
        String requestURL = request.getRequestURI();
        // requestURL: URL => http://127.0.0.1:8080/login
        log.info("1번 requestURL : " + requestURL);

        HandlerMethod method = (HandlerMethod) handler;
        Method methodObj = method.getMethod();

        // Bean: public void com.kh.controller.loginController.login()
        log.info("1번 Bean: " + method.getBean());

        // Method: public void com.kh.controller.Logincontroller.login()
        log.info("1번 Method: " + methodObj);

        // 세션값을 가져온다
        HttpSession session = request.getSession();

        // 세션값에 로그인해서 성공한 사용자 정보가 들어있음
        if (session.getAttribute("userInfo") != null) {
            // 세션값에 사용자 정보를 삭제
            session.removeAttribute("userInfo");
            log.info("1번 session 사용자 정보 삭제 완료");
            response.sendRedirect("/");
            return false;
        }
        return true;
    }

    // controller 종료할 때 진행
    // ModelAndView: 두 가지(Model, View Resolver 정보를 가지고 있는 객체)
    // return "login/register"
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        log.info("3번 postHandle");
        String requestURL = request.getRequestURI();

        // requestURL : /login
        log.info("3번 requestURL : " + requestURL);
        HandlerMethod method = (HandlerMethod) handler;
        Method methodObj = method.getMethod();

        // Bean: com.zeus.controller.Logincontroller@13ed2e22
        log.info("3번 Bean: " + method.getBean());

        //Method: public void com.zeus.controller.Logincontroller.login()
        log.info("3번 Method: " + methodObj);

        // 세션값을 가져온다
        HttpSession session = request.getSession();

        // ModelMap => Model 같다
        ModelMap modelMap = modelAndView.getModelMap();

        // 컨트롤러에서 ModelAndView에 담은 user 객체를 가져온다
        Object member = modelMap.get("user");

        if (member != null) {
            log.info("3번 member != null");
            session.setAttribute("userInfo", member);
            response.sendRedirect("/");
        }
    } 

    // view resolver 실행하기 전에
    /* @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable Exception ex) throws Exception {
        log.info("4번 afterHandle");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    } */
}
