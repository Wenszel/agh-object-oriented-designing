package pl.edu.agh.internetshop.discount;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.data.Product;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SelectedProductsDiscountStrategyTest {
    @Test
    public void testApplyDiscount() {
        Product product = mock(Product.class);
        when(product.getPrice()).thenReturn(new BigDecimal("100"));
        Set<Product> products = new HashSet<>();
        products.add(product);
        SelectedProductsDiscountStrategy selectedProductsDiscountStrategy =
                new SelectedProductsDiscountStrategy(products, new BigDecimal("0.1"));

        BigDecimal discount = selectedProductsDiscountStrategy.applyDiscount(product);

        assertEquals(new BigDecimal("10.0"), discount);
    }

    @Test
    public void testApplyDiscount_whenProductIsNotInSet() {
        Product product = mock(Product.class);
        when(product.getPrice()).thenReturn(new BigDecimal("100.0"));
        Set<Product> products = new HashSet<>();
        SelectedProductsDiscountStrategy selectedProductsDiscountStrategy =
                new SelectedProductsDiscountStrategy(products, new BigDecimal("0.1"));

        BigDecimal discount = selectedProductsDiscountStrategy.applyDiscount(product);

        assertEquals(new BigDecimal("100.0"), discount);
    }
}
