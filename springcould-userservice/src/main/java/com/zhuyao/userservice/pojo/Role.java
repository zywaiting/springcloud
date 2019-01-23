package com.zhuyao.userservice.pojo;

import org.springframework.security.core.GrantedAuthority;

/**
 * @Author: zy
 * @Date: 2019/1/23 15:24
 * @Version 1.0
 * @Description
 */
public class Role implements GrantedAuthority {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
