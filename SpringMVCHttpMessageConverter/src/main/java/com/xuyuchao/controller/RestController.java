package com.xuyuchao.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-09-12:41
 * @Description:
 *
 * @RestController注解是springMVC提供的一个复合注解，标识在控制器的类上，就相当于为类添加了@Controller注解，并且为其中的每个方法添加了@ResponseBody注解
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    /**
     * 因为该类上加了@RestController注解,因此该类中的所有方法都会自动加上@RequestBody注解,返回值即为响应体
     * @return
     */
    @RequestMapping("/RestController")
    public String RestController() {
        return "RestController";
    }
}
