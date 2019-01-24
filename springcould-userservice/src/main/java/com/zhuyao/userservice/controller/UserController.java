package com.zhuyao.userservice.controller;

import com.zhuyao.userservice.dto.ReturnUserDTO;
import com.zhuyao.userservice.dto.UserLoginDTO;
import com.zhuyao.userservice.service.UserService;
import com.zhuyao.userservice.utils.responsemessage.ResponseMessageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zy
 * @Date: 2019/1/23 16:46
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Api(value = "用户登录注册", description = "用于用户登录注册")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation(value = "用户注册", notes = "用于用户注册")
    public ResponseMessageUtils<?> postUser(@RequestBody UserLoginDTO userLoginDTO){
        //参数判断，省略
        Integer integer = userService.insertUser(userLoginDTO);
        if (integer > 0) {
            return ResponseMessageUtils.ok();
        }
        return ResponseMessageUtils.error("注册失败！",201);
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "用于用户登录")
    public ResponseMessageUtils<ReturnUserDTO> login(@RequestBody UserLoginDTO userLoginDTO){
        return ResponseMessageUtils.ok(userService.login(userLoginDTO));
    }
}
