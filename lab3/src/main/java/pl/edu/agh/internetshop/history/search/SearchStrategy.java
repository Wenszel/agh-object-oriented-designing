package pl.edu.agh.internetshop.history.search;

import pl.edu.agh.internetshop.Order;

@FunctionalInterface
public interface SearchStrategy {
    boolean filter(Order order);
}
