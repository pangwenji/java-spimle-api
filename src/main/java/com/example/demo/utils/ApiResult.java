package com.example.demo.utils;

public class ApiResult<T> {
    public  String message;
    public  Integer  code;
    public  T data;
    public ApiResult() {
    }

    public ApiResult(String message, Integer code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
