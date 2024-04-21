package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.data.aggregate.CompositeAggregate;
import pl.edu.agh.to.lab4.model.Suspect;
import pl.edu.agh.to.lab4.strategy.SearchStrategy;

public class Finder {
    private final CompositeAggregate compositeAggregate;

    public Finder(CompositeAggregate compositeAggregate) {
        this.compositeAggregate = compositeAggregate;
    }

    public void displayAllSuspectsWithName(SearchStrategy<Suspect> searchStrategy) {
        this.compositeAggregate.iterator().forEachRemaining((s) -> {
            if (searchStrategy.filter(s)) {
                System.out.println(s.display());
            }
        });
    }
}