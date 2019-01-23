package com.zhuyao.userservice.controller;

import com.zhuyao.userservice.dto.UserLoginDTO;
import com.zhuyao.userservice.service.UserService;
import com.zhuyao.userservice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zy
 * @Date: 2019/1/23 16:46
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void postUser(@RequestParam("username") String username , @RequestParam("password") String password){
        //参数判断，省略
        userService.insertUser(username,password);
    }

    @PostMapping("/login")
    public UserLoginDTO login(@RequestParam("username") String username , @RequestParam("password") String password){
        //参数判断，省略
        return userService.login(username,password);
    }
}
