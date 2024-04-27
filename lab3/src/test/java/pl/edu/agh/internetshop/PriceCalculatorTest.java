package pl.edu.agh.internetshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import pl.edu.agh.internetshop.discount.DiscountStrategy;
import pl.edu.agh.internetshop.data.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class PriceCalculatorTest {
    private Map<Product, Integer> productsWithQuantity;
    private DiscountStrategy discountStrategy;
    private PriceCalculator priceCalculator;
    private Product product1;
    private BigDecimal tax;

    @BeforeEach
    public void setUp() {
        product1 = mock(Product.class);
        Product product2 = mock(Product.class);
        when(product1.getPrice()).thenReturn(new BigDecimal("100.00"));
        when(product2.getPrice()).thenReturn(new BigDecimal("200.00"));
        productsWithQuantity = new HashMap<>();
        productsWithQuantity.put(product1, 2);
        productsWithQuantity.put(product2, 1);
        discountStrategy = getNoDiscountMock();
        tax = new BigDecimal("1.23");
        priceCalculator = new PriceCalculator(productsWithQuantity, discountStrategy, tax);
    }

    @Test
    public void testGetPrice() {
        BigDecimal expectedPrice = new BigDecimal("400.00");
        assertEquals(expectedPrice, priceCalculator.getPrice());
    }

    @Test
    public void testGetPriceWithTaxes() {
        BigDecimal expectedPriceWithTax = new BigDecimal("400.00").multiply(tax).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expectedPriceWithTax, priceCalculator.getPriceWithTaxes());
    }

    @Test
    public void testGetPriceWithTaxesWithRoundingUp() {
        setUpRoundingTest(new BigDecimal("155.556"));

        BigDecimal expectedRoundedPrice = new BigDecimal("155.56");
        assertEquals(expectedRoundedPrice, priceCalculator.getPriceWithTaxes());
    }

    @Test
    public void testGetPriceWithTaxesWithRoundingDown() {
        setUpRoundingTest(new BigDecimal("100.554"));

        BigDecimal expectedPriceWithTax = new BigDecimal("100.56");
        assertEquals(expectedPriceWithTax, priceCalculator.getPriceWithTaxes());
    }

    private void setUpRoundingTest(BigDecimal price) {
        productsWithQuantity.clear();
        when(product1.getPrice()).thenReturn(price);
        productsWithQuantity.put(product1, 1);
        tax = new BigDecimal("1.00");
        priceCalculator = new PriceCalculator(productsWithQuantity, discountStrategy, tax);
    }

    private DiscountStrategy getNoDiscountMock() {
        DiscountStrategy discountStrategy = mock(DiscountStrategy.class);
        when(discountStrategy.applyDiscount(any(Product.class))).thenAnswer(invocation -> {
            Product product = invocation.getArgument(0, Product.class);
            return product.getPrice();
        });
        return discountStrategy;
    }
}
