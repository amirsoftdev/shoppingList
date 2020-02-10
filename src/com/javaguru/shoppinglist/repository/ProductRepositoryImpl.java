package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.exeptions.ItemNotFoundException;
import com.javaguru.shoppinglist.exeptions.UserValidationException;
import com.javaguru.shoppinglist.service.ProductRepository;

import java.util.HashMap;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {

    private Map<Long, Product> productRepository = new HashMap<>();
    private Long productIdSequence = 0L;

    @Override
    public boolean isProductUnique(String productName) {
        for (Product product : productRepository.values()) {
            if (productName.equals(product.getName())) {
                throw new UserValidationException("This product has already crated before");
            }
        }
        return true;
    }

    @Override
    public Product findProduct(Long productId) {
        if (productRepository.containsKey(productId)) {
            return productRepository.get(productId);

        } else {
            throw new ItemNotFoundException("Product with + " + productId + " ID not found");
        }

    }


    @Override

    public Product updateProduct(Long updateProductId) {
        Product product = new Product();
        if (productRepository.containsKey(updateProductId)) {
            updateProductId = productIdSequence;
        } else {
            throw new UserValidationException("Wrong product id, its not possible to update your product");
        }

        productRepository.put(productIdSequence, product);
        return product;

    }

    @Override
    public Boolean deleteProduct(Long idToDelete) {
        if (productRepository.containsKey(idToDelete)) {
            idToDelete = productIdSequence;
            productRepository.remove(idToDelete);
            return true;
        } else {
            throw new UserValidationException("Wrong product id, its not possible to delete product");
        }


    }

    @Override
    public Product addProduct(Product product) {
        checkNotNull(product);
        product.setId(productIdSequence);
        productRepository.put(productIdSequence, product);
        productIdSequence++;
        return product;
    }
}

