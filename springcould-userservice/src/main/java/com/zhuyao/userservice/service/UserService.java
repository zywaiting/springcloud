package com.zhuyao.userservice.service;

import com.zhuyao.userservice.dto.ReturnUserDTO;
import com.zhuyao.userservice.dto.UserLoginDTO;

/**
 * @Author: zy
 * @Date: 2019/1/23 16:37
 * @Version 1.0
 * @Description
 */
public interface UserService {
    /**
     * 用户注册
     * @param userLoginDTO
     */
    Integer insertUser(UserLoginDTO userLoginDTO);

    ReturnUserDTO login(UserLoginDTO userLoginDTO);
}
