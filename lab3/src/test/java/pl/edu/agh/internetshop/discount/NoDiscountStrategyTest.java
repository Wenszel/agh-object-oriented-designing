package pl.edu.agh.internetshop.discount;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.data.Product;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NoDiscountStrategyTest {
    @Test
    public void testApplyDiscount() {
        NoDiscountStrategy noDiscountStrategy = new NoDiscountStrategy();
        Product product = mock(Product.class);
        when(product.getPrice()).thenReturn(new BigDecimal("100.0"));
        BigDecimal price = noDiscountStrategy.applyDiscount(product);
        assert(price.equals(new BigDecimal("100.0")));
    }
}
