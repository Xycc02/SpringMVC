package com.xuyuchao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-05-12:47
 * @Description:
 */
@Controller
public class AttributeController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 通过Servlet原生API储存域数据
     * @param req
     * @return
     */
    @RequestMapping("/ServletAPI")
    public String success(HttpServletRequest req) {
        req.setAttribute("key","valueServletAPI");
        System.out.println(req.getAttribute("key"));
        return "success";
    }

    /**
     * 使用ModelAndView往域对象中存取数据
     * Model:共享域数据
     * View:视图
     * @return
     */
    @RequestMapping("/ModelAndView")
    public ModelAndView modelAndView() {
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //往该对象中存入共享域数据
        modelAndView.addObject("key","valueModelAndView");
        //往该对象中设置视图名称
        modelAndView.setViewName("success");
        //ModelAndView [view="success"; model={key2=value2}]
        System.out.println(modelAndView);
        //返回该对象
        return modelAndView;
    }

    /**
     * 使用Model往域对象中共享数据,没有视图功能,需自己转发视图
     * @param model
     * @return
     */
    @RequestMapping("/Model")
    public String mode(Model model) {
        model.addAttribute("key", "valueModel");
        //{key=valueModel}
        System.out.println(model);
        return "success";
    }

    /**
     * 使用map向request域中共享数据
     * @return
     */
    @RequestMapping("/Map")
    public String map(Map<String,Object> map) {
        map.put("key","valueMap");
        System.out.println(map);
        return "success";
    }

    /**
     * 使用ModelMap向Request域中共享数据
     * @param modelMap
     * @return
     */
    @RequestMapping("/ModelMap")
    public String ModelMap(ModelMap modelMap) {
        modelMap.addAttribute("key","valueModelMap");
        System.out.println(modelMap);
        return "success";
    }

    /**
     * 往Session域中共享数据
     * @param session
     * @return
     */
    @RequestMapping("/Session")
    public String Session(HttpSession session) {
        session.setAttribute("key","valueSession");
        System.out.println(session.getAttribute("key"));
        return "success";
    }

    /**
     * 往Application域中存取数据
     * 获取ServletContext对象的方式:request获取,session获取,servlet的init方法的ServletConfig对象获取
     * @param session
     * @return
     */
    @RequestMapping("/Application")
    public String Application(HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("key", "valueApplication");
        return "success";
    }
}
