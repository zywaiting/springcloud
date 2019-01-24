package com.zhuyao.userservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * @Author: zy
 * @Date: 2019/1/24 13:02
 * @Version 1.0
 * @Description
 */
@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserLoginDTO implements Serializable {

    @ApiModelProperty(value = "用户名字", dataType = "String")
    String username;

    @ApiModelProperty(value = "用户密码", dataType = "String")
    String password;

    @ApiModelProperty(value = "验证码", dataType = "String")
    String verificationCode;
}
