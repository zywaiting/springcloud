package com.zhuyao.userservice.service.impl;

import com.zhuyao.userservice.client.AuthServiceClient;
import com.zhuyao.userservice.dto.UserLoginDTO;
import com.zhuyao.userservice.exception.UserLoginException;
import com.zhuyao.userservice.mapper.UserMapper;
import com.zhuyao.userservice.pojo.JWT;
import com.zhuyao.userservice.pojo.User;
import com.zhuyao.userservice.service.UserService;
import com.zhuyao.userservice.utils.BPwdEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zy
 * @Date: 2019/1/23 16:38
 * @Version 1.0
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AuthServiceClient client;

    public void insertUser(String username, String password) {
        User user=new User();
        user.setUsername(username);
        user.setPassword(BPwdEncoderUtil.BCryptPassword(password));
        userMapper.insertUser(user);
    }

    public UserLoginDTO login(String username,String password){
        User user=userMapper.findByUsername(username);
        if (null == user) {
            throw new UserLoginException("error username");
        }
        if(!BPwdEncoderUtil.matches(password,user.getPassword())){
            throw new UserLoginException("error password");
        }
        // 获取token
        JWT jwt=client.getToken("Basic dXNlci1zZXJ2aWNlOjEyMzQ1Ng==","password",username,password);
        // 获得用户菜单
        if(jwt==null){
            throw new UserLoginException("error internal");
        }
        UserLoginDTO userLoginDTO=new UserLoginDTO();
        userLoginDTO.setJwt(jwt);
        userLoginDTO.setUser(user);
        return userLoginDTO;

    }
}
