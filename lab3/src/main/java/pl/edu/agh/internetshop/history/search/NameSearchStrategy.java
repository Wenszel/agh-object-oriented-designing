package pl.edu.agh.internetshop.history.search;

import pl.edu.agh.internetshop.Order;

public class NameSearchStrategy implements SearchStrategy{
    private final String name;
    public NameSearchStrategy(String name) {
        this.name = name;
    }
    @Override
    public boolean filter(Order order) {
        return order.containsProductByName(name);
    }
}
