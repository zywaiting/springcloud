package com.zhuyao.userservice.dto;

import com.zhuyao.userservice.pojo.JWT;
import com.zhuyao.userservice.pojo.User;

/**
 * @Author: zy
 * @Date: 2019/1/23 16:38
 * @Version 1.0
 * @Description
 */
public class ReturnUserDTO {

    private JWT jwt;

    private User user;

    public JWT getJwt() {
        return jwt;
    }

    public void setJwt(JWT jwt) {
        this.jwt = jwt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
