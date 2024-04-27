package pl.edu.agh.internetshop.history;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.Order;
import pl.edu.agh.internetshop.history.search.SearchStrategy;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class OrderHistoryTest {
    @Test
    public void testGetOrderWithSearchStrategy() {
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.addOrder(new Order());
        orderHistory.addOrder(new Order());
        SearchStrategy searchStrategy = mock(SearchStrategy.class);
        when(searchStrategy.filter(any())).thenReturn(true);
        orderHistory.getOrders(searchStrategy);
        verify(searchStrategy, times(2)).filter(any());
    }
}
