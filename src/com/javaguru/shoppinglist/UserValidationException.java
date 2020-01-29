package com.javaguru.shoppinglist;

public class UserValidationException extends RuntimeException {
    public UserValidationException(String message){
        super(message);
    }
}
