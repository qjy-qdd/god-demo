package com.junhao.god.controller;
import com.junhao.god.bean.param.CommonResponse;
import com.junhao.god.bean.param.UserRequest;
import com.junhao.god.entity.User;
import com.junhao.god.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @CrossOrigin
    @PostMapping("/register")
    public CommonResponse register(@RequestBody UserRequest request) {
        try {

            return userService.registerUser(request.getUsername(), request.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse(1,e.getMessage());
        }
    }
}
