package com.example.pmsystem.server.service.impls;

import com.example.pmsystem.server.mapper.UserMapper;
import com.example.pmsystem.pojo.dto.UserDTO;
import com.example.pmsystem.pojo.entity.User;
import com.example.pmsystem.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(UserDTO userDTO) {
        return userMapper.login(userDTO);
    }

    @Override
    public User register(UserDTO userDTO) {
        return userMapper.register(userDTO);
    }
}
