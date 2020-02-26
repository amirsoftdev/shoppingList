package com.javaguru.shoppinglist.exeptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String messages) {
        super(messages);
    }
}
