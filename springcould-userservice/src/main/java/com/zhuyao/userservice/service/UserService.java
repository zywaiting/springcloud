package com.zhuyao.userservice.service;

import com.zhuyao.userservice.dto.UserLoginDTO;

/**
 * @Author: zy
 * @Date: 2019/1/23 16:37
 * @Version 1.0
 * @Description
 */
public interface UserService {
    void insertUser(String username,String password);

    UserLoginDTO login(String username, String password);
}
