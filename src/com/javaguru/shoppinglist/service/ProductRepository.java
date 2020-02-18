package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;

public interface ProductRepository {

    boolean isProductUnique(String productName);

    Product findProduct(Long productId);

    Product updateProduct(Long updateProductId,Product product);

    Boolean deleteProduct(Long idToDelete);

    Product addProduct(Product product);


}
