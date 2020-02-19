package com.minidwep.springboot04.exception;

public class UserLoginException extends RuntimeException {
    public UserLoginException() {
        super("用户不存在");
    }
}
