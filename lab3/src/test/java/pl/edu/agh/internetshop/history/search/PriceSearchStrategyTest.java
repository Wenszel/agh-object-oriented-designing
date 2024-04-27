package pl.edu.agh.internetshop.history.search;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.Order;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PriceSearchStrategyTest {
    @Test
    public void testFilter_whenOrderPriceIsEqualToGivenPrice() {
        BigDecimal price = new BigDecimal("100");
        PriceSearchStrategy priceSearchStrategy = new PriceSearchStrategy(price);
        Order order = mock(Order.class);
        when(order.getPrice()).thenReturn(price);

        boolean result = priceSearchStrategy.filter(order);

        assertTrue(result);
    }

    @Test
    public void testFilter_whenOrderPriceIsNotEqualToGivenPrice() {
        PriceSearchStrategy priceSearchStrategy = new PriceSearchStrategy(new BigDecimal("100"));
        Order order = mock(Order.class);
        when(order.getPrice()).thenReturn(new BigDecimal("200"));

        boolean result = priceSearchStrategy.filter(order);

        assertFalse(result);
    }
}
