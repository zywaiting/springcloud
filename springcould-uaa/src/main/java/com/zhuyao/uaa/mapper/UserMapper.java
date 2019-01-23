package com.zhuyao.uaa.mapper;

import com.zhuyao.uaa.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zy
 * @Date: 2019/1/23 15:06
 * @Version 1.0
 * @Description
 */
@Mapper
public interface UserMapper {
    User findByUsername(String username);
}
