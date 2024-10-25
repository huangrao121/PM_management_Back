package com.example.pmsystem.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private String cellPhone;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
