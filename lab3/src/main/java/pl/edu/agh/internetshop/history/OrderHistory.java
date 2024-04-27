package pl.edu.agh.internetshop.history;

import pl.edu.agh.internetshop.history.search.SearchStrategy;
import pl.edu.agh.internetshop.Order;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderHistory {
    private final List<Order> orders = new LinkedList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Order> getOrders(SearchStrategy searchStrategy) {
        return orders.stream()
                .filter(searchStrategy::filter)
                .collect(Collectors.toList());
    }
}
