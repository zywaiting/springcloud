package com.zhuyao.userservice.service.impl;

import com.zhuyao.userservice.client.AuthServiceClient;
import com.zhuyao.userservice.dto.ReturnUserDTO;
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

    public Integer insertUser(UserLoginDTO userLoginDTO) {
        //TODO 验证码
        User user = new User();
        user.setUsername(userLoginDTO.getUsername());
        user.setPassword(BPwdEncoderUtil.BCryptPassword(userLoginDTO.getPassword()));
        return userMapper.insertUser(user);
    }

    public ReturnUserDTO login(UserLoginDTO userLoginDTO){
        User user=userMapper.findByUsername(userLoginDTO.getUsername());
        if (null == user) {
            throw new UserLoginException("error username");
        }
        if(!BPwdEncoderUtil.matches(userLoginDTO.getPassword(),user.getPassword())){
            throw new UserLoginException("error password");
        }
        // 获取token
        JWT jwt=client.getToken("Basic dXNlci1zZXJ2aWNlOjEyMzQ1Ng==","password",userLoginDTO.getUsername(),userLoginDTO.getPassword());
        // 获得用户菜单
        if(jwt==null){
            throw new UserLoginException("error internal");
        }
        ReturnUserDTO returnUserDTO=new ReturnUserDTO();
        returnUserDTO.setJwt(jwt);
        returnUserDTO.setUser(user);
        return returnUserDTO;
    }
}
