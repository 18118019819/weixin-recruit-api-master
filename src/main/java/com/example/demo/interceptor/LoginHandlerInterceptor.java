/**
 *
 *
 *
 * 登陆拦截器可用
 *
 *
 */


//package com.example.demo.interceptor;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Slf4j
//public class LoginHandlerInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String user = (String)request.getSession().getAttribute("loginUser");
//        if(user==null){
//            log.info("user==null");
//            //未登录，返回登陆页面
//            request.setAttribute("mes","请登录");
////            //request.getRequestDispatcher("登陆页面").forward(request,response);
//            return false;
//        }else {
//            //登陆放行
//            //request.getRequestDispatcher("跳转页面");
//            log.info("登陆放行");
//            return true;
//        }
//
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//}
