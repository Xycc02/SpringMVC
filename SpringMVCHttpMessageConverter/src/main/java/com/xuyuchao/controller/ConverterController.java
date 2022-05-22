package com.xuyuchao.controller;

import com.xuyuchao.pojo.User;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-08-14:55
 * @Description:
 * HttpMessageConverter，报文信息转换器，将请求报文转换为Java对象，或将Java对象转换为响应报文
 * HttpMessageConverter提供了两个注解和两个类型：@RequestBody，@ResponseBody，RequestEntity，ResponseEntity
 */
@Controller
public class ConverterController {

    /**
     * @RequestBody可以获取请求体，需要在控制器方法设置一个形参，使用@RequestBody进行标识，当前请求的请求体就会为当前注解所标识的形参赋值
     */
    @RequestMapping("/RequestBody")
    public String RequestBodyTest(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return "success";
    }

    /**
     * RequestEntity封装请求报文的一种类型，需要在控制器方法的形参中设置该类型的形参，当前请求的请求报文就会赋值给该形参，可以通过getHeaders()获取请求头信息，通过getBody()获取请求体信息
     */
    @RequestMapping("/RequestEntity")
    public String RequestEntityTest(RequestEntity<String> requestEntity) {
        System.out.println("请求头:"+requestEntity.getHeaders());
        System.out.println("请求体:"+requestEntity.getBody());
        return "success";
    }

    /**
     * @ResponseBody用于标识一个控制器方法，可以将该方法的返回值直接作为响应报文的响应体响应到浏览器
     */
    @RequestMapping("/ResponseBody")
    @ResponseBody
    public String ResponseBodyTest() {
        return "我是@ResponseBody标识的响应体";
    }

    /**
     * 在处理器方法上使用@ResponseBody注解进行标识
     * 将Java对象直接作为控制器方法的返回值返回，就会自动转换为Json格式的字符串(注意添加依赖)
     */
    @RequestMapping("/ResponseBodyJson")
    @ResponseBody
    public User ResponseBodyJson(){
        User user = new User(1,"admin","admin","123456@qq.com");
        return user;
    }

    /**
     * springMVC处理ajax
     */
    @RequestMapping("/AjaxTest")
    @ResponseBody
    public String testAjax(String username,String password) {
        System.out.println(username);
        System.out.println(password);
        return "hello,ajax";
    }
}
