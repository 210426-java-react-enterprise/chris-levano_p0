package com.revature.p0.util;

/**
 * A list interface extending collections to be implemented by LinkedList
 * @param <T>
 */
public interface List<T> extends Collection<T> {

    T get(int index);

}
