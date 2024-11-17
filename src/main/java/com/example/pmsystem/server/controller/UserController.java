package com.example.pmsystem.server.controller;

import com.example.pmsystem.jwt.JWTUtils;
import com.example.pmsystem.pojo.dto.UserDTO;
import com.example.pmsystem.pojo.entity.User;
import com.example.pmsystem.pojo.vo.UserVo;
import com.example.pmsystem.resultTemplate.Result;
import com.example.pmsystem.server.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    //Login function
    @PostMapping(value = "/login")
    public Result<UserVo> login(@RequestBody UserDTO userDTO, HttpServletResponse response){
        log.info("The decode value: ");
        User user = userService.login(userDTO);
        if(user!=null){
            String token = JWTUtils.jwtGenerator(user);
            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            cookie.setMaxAge(7200);

            response.addCookie(cookie);
            UserVo userVo = UserVo.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .userName(user.getUsername())
                    .jwtToken(token)
                    .build();
            return Result.success(userVo);
        }
        return Result.error("user name or password is incorrect");
    }

    //Register function
    @PostMapping("/register")
    public Result register(@RequestBody UserDTO userDTO){
        log.info("register is: {}", userDTO);
        int result = userService.register(userDTO);
        log.info("register result is: {}",result);
        return Result.success();
    }

    @GetMapping("/current")
    public Result<UserVo> verify(HttpServletRequest req){
        String username = (String) req.getAttribute("username");
        String email = (String) req.getAttribute("email");
        long id = (long)req.getAttribute("id");
        log.info("user controller verify api: {},{}",username,email);
        UserVo userVo = UserVo.builder()
                .id(id)
                .userName(username)
                .email(email)
                .build();
        return Result.success(userVo);
    }
}
