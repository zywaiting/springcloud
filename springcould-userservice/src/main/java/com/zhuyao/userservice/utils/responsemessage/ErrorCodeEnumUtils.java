package com.zhuyao.userservice.utils.responsemessage;

/**
 * @author zy
 * @since 2017年07月28日
 */
public enum ErrorCodeEnumUtils {
    TOKEN_VALID(50008, "非法的token"),
    TOKEN_MULTI_LOGIN(50012, "其他客户端登录了"),
    TOKEN_EXPIRED(50014, "Token 过期了");

    private int code;
    private String message;

    ErrorCodeEnumUtils(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
