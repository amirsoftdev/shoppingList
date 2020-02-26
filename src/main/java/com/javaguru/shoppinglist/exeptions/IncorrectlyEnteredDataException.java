package com.javaguru.shoppinglist.exeptions;

public class IncorrectlyEnteredDataException extends RuntimeException {
    public IncorrectlyEnteredDataException(String messages) {
        super(messages);
    }

}
