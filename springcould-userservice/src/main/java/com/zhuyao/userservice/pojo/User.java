package com.zhuyao.userservice.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Author: zy
 * @Date: 2019/1/23 15:23
 * @Version 1.0
 * @Description
 */
@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements UserDetails, Serializable {

    @ApiModelProperty(value = "ID", dataType = "Long")
    Long id;

    @ApiModelProperty(value = "用户名字", dataType = "String")
    String username;

    @ApiModelProperty(value = "用户密码", dataType = "String")
    String password;

    @ApiModelProperty(value = "用户权限", dataType = "List")
    List<Role> authorities;

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}

