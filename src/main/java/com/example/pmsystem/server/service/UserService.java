package com.example.pmsystem.server.service;


import com.example.pmsystem.pojo.dto.UserDTO;
import com.example.pmsystem.pojo.entity.User;

public interface UserService {

    User login(UserDTO userDTO);

    User register(UserDTO userDTO);
}
