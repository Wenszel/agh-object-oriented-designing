package pl.edu.agh.to.lab4.data.aggregate;

import pl.edu.agh.to.lab4.data.iterator.CompositeIterator;
import pl.edu.agh.to.lab4.model.Suspect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeAggregate implements SuspectAggregate {
    private final List<Iterator<? extends Suspect>> iterators = new ArrayList<>();

    public void addIterator(Iterator<? extends Suspect> iterator) {
        iterators.add(iterator);
    }

    @Override
    public Iterator<Suspect> iterator() {
        return new CompositeIterator(iterators);
    }
}
