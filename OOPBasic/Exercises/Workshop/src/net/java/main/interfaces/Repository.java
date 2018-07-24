package net.java.main.interfaces;

import java.util.Collection;

public interface Repository<T> {

    void save(T element);

    Collection<T> findAll();

    T findByName(String name);
}
