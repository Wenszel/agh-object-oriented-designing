package pl.edu.agh.internetshop.discount;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.data.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AllProductDiscountStrategyTest {
    @Test
    public void testApplyDiscount() {
        AllProductsDiscountStrategy allProductsDiscountStrategy =
                new AllProductsDiscountStrategy(new BigDecimal("0.1"));
        Product product = mock(Product.class);
        when(product.getPrice()).thenReturn(new BigDecimal("100.0"));
        BigDecimal price = allProductsDiscountStrategy.applyDiscount(product);
        assertEquals(price, new BigDecimal("10.00"));
    }
}
