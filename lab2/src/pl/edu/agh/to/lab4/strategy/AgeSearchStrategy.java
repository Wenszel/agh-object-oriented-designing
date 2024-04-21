package pl.edu.agh.to.lab4.strategy;

import pl.edu.agh.to.lab4.model.Suspect;

public class AgeSearchStrategy<T extends Suspect> implements SearchStrategy<T> {
    private final int age;

    public AgeSearchStrategy(int age) {
        this.age = age;
    }

    @Override
    public boolean filter(T t) {
        return t.getAge() >= age;
    }
}
