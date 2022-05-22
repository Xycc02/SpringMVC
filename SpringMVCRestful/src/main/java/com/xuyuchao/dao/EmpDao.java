package com.xuyuchao.dao;

import com.xuyuchao.pojo.Emp;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-07-15:54
 * @Description:
 */
@Repository
public class EmpDao {
    private static Map<Integer, Emp> emps = null;

    static{
        emps = new HashMap<Integer,Emp>();
        emps.put(1001, new Emp(1001, "E-AA", "aa@163.com", 1));
        emps.put(1002, new Emp(1002, "E-BB", "bb@163.com", 1));
        emps.put(1003, new Emp(1003, "E-CC", "cc@163.com", 0));
        emps.put(1004, new Emp(1004, "E-DD", "dd@163.com", 0));
        emps.put(1005, new Emp(1005, "E-EE", "ee@163.com", 1));
    }

    private static Integer initId = 1006;

    public void save(Emp emp) {
        if(emp.getId() == null) {
            emp.setId(initId++);
        }
        emps.put(emp.getId(),emp);
    }
    public Collection<Emp> getAll(){
        return emps.values();
    }

    public Emp get(Integer id){
        return emps.get(id);
    }

    public void delete(Integer id){
        emps.remove(id);
    }
}
