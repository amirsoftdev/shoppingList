package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.exeptions.ItemNotFoundException;
import com.javaguru.shoppinglist.exeptions.UserValidationException;
import com.javaguru.shoppinglist.repository.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    private final ProductRepositoryImpl repository;
    private final ProductValidationService validationService;

    @Autowired
    public ProductService(ProductRepositoryImpl repository, ProductValidationService validationService){
        this.repository = repository;
        this.validationService = validationService;
    }

    public Long addProduct(Product product) {
        validationService.checkNotNull(product);
        Product createdProduct = repository.addProduct(product);
        return createdProduct.getId();
    }

    public Product findProduct(Long productId) {
        Product product = repository.findProduct(productId);
        if (product == null) {
            throw new ItemNotFoundException("Product with + " + productId + " ID not found");
        }
        return product;

    }

    public Boolean deleteProduct(Long idToDelete) {
        if (idToDelete == null) {
            throw new UserValidationException("Wrong product id, its not possible to delete product");
        }
        Boolean product = repository.deleteProduct(idToDelete);
        return product;

    }

    public Product updateProduct(Long productId, Product product) {
        if (product == null) {
            throw new UserValidationException("Wrong product id, its not possible to update your product");
        }
        Product newProduct = repository.updateProduct(productId, product);
        return newProduct;
    }






}
