package com.junhao.god.entity;
import lombok.Data;
//生成时间
import java.time.LocalDateTime;
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String targetSchool;
    private String major;
    private LocalDateTime createdAt;
}
