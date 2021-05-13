package com.revature.p0.util;

/**
 * Collection class for extension by List and queue
 * @param <T>
 */
public interface Collection<T> {

    int size();
    boolean contains(T data);
    void add(T data);
    boolean remove(T data);

}
