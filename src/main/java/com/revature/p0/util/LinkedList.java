package com.revature.p0.util;
/**
 * A simple implementation of a doubly linked-list structure that
 * does not accept null data.
 *
 * @param <T>
 */
public class LinkedList<T> implements List<T>, Queue<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    @Override
    public void add(T data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("This linked list does not accept null values");
        }
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            tail = head = newNode; // sets both the head and tail equal to the new node
        } else {
            tail.nextNode = newNode;
            newNode.prevNode = tail;
            tail = newNode;
        }
        size++;
    }
    /**
     * Returns and removes the head node's data or else returns null.
     *
     * @return
     */
    @Override
    public T poll() {

        if (head == null) {
            return null;
        }
        T soughtData = head.data;
        head = head.nextNode;
        if (head != null) {
            head.prevNode = null;
        }
        size--;
        return soughtData;
    }

    /**
     * returns the data at the head node
     * @return
     */
    @Override
    public T peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    /**
     * removes nodes containing specified data and returns it
     * @param data
     * @return
     */
    @Override
    public boolean remove(T data) {
        Node<T> runner = head;
        for (int i = 0; i < size; i++) {
            if (runner.data == data) {
                runner.prevNode = runner.nextNode;
                size--;
                return true;
            }
            runner = runner.nextNode;
        }

        return false;
    }

    /**
     * returns the data at the given node
     * @param index
     * @return
     */
    @Override
    public T get(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("The provided index would be out of bounds.");
        }
        if (head == null){
            return null;
        }
        Node<T> runner = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return runner.data;
            }
            runner = runner.nextNode;
        }
        return null;
    }

    /**
     * returns a boolean for if the specified data is a member of the list
     * @param data
     * @return
     */
    @Override
    public boolean contains(T data) {
        if (head == null){
            return false;
        }
        Node<T> runner = head;
        for (int i = 0; i < size; i++) {
            if (runner.data == data) {
                return true;
            }
            runner = runner.nextNode;
        }
       return false;
    }

    /**
     * gives the size of the list
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *
     * @param <T>
     */
    private static class Node<T> {
        T data;
        Node<T> nextNode; // defaults to null
        Node<T> prevNode; // defaults to null

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node<T> nextNode, Node<T> prevNode) {
            this.data = data;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }

    }

}
