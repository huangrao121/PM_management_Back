package com.example.pmsystem.server.mapper;

import com.example.pmsystem.pojo.dto.UserDTO;
import com.example.pmsystem.pojo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper{

    @Select("select * from users where email=#{email} and password=#{password}")
    User login(UserDTO userDTO);

    @Insert("insert into users (username, email, password) values (#{username},#{email},#{password})")
    User register(UserDTO userDTO);
}
