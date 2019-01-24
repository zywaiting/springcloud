package com.zhuyao.userservice.mapper;

import com.zhuyao.userservice.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: zy
 * @Date: 2019/1/23 16:40
 * @Version 1.0
 * @Description
 */
@Mapper
public interface UserMapper {
    Integer insertUser(User user);

    User findByUsername(@Param("username") String username);
}
