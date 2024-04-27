package pl.edu.agh.internetshop.history.search;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.Order;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserSearchStrategyTest {
    @Test
    public void testFilter_whenTheSameName() {
        String name = "Kowalski";
        UserSearchStrategy userSearchStrategy = new UserSearchStrategy(name);
        Order order = mock(Order.class);
        when(order.getUserLastname()).thenReturn(name);
        assertTrue(userSearchStrategy.filter(order));
    }

    @Test
    public void testFilter_whenDifferentName() {
        String name = "Kowalski";
        UserSearchStrategy userSearchStrategy = new UserSearchStrategy(name);
        Order order = mock(Order.class);
        when(order.getUserLastname()).thenReturn("Nowak");
        assertFalse(userSearchStrategy.filter(order));
    }
}
