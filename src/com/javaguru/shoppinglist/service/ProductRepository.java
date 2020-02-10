package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.exeptions.IncorrectlyEnteredDataException;

public interface ProductRepository {

    boolean isProductUnique(String productName);

    Product findProduct(Long productId);

    Product updateProduct(Long updateProductId);

    Boolean deleteProduct(Long idToDelete);

    Product addProduct(Product product);

    default void checkNotNull(Product product) {
        if (product == null) {
            throw new IncorrectlyEnteredDataException("Product cant be null, please try again");
        }
    }

}
