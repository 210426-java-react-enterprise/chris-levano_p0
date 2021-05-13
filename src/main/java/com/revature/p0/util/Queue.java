package com.revature.p0.util;

/**
 * A queue interface extending collections to be implemented by LinkedList
 * @param <T>
 */
public interface Queue<T> extends Collection<T> {
    T poll();
    T peek();
}
