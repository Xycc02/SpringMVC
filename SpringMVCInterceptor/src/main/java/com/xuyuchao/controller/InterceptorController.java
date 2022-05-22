package com.xuyuchao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-09-22:25
 * @Description:
 */
@Controller
public class InterceptorController {

    @RequestMapping("/**/testInterceptor")
    public String testInterceptor() {
        return "success";
    }
}
