package com.YL.reggie.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户的登录功能
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    //用户名
    private String userName;
    //密码
    private String passWord;
}
