package com.javaguru.shoppinglist.service;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.exeptions.IncorrectlyEnteredDataException;
import com.javaguru.shoppinglist.repository.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductValidationService {

    private final ProductRepositoryImpl repository;

    @Autowired
    public ProductValidationService(ProductRepositoryImpl repository) {
        this.repository = repository;
    }

    public void validate(Product product){
        checkNotNull(product);
        priceValidate(product);
        discountValidate(product);
        nameValidate(product);
    }


     public void checkNotNull(Product product) {
        if (product == null) {
            throw new IncorrectlyEnteredDataException("Product cant be null, please try again");
        }
    }

    private void priceValidate(Product product) {
        if (product.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new IncorrectlyEnteredDataException("Price cannot be smaller that 0");
        }
    }

    private void discountValidate(Product product) {
        if (product.getDiscount().compareTo(BigDecimal.valueOf(0)) < 0 || product.getDiscount().compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new IncorrectlyEnteredDataException("Discount cannot be smaller that 0 % or bigger that 100 % ");
        }
        if (product.getPrice().compareTo(BigDecimal.valueOf(20)) < 0) {
            product.setDiscount(BigDecimal.ZERO);
            throw new IncorrectlyEnteredDataException("Discount on this price not possible, because price is < 20$");

        }
    }

    private void nameValidate(Product product) {
        if (product.getName() == null || product.getName().length() < 3 || product.getName().length() > 32) {
            throw new IncorrectlyEnteredDataException("Product name cannot be smaller that 3 and bigger that 32");
        }
    }


}

