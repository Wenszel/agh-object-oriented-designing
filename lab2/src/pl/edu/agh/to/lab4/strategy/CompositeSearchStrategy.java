package pl.edu.agh.to.lab4.strategy;

import pl.edu.agh.to.lab4.model.Suspect;

import java.util.ArrayList;
import java.util.List;

public class CompositeSearchStrategy<T extends Suspect> implements SearchStrategy<T> {
    private final List<SearchStrategy<T>> searchStrategies = new ArrayList<>();
    public void addStrategy(SearchStrategy<T> strategy) {
        searchStrategies.add(strategy);
    }
    @Override
    public boolean filter(T t) {
        return searchStrategies.stream().allMatch(strategy -> strategy.filter(t)) ;
    }

}