package pl.edu.agh.internetshop.history.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CompositeSearchStrategyTest {
    SearchStrategy strategy1 = mock(SearchStrategy.class);
    SearchStrategy strategy2 = mock(SearchStrategy.class);
    Collection<SearchStrategy> strategies = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        strategies.add(strategy1);
        strategies.add(strategy2);
    }

    @Test
    public void testFilter_whenBothStrategiesReturnTrue() {
        CompositeSearchStrategy compositeSearchStrategy = new CompositeSearchStrategy(strategies);
        when(strategy1.filter(any())).thenReturn(true);
        when(strategy2.filter(any())).thenReturn(true);

        boolean result = compositeSearchStrategy.filter(any());

        assertTrue(result);
    }

    @Test
    public void testFilter_whenFirstStrategyReturnsFalse() {
        CompositeSearchStrategy compositeSearchStrategy = new CompositeSearchStrategy(strategies);
        when(strategy1.filter(any())).thenReturn(false);
        when(strategy2.filter(any())).thenReturn(true);

        boolean result = compositeSearchStrategy.filter(any());

        assertFalse(result);
    }

    @Test
    public void testFilter_whenSecondStrategyReturnsFalse() {
        CompositeSearchStrategy compositeSearchStrategy = new CompositeSearchStrategy(strategies);
        when(strategy1.filter(any())).thenReturn(true);
        when(strategy2.filter(any())).thenReturn(false);

        boolean result = compositeSearchStrategy.filter(any());

        assertFalse(result);
    }
}
