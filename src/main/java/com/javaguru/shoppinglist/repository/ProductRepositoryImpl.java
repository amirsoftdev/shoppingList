package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.exeptions.UserValidationException;
import com.javaguru.shoppinglist.service.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    private Map<Long, Product> productRepository = new HashMap<>();
    private Long productIdSequence = 0L;

    @Override
    public boolean isProductUnique(String productName) {
        for (Product product : productRepository.values()) {
            if (productName.equals(product.getName())) {
                throw new UserValidationException("This product has already created before");
            }
        }
        return true;
    }

    @Override
    public Product findProduct(Long productId) {
        return productRepository.get(productId);

    }

    @Override

    public Product updateProduct(Long updateProductId, Product product) {
        productRepository.put(productIdSequence, product);
        return product;

    }

    @Override
    public Boolean deleteProduct(Long idToDelete) {
        productRepository.remove(idToDelete);
        return true;
    }

    @Override
    public Product addProduct(Product product) {
        product.setId(productIdSequence);
        productRepository.put(productIdSequence, product);
        productIdSequence++;
        return product;
    }


}

