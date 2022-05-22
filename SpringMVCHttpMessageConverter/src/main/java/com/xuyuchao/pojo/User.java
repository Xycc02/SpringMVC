package com.xuyuchao.pojo;

import lombok.Data;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-08-15:38
 * @Description:
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String email;

    public User(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
