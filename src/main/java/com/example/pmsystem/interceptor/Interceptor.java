package com.example.pmsystem.interceptor;

import com.example.pmsystem.jwt.JWTUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
@Slf4j
public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        String token = cookies[0].getValue();
        try{
            Claims claims = JWTUtils.parseJwt(token);
            String username = claims.get("user name", String.class);
            String email = claims.get("email", String.class);
            log.info("User name is {}, email is {}", username, email);
            request.setAttribute("username", username);
            request.setAttribute("email", email);
        }catch (Exception e){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Authorization is missing");
            return false;
        }
        return true;
    }
}
