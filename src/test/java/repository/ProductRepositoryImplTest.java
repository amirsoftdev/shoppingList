package repository;

import com.javaguru.shoppinglist.ProductCategory;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepositoryImpl;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;
import java.util.Optional;

public class ProductRepositoryImplTest {
    private static final Long PRODUCT_ID = 0L;
    private static final String PRODUCT_NAME = "Apple";
    private static final BigDecimal PRODUCT_PRICE = new BigDecimal(8);
    private static final ProductCategory PRODUCT_CATEGORY = ProductCategory.FRUITS;
    private static final BigDecimal PRODUCT_DISCOUNT = new BigDecimal(50);
    private static final String PRODUCT_DESCRIPTION = "Very tasty apples from Arabic Emirates";

    private ProductRepositoryImpl victim = new ProductRepositoryImpl();

    private Product product = product();
    @Test
    public void shouldAddProduct() {
        Product result = victim.addProduct(product);

        assertThat(result).isEqualTo(expectedProduct());
    }

    @Test
    public void shouldFindProduct() {
        victim.addProduct(product);

        Optional<Product> result = Optional.ofNullable(victim.findProduct(PRODUCT_ID));
        assertThat(result).isNotEmpty();
        assertThat(result).hasValue(expectedProduct());
    }

    @Test
    public void shouldCheckIsProductUnique() {
        Product product = new Product();
        victim.addProduct(product);
        boolean result = victim.isProductUnique(PRODUCT_NAME);
        assertThat(result).isTrue();
    }

    private Product expectedProduct() {
        Product product = new Product();
        product.setId(PRODUCT_ID);
        product.setName(PRODUCT_NAME);
        product.setPrice(PRODUCT_PRICE);
        product.setCategory(PRODUCT_CATEGORY);
        product.setDiscount(PRODUCT_DISCOUNT);
        product.setDescription(PRODUCT_DESCRIPTION);
        return product;
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
