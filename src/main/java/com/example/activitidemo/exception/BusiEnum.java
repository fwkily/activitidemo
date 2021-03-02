package com.example.activitidemo.exception;

public enum BusiEnum {
    SUCCESS(200, "SUCCESS"),
    FAILE(500,"系统错误");

    private Integer code;
    private String message;

    private BusiEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}