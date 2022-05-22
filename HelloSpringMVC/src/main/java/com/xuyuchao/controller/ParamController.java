package com.xuyuchao.controller;

import com.xuyuchao.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-03-22:57
 * @Description:
 */
@Controller
public class ParamController {
    @RequestMapping("/param")
    public String ToParam() {
        return "param";
    }

    /**
     * 通过ServletAPI来获取请求参数
     * 将HttpServletRequest作为控制器方法的形参，此时HttpServletRequest类型的参数表示封装了当前请求的请求报文的对象
     * @param req
     * @return
     */
    @RequestMapping("/param/servletAPI")
    public String ServletAPI(HttpServletRequest req) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        return "target";
    }

    /**
     * 通过在控制器方法的参数上添加跟请求参数同名的参数
     * 在控制器方法的形参位置，设置和请求参数同名的形参，当浏览器发送请求，匹配到请求映射时，在DispatcherServlet中就会将请求参数赋值给相应的形参
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/param/controllerParam")
    public String controllerParam(String username,String password) {
        System.out.println(username);
        System.out.println(password);
        return "target";
    }

    /**
     * 若请求所传输的请求参数中有多个同名的请求参数(如复选框)，此时可以在控制器方法的形参中设置字符串数组或者字符串类型的形参接收此请求参数
     * 若使用字符串数组类型的形参，此参数的数组中包含了每一个数据
     * 若使用字符串类型的形参，此参数的值为每个数据中间使用逗号拼接的结果
     *
     * @RequestParam
     * @RequestParam是将请求参数和控制器方法的形参创建映射关系
     * @RequestParam注解一共有三个属性：
     * value：指定为形参赋值的请求参数的参数名
     * required：设置是否必须传输此请求参数，默认值为true
     * 若设置为true时，则当前请求必须传输value所指定的请求参数，若没有传输该请求参数，
     * 且没有设置defaultValue属性，则页面报错400：Required String parameter 'xxx' is not present；若设置为false，
     * 则当前请求不是必须传输value所指定的请求参数，若没有传输，则注解所标识的形参的值为null
     *
     * defaultValue：不管required属性值为true或false，当value所指定的请求参数没有传输或传输的值为""时，则使用默认值为形参赋值
     * @param username
     * @param password
     * @param hobby
     * @return
     */
    @RequestMapping("/param/sameNameParam")
    public String sameNameParam(@RequestParam(value = "user_name",required = false,defaultValue = "defalut") String username, String password, String[] hobby) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(Arrays.toString(hobby));
        return "target";
    }

    /**
     * @RequestHeader是将请求头信息和控制器方法的形参创建映射关系
     * @RequestHeader注解一共有三个属性：value、required、defaultValue，用法同@RequestParam
     * 当value的值在请求头信息中没有对应值时,若required=true(默认),则报400错误,若required=false,则给形参赋值为null
     * @param host
     * @return
     */
    @RequestMapping("/param/requestHeader")
    public String requestHeader(@RequestHeader(value = "host0",required = false,defaultValue = "default") String host){
        System.out.println(host);
        return "target";
    }

    /**
     * session是存放在服务器的一种会话技术,能表示一个浏览器和一个服务器之间的关系
     * 当浏览器和服务器之间没有session时,服务器端req.getSession会创建一个新的session
     * 否则得到已有的session,session在浏览器中是以cookie存储的,key为JSESSIONID,value为一串字符串
     * 该字符串在session域中代表session的key,value为session对象
     * @CookieValue注解的用法同@RequestParam
     * @param req
     * @param JSESSIONID
     * @return
     */
    @RequestMapping("/param/requestCookie")
    public String requestCookie(HttpServletRequest req,@CookieValue(value = "JSESSIONID",required = false,defaultValue = "default")String JSESSIONID){
        HttpSession session = req.getSession();
        System.out.println(JSESSIONID);
        return "target";
    }

    @RequestMapping("/param/testpojo")
    public String testpojo(User user){
        System.out.println(user);
        return "target";
    }
}
