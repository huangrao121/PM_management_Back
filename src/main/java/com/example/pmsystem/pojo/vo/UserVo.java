package com.example.pmsystem.pojo.vo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserVo {
    private String email;
    private String userName;
    private String jwtToken;
}
