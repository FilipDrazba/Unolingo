package pl.edu.pb.wi.model;

import java.util.Iterator;

public interface IterableCollection<E> {
    Iterator<E> createIterator(String key);
}
