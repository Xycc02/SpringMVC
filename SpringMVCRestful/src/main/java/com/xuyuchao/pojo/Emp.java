package com.xuyuchao.pojo;

import lombok.Data;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-07-14:37
 * @Description:
 */
@Data
public class Emp {
    private Integer id;
    private String lastName;

    private String email;
    //1 male, 0 female
    private Integer gender;

    public Emp(Integer id, String lastName, String email, Integer gender) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }
}
