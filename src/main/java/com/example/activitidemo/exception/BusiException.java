package com.example.activitidemo.exception;

public class BusiException extends BaseHandlerException{
    private static final long serialVersionUID = 1L;
    private BusiEnum errorCode;

    public BusiException(Integer code, String message) {
        super(code, message);
    }

    public BusiException(BusiEnum errorCode) {
        super(errorCode.getCode(), errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BusiException(BusiEnum errorCode, Exception e) {
        super(errorCode.getCode(), e.getMessage());
        this.errorCode = errorCode;
    }

    public BusiException(BusiEnum errorCode, String msg) {
        super(errorCode.getCode(), errorCode.getMessage() + "[" + msg + "]");
        this.errorCode = errorCode;
    }

    public BusiException(BusiEnum errorCode, String exceptionMsg, Exception e) {
        super(errorCode.getCode(), exceptionMsg);
        this.errorCode = errorCode;
    }

    public BusiEnum getErrorCode() {
        return this.errorCode;
    }

}
