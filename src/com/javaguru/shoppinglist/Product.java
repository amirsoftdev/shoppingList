package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.HashMap;


public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private String category;
    private BigDecimal discount;
    private String description;

    public void validate() throws UserValidationException {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new UserValidationException("Price cannot be smaller that 0");

        } else if (discount.compareTo(BigDecimal.valueOf(0)) < 0 || discount.compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new UserValidationException("Discount cannot be smaller that 0 % or bigger that 100 % ");


        } else if (name == null || name.length() < 3 || name.length() > 32) {
            throw new UserValidationException("Price name cannot be smaller that 3 and bigger that 32");
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


}
