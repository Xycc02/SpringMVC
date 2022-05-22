package com.xuyuchao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-07-11:13
 * @Description:
 * REST 风格提倡 URL 地址使用统一的风格设计，从前到后各个单词使用斜杠分开，
 * 不使用问号键值对方式携带请求参数，而是将要发送给服务器的数据作为 URL 地址的一部分，以保证整体风格的一致性。
 */
@Controller
public class RestfulController {
    /**
     * GET(根据id查询user资源)
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable("id")Integer id) {
        System.out.println("查询了id为" + id + "的user资源");
        return "success";
    }

    /**
     * POST(添加user资源)
     */
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String addUser(String username,String password) {
        System.out.println(username);
        System.out.println(password);
        return "success";
    }
    /**
     * DELETE(根据id删除用户)
     * SpringMVC 提供了 HiddenHttpMethodFilter 帮助我们将 POST 请求转换为 DELETE或 PUT请求
     * HiddenHttpMethodFilter 处理put和delete请求的条件：
     * a>当前请求的请求方式必须为post
     * b>当前请求必须传输请求参数_method
     * 满足以上条件,HiddenHttpMethodFilter,过滤器就会将当前请求的请求方式转换为请求参数_method的值，因此请求参数\_method的值才是最终的请求方式
     * 在web.xml中注册HiddenHttpMethodFilter
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String deleteUserById(@PathVariable("id")Integer id) {
        System.out.println("删除了id为"+id+"的user资源");
        return "success";
    }

    /**
     * PUT(根据id修改user资源)
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
    public String updateUser(@PathVariable("id")Integer id,String username,String password) {
        System.out.println("修改了id为"+id+"的资源");
        System.out.println(username);
        System.out.println(password);
        return "success";
    }

}
