package com.xuyuchao.controller;

import com.xuyuchao.dao.EmpDao;
import com.xuyuchao.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-07-14:38
 * @Description:
 */
@Controller
public class EmpController {
    @Autowired
    private EmpDao empDao;
    /**
     * 查询全部数据
     * @return
     */
    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    public String getAllEmp(Model model) {
        Collection<Emp> emps = empDao.getAll();
        model.addAttribute("emps",emps);
        return "/EmpList";
    }

    /**
     * 根据id删除emp
     * @return
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String deleteEmpById(@PathVariable("id") Integer id) {
        empDao.delete(id);
        return "redirect:/emp";
    }

    /**
     * 添加员工
     * @param emp
     * @return
     */
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public String addEmp(Emp emp) {
        empDao.save(emp);
        return "redirect:/emp";
    }

    /**
     * 修改员工界面
     * @return
     */
    @RequestMapping(value = "/emp",method = RequestMethod.PUT)
    public String updateEmp(Emp emp) {
        empDao.save(emp);
        return "redirect:/emp";
    }

    /**
     * 跳转到修改员工界面
     * @return
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String updateEmpById(@PathVariable("id") Integer id,Model model) {
        //根据id查找到要修改的员工信息
        Emp emp = empDao.get(id);
        //通过Model将员工信息保存并转发到修改员工界面
        model.addAttribute("emp",emp);
        return "/updateEmp";
    }
}
