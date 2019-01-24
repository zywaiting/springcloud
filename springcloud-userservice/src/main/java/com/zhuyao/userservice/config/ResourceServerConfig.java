package com.zhuyao.userservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @Author: zy
 * @Date: 2019/1/23 16:29
 * @Version 1.0
 * @Description
 */
@Configuration
@EnableResourceServer
@Slf4j
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    TokenStore tokenStore;

    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .regexMatchers(".*swagger.*",".*v2.*",".*webjars.*","/user/login.*","/user/registry.*","/user/test.*").permitAll()
                .antMatchers("/**").authenticated();
    }

    public void configure(ResourceServerSecurityConfigurer resources) {
        log.info("Configuring ResourceServerSecurityConfigurer ");
        resources.resourceId("user-service").tokenStore(tokenStore);
    }
}
