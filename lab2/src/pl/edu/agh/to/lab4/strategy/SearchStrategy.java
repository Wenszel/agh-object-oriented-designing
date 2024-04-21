package pl.edu.agh.to.lab4.strategy;

import pl.edu.agh.to.lab4.model.Suspect;

public interface SearchStrategy<T extends Suspect> {
    boolean filter(T t);
}
