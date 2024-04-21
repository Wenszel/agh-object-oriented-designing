package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.data.PersonDataProvider;
import pl.edu.agh.to.lab4.data.PrisonersDatabase;
import pl.edu.agh.to.lab4.data.aggregate.CompositeAggregate;
import pl.edu.agh.to.lab4.model.Suspect;
import pl.edu.agh.to.lab4.strategy.AgeSearchStrategy;
import pl.edu.agh.to.lab4.strategy.CompositeSearchStrategy;
import pl.edu.agh.to.lab4.strategy.NameSearchStrategy;

public class Application {

    public static void main(String[] args) {
        CompositeAggregate compositeAggregate = new CompositeAggregate();
        compositeAggregate.addIterator(new PersonDataProvider().iterator());
        compositeAggregate.addIterator(new PrisonersDatabase().iterator());
        Finder suspects = new Finder(compositeAggregate);
        AgeSearchStrategy<Suspect> ageSearchStrategy = new AgeSearchStrategy<>(18);
        NameSearchStrategy<Suspect> nameSearchStrategy = new NameSearchStrategy<>("Janusz");
        CompositeSearchStrategy<Suspect> compositeSearchStrategy = new CompositeSearchStrategy<>();
        compositeSearchStrategy.addStrategy(ageSearchStrategy);
        compositeSearchStrategy.addStrategy(nameSearchStrategy);
        suspects.displayAllSuspectsWithName(compositeSearchStrategy);
    }
}
