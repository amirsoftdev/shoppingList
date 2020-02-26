package service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.exeptions.IncorrectlyEnteredDataException;
import com.javaguru.shoppinglist.service.ProductValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(MockitoJUnitRunner.class)

public class ProductValidationServiceTest {
    private static final String PRODUCT_NAME_CORRECT = "Apple";
    private static final BigDecimal PRODUCT_PRICE_CORRECT = new BigDecimal(40);
    private static final BigDecimal PRODUCT_DISCOUNT_CORRECT = new BigDecimal(50);

    private static final String PRODUCT_NAME_WRONG_TO_SHORT = "A";
    private static final String PRODUCT_NAME_WRONG_TO_LONG = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
    private static final BigDecimal PRODUCT_DISCOUNT_TO_SMALL = new BigDecimal(-1);
    private static final BigDecimal PRODUCT_DISCOUNT_TO_BIG = new BigDecimal(150);
    private static final BigDecimal PRODUCT_PRICE_TO_ZERO = new BigDecimal(-1);


    @InjectMocks
    private ProductValidationService victim;

    @Test
    public void shouldThrowValidationException() {
        assertThatThrownBy(() -> victim.checkNotNull(null))
                .isInstanceOf(IncorrectlyEnteredDataException.class)
                .hasMessage("Product cant be null, please try again");
    }

    @Test
    public void shouldCheckProductIsNotNull() {
        Product product = new Product();
        victim.checkNotNull(product);
    }

    @Test
    public void shouldCheckProduct() {
        victim.validate(productCorrect());
    }

    @Test

    public void ShouldCheckProductNameShorterThatThree() {
        victim.validate(productNameShorterThatThree());
    }

    @Test

    public void ShouldCheckProductNameLongerThatThree() {
        victim.validate(productNameLongerThatThirtyTwo());
    }


    @Test

    public void ShouldCheckProductDiscountSmallerThatZero() {
        victim.validate(productDiscountSmallerThatZero());

    }

    @Test

    public void ShouldCheckProductDiscountBiggerThatOneHundred() {
        victim.validate(productDiscountBiggerThatOneHundred());

    }

    @Test

    public void ShouldCheckProductPriceSmallerThatZero() {
        victim.validate(productPriceSmallerThatZero());

    }


    @Test

    public void ShouldCheckProductPriceAndDiscount() {
        victim.validate(productPriceToSmallToDiscount());

    }


    private Product productCorrect() {
        Product product = new Product();
        product.setName(PRODUCT_NAME_CORRECT);
        product.setPrice(PRODUCT_PRICE_CORRECT);
        product.setDiscount(PRODUCT_DISCOUNT_CORRECT);
        return product;

    }

    private Product productNameShorterThatThree() {
        Product product = new Product();
        product.setName(PRODUCT_NAME_WRONG_TO_SHORT);
        product.setPrice(PRODUCT_PRICE_CORRECT);
        product.setDiscount(PRODUCT_DISCOUNT_CORRECT);
        return product;

    }

    private Product productNameLongerThatThirtyTwo() {
        Product product = new Product();
        product.setName(PRODUCT_NAME_WRONG_TO_LONG);
        product.setPrice(PRODUCT_PRICE_CORRECT);
        product.setDiscount(PRODUCT_DISCOUNT_CORRECT);
        return product;

    }

    private Product productDiscountBiggerThatOneHundred() {
        Product product = new Product();
        product.setName(PRODUCT_NAME_CORRECT);
        product.setPrice(PRODUCT_PRICE_CORRECT);
        product.setDiscount(PRODUCT_DISCOUNT_TO_BIG);
        return product;

    }
    private Product productDiscountSmallerThatZero() {
        Product product = new Product();
        product.setName(PRODUCT_NAME_CORRECT);
        product.setPrice(PRODUCT_PRICE_CORRECT);
        product.setDiscount(PRODUCT_DISCOUNT_TO_SMALL);
        return product;

    }
    private Product productPriceSmallerThatZero() {
        Product product = new Product();
        product.setName(PRODUCT_NAME_CORRECT);
        product.setPrice(PRODUCT_PRICE_TO_ZERO);
        return product;

    }

    private Product productPriceToSmallToDiscount() {
        Product product = new Product();
        product.setName(PRODUCT_NAME_CORRECT);
        product.setPrice(PRODUCT_PRICE_TO_ZERO);
        product.setDiscount(PRODUCT_DISCOUNT_CORRECT);
        return product;

    }

}
