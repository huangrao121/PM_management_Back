package com.example.pmsystem.jwt;

import com.example.pmsystem.pojo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.sql.Date;

@Configuration
public class JWTUtils {
    private static String key;
    private static long expiration;

    @Autowired
    public JWTUtils(JWTconfig jwTconfig){
        key = jwTconfig.getSecretKey();
        expiration = jwTconfig.getExpiration();
    }

    public static String jwtGenerator(User user){
        byte[] keyByte = key.getBytes();
        SecretKey sk = new SecretKeySpec(keyByte, "HmacSHA512");
        String username = user.getUsername();
        String email = user.getEmail();

        return Jwts.builder()
                .claim("user name", username)
                .claim("email", email)
                .expiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(sk)
                .compact();

    }

    public static Claims parseJwt(String token){
        byte[] keyByte = key.getBytes();
        SecretKey sk = new SecretKeySpec(keyByte, "HmacSHA512");
        return Jwts.parser()
                .verifyWith(sk)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
