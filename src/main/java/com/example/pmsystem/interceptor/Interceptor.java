package com.example.pmsystem.interceptor;

import com.example.pmsystem.jwt.JWTUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Enumeration;


@Component
@Slf4j
public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorizationHeader = request.getHeader("Authorization");
        System.out.println(authorizationHeader);
        try{
//            Cookie[] cookies = request.getCookies();
//            String token = cookies[0].getValue();
//            log.info("interceptor stage token is {}",token);
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = authorizationHeader.substring(7);
                Claims claims = JWTUtils.parseJwt(token);
                long id = claims.get("id", Long.class);
                String username = claims.get("user name", String.class);
                String email = claims.get("email", String.class);
                log.info("Through Interceptor user id is {} name is {}, email is {}", id, username, email);
                request.setAttribute("id", id);
                request.setAttribute("username", username);
                request.setAttribute("email", email);
            }
        }catch (Exception e){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Authorization is missing");
            return false;
        }
        return true;
    }
}
