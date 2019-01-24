package com.zhuyao.userservice;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zy
 * @Date: 2019/1/23 16:37
 * @Version 1.0
 * @Description
 */
@Configuration
@EnableApolloConfig
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class UserServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
}
