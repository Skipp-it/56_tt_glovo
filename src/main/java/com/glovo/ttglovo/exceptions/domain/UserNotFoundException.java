package com.glovo.ttglovo.exceptions.domain;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}
