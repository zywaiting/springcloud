package com.zhuyao.uaa.service.impl;

import com.zhuyao.uaa.mapper.UserMapper;
import com.zhuyao.uaa.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author: zy
 * @Date: 2019/1/23 14:56
 * @Version 1.0
 * @Description
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUsername = userMapper.findByUsername(username);
        return byUsername;
    }
}
