package com.zhuyao.userservice.pojo;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @Author: zy
 * @Date: 2019/1/23 17:14
 * @Version 1.0
 * @Description
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JWT {
    String access_token;
    String token_type;
    String refresh_token;
    int expires_in;
    String scope;
    String jti;
}
