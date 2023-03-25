package com.YL.reggie.controller;

import com.YL.reggie.common.R;
import com.YL.reggie.entity.User;
import com.YL.reggie.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R<String> login(String username,String password){

        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();

        queryWrapper.eq(User::getUserName,username);
        User use = userService.getOne(queryWrapper);

        if(use.getPassWord().equals(password)){
            return R.success("登录成功");
        }else{
            return R.error("登录失败");
        }
    }
}
