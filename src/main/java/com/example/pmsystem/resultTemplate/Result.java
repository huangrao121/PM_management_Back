package com.example.pmsystem.resultTemplate;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T>{
    private int code;
    private String message;
    private T data;

    public static <T> Result<T> success(){
        Result<T> result = new Result<T>();
        result.message = "return successfully";
        result.code = 1;
        return result;
    }

    public static <T> Result<T> success(T data){
        Result<T> result = new Result<T>();
        result.message = "return successfully with data";
        result.code = 1;
        result.data = data;
        return result;
    }

    public static <T> Result<T> error(String s){
        Result<T> result = new Result<T>();
        result.code = 0;
        result.message = s;
        return result;
    }
}
