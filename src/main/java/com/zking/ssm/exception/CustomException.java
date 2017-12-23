package com.zking.ssm.exception;

/**
 * 系统自定义异常类，针对预期的异常，需要在程序中抛出此类的异常
 */
public class CustomException extends Exception {

    static final long serialVersionUID = -6687516993124229948L;

    //异常信息
    private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
