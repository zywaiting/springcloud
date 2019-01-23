package com.zhuyao.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: zy
 * @Date: 2019/1/23 14:39
 * @Version 1.0
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class UaaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UaaServiceApplication.class, args);
	}
}
