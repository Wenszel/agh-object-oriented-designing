package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.data.aggregate.CompositeAggregate;
import pl.edu.agh.to.lab4.model.Suspect;
import pl.edu.agh.to.lab4.strategy.SearchStrategy;

import java.util.stream.StreamSupport;

public class Finder {
    private final CompositeAggregate compositeAggregate;

    public Finder(CompositeAggregate compositeAggregate) {
        this.compositeAggregate = compositeAggregate;
    }

    public void displayAllSuspectsWithName(SearchStrategy<Suspect> searchStrategy) {
        this.compositeAggregate.stream()
                .filter(searchStrategy::filter)
                .map(Suspect::display)
                .forEach(System.out::println);
    }
}