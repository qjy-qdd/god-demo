package com.junhao.god.service;
import com.junhao.god.bean.param.CommonResponse;
import com.junhao.god.entity.User;
import com.junhao.god.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public CommonResponse registerUser(String username, String rawPassword) {
        // 检查用户名是否已存在
        List<User> existingUser = userMapper.selectByUsername(username);
        if (!existingUser.isEmpty()) {
            System.out.println("用户名已存在");
            return new CommonResponse(1,"用户名已存在");
        }
        // 加密密码
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encodedPassword = encoder.encode(rawPassword);

        // 保存用户
        User user = new User();
        user.setUsername(username);
        user.setPassword(rawPassword);
        userMapper.insert(user);
        return new CommonResponse(0,"注册成功");
    }
}