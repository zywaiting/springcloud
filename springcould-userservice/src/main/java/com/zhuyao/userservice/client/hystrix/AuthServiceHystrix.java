package com.zhuyao.userservice.client.hystrix;

import com.zhuyao.userservice.client.AuthServiceClient;
import com.zhuyao.userservice.pojo.JWT;
import com.zhuyao.userservice.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @Author: zy
 * @Date: 2019/1/23 16:38
 * @Version 1.0
 * @Description
 */
@Component
public class AuthServiceHystrix implements AuthServiceClient {
    public JWT getToken(String authorization, String type, String username, String password) {
        return null;
    }
}
