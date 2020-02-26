package com.javaguru.shoppinglist.exeptions;

public class IncorrectlyEnteredDataException extends RuntimeException {
    public IncorrectlyEnteredDataException(String message) {
        super(message);
    }

}
