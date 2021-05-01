package com.revature.quizzard.util;

public interface List<T> {

    void add(T data);
    T get();
    boolean contains(T data);
    int size();
}
