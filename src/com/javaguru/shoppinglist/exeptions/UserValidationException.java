package com.javaguru.shoppinglist.exeptions;

public class UserValidationException extends RuntimeException {
    public UserValidationException(String message) {
        super(message);
    }
}
