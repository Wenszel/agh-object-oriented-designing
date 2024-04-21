package pl.edu.agh.to.lab4.strategy;

import pl.edu.agh.to.lab4.model.Suspect;

public class NameSearchStrategy<T extends Suspect> implements SearchStrategy<T>{
    private final String name;
    public NameSearchStrategy(String name) {
        this.name = name;
    }
    public boolean filter(T t) {
        return t.getName().equals(name);
    }
}
