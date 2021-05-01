package com.revature.quizzard.util;

/**
 * A simple implementation of a doubly linked-list structure that
 * does not accept null data.
 * @param <T>
 */

public class LinkedList<T> implements List<T> {
    private int size = 0;

    @Override
    public void add(T data) throws IllegalArgumentException {
        if (data == null){
            throw new IllegalArgumentException("This linked list does not accept null values!");
        }
    }

    @Override
    public T get() {
        return null;
    }

    @Override
    public boolean contains(T data) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<T>{
        T data;
        Node<T> nextNode;//defaults to null
        Node<T> prevNode;//defaults to null

        Node(T data){
            this.data = data;
        }

        Node(T data, Node<T> nextNode, Node<T> prevNode){
            this.data = data;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }
    }
}
