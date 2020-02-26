package com.javaguru.shoppinglist.exeptions;

public class UserValidationException extends RuntimeException {
    public UserValidationException(String messages) {
        super(messages);
    }
}
