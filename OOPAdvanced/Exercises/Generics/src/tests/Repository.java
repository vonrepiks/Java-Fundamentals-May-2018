package tests;

import java.util.List;

public interface Repository<T extends Comparable<T>> {

    void save(T item);

    List<T> findAll();
}
