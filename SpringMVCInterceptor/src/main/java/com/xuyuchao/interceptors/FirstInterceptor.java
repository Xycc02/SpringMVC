package com.xuyuchao.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-09-22:42
 * @Description:
 */
@Component
public class FirstInterceptor implements HandlerInterceptor {
    /**
     * 在控制器方法执行之前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("FirstInterceptor拦截器的preHandle方法执行了!");
        //返回false,拦截,返回true放行
        return true;
    }

    /**
     * 在控制器方法执行之后执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("FirstInterceptor拦截器的postHandle方法执行了!");
    }

    /**
     * 处理完视图和模型数据,渲染视图完毕之后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("FirstInterceptor拦截器的afterCompletion方法执行了!");
    }
}
