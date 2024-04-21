package pl.edu.agh.to.lab4.data.iterator;

import pl.edu.agh.to.lab4.model.Suspect;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CompositeIterator implements Iterator<Suspect> {
    private final List<Iterator<? extends Suspect>> iterators;
    private int current = 0;

    public CompositeIterator(List<Iterator<? extends Suspect>> iterators) {
        this.iterators = iterators;
    }

    @Override
    public boolean hasNext() {
        while (current < iterators.size() && !iterators.get(current).hasNext()) {
            current++;
        }
        return current < iterators.size();
    }

    @Override
    public Suspect next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return iterators.get(current).next();
    }
}
