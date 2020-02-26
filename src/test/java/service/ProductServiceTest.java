package service;

import com.javaguru.shoppinglist.ProductCategory;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.exeptions.ItemNotFoundException;
import com.javaguru.shoppinglist.exeptions.UserValidationException;
import com.javaguru.shoppinglist.repository.ProductRepositoryImpl;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.ProductValidationService;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;


@RunWith(MockitoJUnitRunner.class)

public class ProductServiceTest {
    private static final Long PRODUCT_ID = 0L;
    private static final String PRODUCT_NAME = "Apple";
    private static final BigDecimal PRODUCT_PRICE = new BigDecimal(8);
    private static final ProductCategory PRODUCT_CATEGORY = ProductCategory.FRUITS;
    private static final BigDecimal PRODUCT_DISCOUNT = new BigDecimal(50);
    private static final String PRODUCT_DESCRIPTION = "Very tasty apples from Arabic Emirates";


    @Mock
    private ProductRepositoryImpl repository;

    @Mock
    private ProductValidationService validationService;

    @InjectMocks
    private ProductService victim;

    @Captor
    private ArgumentCaptor<Product> productCaptor;

    @Test
    public void shouldAddProduct() {

        Product product = product();
        when(repository.addProduct(product)).thenReturn(product);

        Long result = victim.addProduct(product);

        verify(validationService).validate(productCaptor.capture());
        Product captorResult = productCaptor.getValue();

        assertThat(captorResult).isEqualTo(product);
        assertThat(product.getId()).isEqualTo(result);

    }


    @Test
    public void shouldFindProductById() {
        when(repository.findProduct(PRODUCT_ID)).thenReturn(product());
        Product result = victim.findProduct(PRODUCT_ID);
        assertThat(result).isEqualTo(product());
    }


    @Test
    public void shouldUpdateProduct() {

        Product product = product();
        when(repository.updateProduct(PRODUCT_ID,product)).thenReturn(product);

        Product result = victim.updateProduct(PRODUCT_ID,product);

        verify(validationService).validate(productCaptor.capture());
        Product captorResult = productCaptor.getValue();

        assertThat(captorResult).isEqualTo(product);
        assertThat(product.getId()).isEqualTo(result);

    }

    @Test
    public void shouldDeleteProduct(){
        Product product = new Product();
        victim.deleteProduct(PRODUCT_ID);
        verify(repository).deleteProduct(PRODUCT_ID);
    }

    @Test
            (expected = ItemNotFoundException.class)
    public void findProductMethodShouldTrowItemNotFoundException(){
        victim.findProduct(null);
    }

    @Test
            (expected = UserValidationException.class)
    public void deleteProductMethodShouldTrowUserValidationException(){
        victim.deleteProduct(null);
    }

    @Test
            (expected = UserValidationException.class)
    public void updateProductMethodShouldTrowUserValidationException(){
        victim.updateProduct(5L, null);
    }


    private Product product() {
        Product product = new Product();
        product.setId(PRODUCT_ID);
        product.setName(PRODUCT_NAME);
        product.setPrice(PRODUCT_PRICE);
        product.setCategory(PRODUCT_CATEGORY);
        product.setDiscount(PRODUCT_DISCOUNT);
        product.setDescription(PRODUCT_DESCRIPTION);
        return product;
    }


}
