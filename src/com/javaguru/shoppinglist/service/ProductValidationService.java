package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.exeptions.IncorrectlyEnteredDataException;
import com.javaguru.shoppinglist.exeptions.UserValidationException;

import java.math.BigDecimal;

public class ProductValidationService {


    public void validate(Product product) throws UserValidationException {
        if (product.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new IncorrectlyEnteredDataException("Price cannot be smaller that 0");

        }
        if (product.getDiscount().compareTo(BigDecimal.valueOf(0)) < 0 || product.getDiscount().compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new IncorrectlyEnteredDataException("Discount cannot be smaller that 0 % or bigger that 100 % ");


        }
        if (product.getName() == null || product.getName().length() < 3 || product.getName().length() > 32) {
            throw new IncorrectlyEnteredDataException("Product name cannot be smaller that 3 and bigger that 32");
        }
        if (product.getPrice().intValue() < 20) {
            product.setDiscount(BigDecimal.ZERO);
            throw new IncorrectlyEnteredDataException("Discount on this price not possible, because price is < 20$");
        }

    }
}
