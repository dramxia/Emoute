package com.ldzy.dao;

import com.ldzy.domain.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Select("select * from user where email=#{email} and password=#{password}")
    public User findByUser(User user);
}
