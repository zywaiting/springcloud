package com.zhuyao.userservice.client;


import com.zhuyao.userservice.client.hystrix.AuthServiceHystrix;
import com.zhuyao.userservice.pojo.JWT;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: zy
 * @Date: 2019/1/23 16:38
 * @Version 1.0
 * @Description
 */

@FeignClient(value = "uaa-service",fallback = AuthServiceHystrix.class )
public interface AuthServiceClient {

    @PostMapping(value = "/oauth/token")
    JWT getToken(@RequestHeader(value = "Authorization") String authorization, @RequestParam("grant_type") String type,
                 @RequestParam("username") String username, @RequestParam("password") String password);

}



