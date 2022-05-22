package com.xuyuchao.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-10-14:27
 * @Description: 代替web.xml
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 指定Spring的配置类
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //返回Spring的配置类的class
        return new Class[]{SpringConfig.class};
    }

    /**
     * 指定SpringMVC的配置类
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        //返回SpringMVC的配置类的class
        return new Class[]{SpringMVCConfig.class};
    }

    /**
     * 指定DispatcherServlet的url-pattern的映射规则
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 配置过滤器
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        //请求和响应编码
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceResponseEncoding(true);
        //配置HiddenHttpMethodFilter
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();

        return new Filter[] {characterEncodingFilter,hiddenHttpMethodFilter};
    }
}
