package com.example.activitidemo.exception;


public class BaseHandlerException extends RuntimeException implements IException{

    private static final long serialVersionUID = 1L;

    private int code = 0;

    private String message = null;

    public BaseHandlerException(int code,String message){
        this.code = code;
        this.message = message;
    }


    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"code\": ").append(this.code).append(", message: \"").append(this.message).append("\"}");
        return stringBuilder.toString();
    }
}
