package pl.edu.agh.to.lab4.data.iterator;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class FlatIterator<K, T> implements Iterator<T> {
    private final Iterator<Map.Entry<K, Collection<T>>> mapIterator;
    private Iterator<T> collectionIterator;

    public FlatIterator(Map<K, Collection<T>> map) {
        this.mapIterator = map.entrySet().iterator();
        this.collectionIterator = null;
    }

    @Override
    public boolean hasNext() {
        if (collectionIterator != null && collectionIterator.hasNext()) {
            return true;
        }
        while (mapIterator.hasNext()) {
            Map.Entry<K, Collection<T>> entry = mapIterator.next();
            collectionIterator = entry.getValue().iterator();
            if (collectionIterator.hasNext()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the collection");
        }
        return collectionIterator.next();
    }
}
