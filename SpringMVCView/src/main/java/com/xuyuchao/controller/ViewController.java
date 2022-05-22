package com.xuyuchao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-05-14:55
 * @Description:
 */
@Controller
public class ViewController {

//    @RequestMapping("/")
//    public String index() {
//        return "index";
//    }


    /**
     * ThymeleafView
     * 普通Thymeleaf视图解析,视图名称没有任何前后缀,因此由Thymeleaf视图解析器进行解析
     * @return
     */
    @RequestMapping("/success")
    public String success() {
        return "success";
    }
    /**
     * 当控制器方法中所设置的视图名称以"forward:"为前缀时，创建InternalResourceView视图，
     * 此时的视图名称不会被SpringMVC配置文件中所配置的视图解析器解析，而是会将前缀"forward:"去掉，剩余部分作为最终路径通过转发的方式实现跳转
     * @return
     */
    @RequestMapping("/forward")
    public String forword() {
        return "forward:/success";
    }

    @RequestMapping("/redirect")
    public String redirect() {
        return "redirect:/success";
    }
}
