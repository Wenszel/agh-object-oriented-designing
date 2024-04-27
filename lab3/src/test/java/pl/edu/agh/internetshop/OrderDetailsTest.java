package pl.edu.agh.internetshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.data.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderDetailsTest {
    private OrderDetails orderDetails;

    @BeforeEach
    public void setUp() {
        orderDetails = new OrderDetails();
    }

    @Test
    public void testAddProduct_whenProductNotAdded() {
        Product product = new Product("test", BigDecimal.ONE);

        orderDetails.addProduct(product, 1);

        assertEquals(1, orderDetails.getProductsWithQuantity().size());
    }

    @Test
    public void testAddProduct_whenProductAlreadyAdded() {
        Product product = new Product("test", BigDecimal.ONE);

        orderDetails.addProduct(product, 1);
        orderDetails.addProduct(product, 1);

        assertEquals(1, orderDetails.getProductsWithQuantity().size());
        assertEquals(2, orderDetails.getProductsWithQuantity().get(product));
    }

    @Test
    public void testAddProduct_whenProductsPriceDifferent() {
        Product product1 = new Product("test1", BigDecimal.ONE);
        Product product2 = new Product("test2", BigDecimal.TEN);

        orderDetails.addProduct(product1, 1);
        orderDetails.addProduct(product2, 1);

        assertEquals(2, orderDetails.getProductsWithQuantity().size());
    }

    @Test
    public void testAddProduct_whenNullProduct() {
        Product product = null;

        assertThrows(IllegalArgumentException.class, () -> orderDetails.addProduct(product, 1));
        assertEquals(0, orderDetails.getProductsWithQuantity().size());
    }

    @Test
    public void testAddProduct_whenNegativeQuantity() {
        Product product = new Product("test", BigDecimal.ONE);

        assertThrows(IllegalArgumentException.class, () -> orderDetails.addProduct(product, -1));
        assertEquals(0, orderDetails.getProductsWithQuantity().size());
    }

    @Test
    public void testContainsProductByName_whenProductExists() {
        Product product = new Product("test", BigDecimal.ONE);

        orderDetails.addProduct(product, 1);

        assertTrue(orderDetails.containsProductByName("test"));
    }

    @Test
    public void testContainsProductByName_whenProductDoesNotExist() {
        assertFalse(orderDetails.containsProductByName("test"));
    }

    @Test
    public void testGetPrice_delegatesToPriceCalculatorAndReturnsCorrectValue() {
        PriceCalculator priceCalculator = mock(PriceCalculator.class);
        BigDecimal price = BigDecimal.valueOf(100);
        when(priceCalculator.getPrice()).thenReturn(price);
        orderDetails.setPriceCalculator(priceCalculator);

        assertEquals(price, orderDetails.getPrice());
        verify(priceCalculator).getPrice();
    }

    @Test
    public void testGetPriceWithTaxes_delegatesToPriceCalculatorAndReturnsCorrectValue() {
        PriceCalculator priceCalculator = mock(PriceCalculator.class);
        BigDecimal price = BigDecimal.valueOf(100);
        when(priceCalculator.getPriceWithTaxes()).thenReturn(price);
        orderDetails.setPriceCalculator(priceCalculator);

        assertEquals(price, orderDetails.getPriceWithTaxes());
        verify(priceCalculator).getPriceWithTaxes();
    }
}
