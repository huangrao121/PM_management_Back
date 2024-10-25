package com.example.pmsystem.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class UserDTO {
    private String username;
    private String email;
    private String password;
    private String cellPhone;
    private LocalDateTime updateAt;
}
