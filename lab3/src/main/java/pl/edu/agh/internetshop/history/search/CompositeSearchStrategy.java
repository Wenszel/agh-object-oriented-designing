package pl.edu.agh.internetshop.history.search;

import pl.edu.agh.internetshop.Order;

import java.util.Collection;

public class CompositeSearchStrategy implements SearchStrategy{
    private final Collection<SearchStrategy> searchStrategies;

    public CompositeSearchStrategy(Collection<SearchStrategy> searchStrategies) {
        this.searchStrategies = searchStrategies;
    }

    @Override
    public boolean filter(Order order) {
        return searchStrategies.stream().allMatch(strategy -> strategy.filter(order));
    }
}
