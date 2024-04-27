package pl.edu.agh.to.lab4.data.aggregate;

import pl.edu.agh.to.lab4.data.iterator.CompositeIterator;
import pl.edu.agh.to.lab4.model.Suspect;

import java.util.*;

public class CompositeAggregate implements SuspectAggregate, Iterable<Suspect>, Collection<Suspect> {
  private final List<Iterator<? extends Suspect>> iterators = new ArrayList<>();

  public void addIterator(Iterator<? extends Suspect> iterator) {
    iterators.add(iterator);
  }

  @Override
  public int size() {
    return iterators.size();
  }

  @Override
  public boolean isEmpty() {
    return iterators.isEmpty();
  }

  @Override
  public boolean contains(Object o) {
    return iterators.contains(o);
  }

  @Override
  public Iterator<Suspect> iterator() {
    return new CompositeIterator(iterators);
  }

  @Override
  public Object[] toArray() {
    return new Object[0];
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return null;
  }

  @Override
  public boolean add(Suspect suspect) {
    return false;
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends Suspect> c) {
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return false;
  }

  @Override
  public void clear() {

  }
}
