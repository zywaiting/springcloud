package com.zhuyao.userservice.exception;

/**
 * @Author: zy
 * @Date: 2019/1/23 16:38
 * @Version 1.0
 * @Description
 */
public class UserLoginException extends RuntimeException{

    public UserLoginException(String message) {
        super(message);
    }

}
