package pl.edu.agh.internetshop.history.search;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.Order;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NameSearchStrategyTest {
    @Test
    public void testFilter_whenContainsProduct() {
        NameSearchStrategy nameSearchStrategy = new NameSearchStrategy("product");
        Order order = mock(Order.class);
        when(order.containsProductByName("product")).thenReturn(true);
        assertTrue(nameSearchStrategy.filter(order));
    }

    @Test
    public void testFilter_whenDoesNotContainProduct() {
        NameSearchStrategy nameSearchStrategy = new NameSearchStrategy("product");
        Order order = mock(Order.class);
        when(order.containsProductByName("product")).thenReturn(false);
        assertFalse(nameSearchStrategy.filter(order));
    }
}
