package com.xuyuchao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-10-12:52
 * @Description:
 */
@Controller
public class ExceptionController1 {

    @RequestMapping("/ExceptionTest1")
    public String ExceptionTest1() {
        int i = 10 / 0;
        return "success";
    }
}
