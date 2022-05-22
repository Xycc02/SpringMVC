package com.xuyuchao.pojo;

import lombok.Data;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-04-23:13
 * @Description:
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String sex;
    private int age;
    private String email;
}
