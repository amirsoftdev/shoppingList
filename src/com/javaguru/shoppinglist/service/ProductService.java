package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepositoryImpl;
import com.javaguru.shoppinglist.service.ProductValidationService;

public class ProductService  {

    private ProductRepositoryImpl repository = new ProductRepositoryImpl();
    private ProductValidationService validationService = new ProductValidationService();


    public Long addProduct(Product product) {
        Product createdProduct = repository.addProduct(product);
        return createdProduct.getId();
    }

    public Product findProduct(Long productId) {
        return repository.findProduct(productId);

    }
    public boolean deleteProduct(Long idToDelete){
        return repository.deleteProduct(idToDelete);

    }

    public Product updateProduct(Long productId) {
        return repository.updateProduct(productId);
    }




}
