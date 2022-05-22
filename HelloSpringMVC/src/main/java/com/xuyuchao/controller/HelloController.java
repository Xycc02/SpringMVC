package com.xuyuchao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-01-22:36
 * @Description:
 * 由于前端控制器对浏览器发送的请求进行了统一的处理，但是具体的请求有不同的处理过程，因此需要创建处理具体请求的类，即请求控制器
 * 请求控制器中每一个处理请求的方法成为控制器方法
 * 因为SpringMVC的控制器由一个POJO（普通的Java类）担任，因此需要通过@Controller注解将其标识为一个控制层组件，
 * 交给Spring的IoC容器管理，此时SpringMVC才能够识别控制器的存在
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    /**
     * 当访问了http://localhost:8080/HelloSpringMVC/hello时,返回名称为index的视图
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * value的值能设置多个,为一个字符串类型的数组,能使多个地址访问同一个视图
     * @return
     */
    @RequestMapping(value = {"target1","target2"},method = {RequestMethod.GET,RequestMethod.POST})
    public String toTarget() {
        return "target";
    }

    @GetMapping("/getMappingToTarget")
    public String GetMappingToTarget() {
        return "target";
    }

    /**
     * @RequestMapping的param属性,此处代表必须要有username,且password的值为123456
     * @return
     */
    @RequestMapping(
            value = {"/testParams"},
            method = {RequestMethod.GET,RequestMethod.POST},
            params = {"username","password=123456"})
    public String testParams() {
        return "target";
    }

    @RequestMapping(value = {"/testHeaders"},headers = {"Host=localhost:8081"})
    public String testHeaders() {
        return "target";
    }

    /**
     * ?在路径中可被单一字符所匹配(除了 / ? 特殊情况)
     * @return
     */
    @RequestMapping("/testAnt?")
    public String testAnt() {
        return "target";
    }

    /**
     * SpringMVC支持路径中的占位符
     *  {浏览器请求参数}    @PathVariable(接受参数变量)
     * @param id
     * @return
     */
    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable("id")Integer id,@PathVariable("username")String username) {
        System.out.println("id=" + id);
        System.out.println("username=" + username);
        return "target";
    }
}
