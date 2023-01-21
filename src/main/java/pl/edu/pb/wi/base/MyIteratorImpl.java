package pl.edu.pb.wi.base;

import pl.edu.pb.wi.model.MyIterator;

import java.util.Collection;

public class MyIteratorImpl implements MyIterator {
    private java.util.Iterator<String> iterator;

    public MyIteratorImpl(String key) {
        this.iterator = Base.getInstance().createIterator(key);
    }

    @Override
    public String getNext() {
        return iterator.next();
    }

    @Override
    public Boolean hasMore() {
        return iterator.hasNext();
    }
}
