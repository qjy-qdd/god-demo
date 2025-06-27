package com.junhao.god.mapper;

import com.junhao.god.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    // 查询用户名是否存在
    @Select("SELECT * FROM user WHERE username = #{username}")
    List<User> selectByUsername(String username);

    // 插入用户
    @Insert("INSERT INTO user (username, password) VALUES (#{username}, #{password})")
    void insert(User user);
    void insertUser(User user);
    List<User> findBySubject(String subject);
    List<User> findByMajor(String major);
    List<User> findByTargetSchool(String school);
}