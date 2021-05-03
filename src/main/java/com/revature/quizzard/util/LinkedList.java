package com.revature.quizzard.util;

/**
 * A simple implementation of a doubly linked-list structure
 * that does not except null data.
 *
 * @param <T>
 */
public class LinkedList<T> implements List<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;
    private Node<T> currentNode;


    @Override
    public void add(T data) throws IllegalArgumentException {
        if (data == null) {
            // to throw your own exception on purpose, do below
            throw new IllegalArgumentException("This linked list does not except null values.");
        }

        Node<T> newNode = new Node<T>(data);
        // in java the reference is a pointer
        if (head == null) {
            // sets both head and tail to the newNode
            head = tail = newNode;
        } else {
            tail.nextNode = newNode;
            newNode.prevNode = tail;
            tail = newNode;
            newNode = null;
        }
        size++;
    }

    /**
     * Returns the Head nodes data or else returns null.
     *
     * @return
     */

    @Override
    public T pop() {
        if (head == null) {
            return null;
        }

        T soughtData = head.data;

        head = head.nextNode;
        if (head.nextNode != null) {
            head.prevNode = null;
        } else {
            tail = null;
        }

        size--;

        return soughtData;
    }

//    @Override
//    public T get(int index){
////        return index;
//    }

    @Override
    public boolean contains(T data) {

        if(head == null){
            return false;
        }

        currentNode = head;

        while (currentNode.nextNode != null){
            if(currentNode.data == data){
                return true;
            }
            currentNode = currentNode.nextNode;
        }


        return false;
    }

    @Override
    public int size() {

        if(head == null){
            return 0;
        }

        size = 1;
        currentNode = head;

        while (currentNode.nextNode != null){

            currentNode = currentNode.nextNode;
            size++;
        }

        return size;
    }

    //no need for getters and setters bc linkedlist can see in side this
    // since below class is private it will only be visible to class its declared in

    private static class Node<T> {
        //variables in a class scope default to null
        T data;
        Node<T> nextNode;
        Node<T> prevNode;

        Node(T data) {
            //use for
            this.data = data;
        }

        Node(T data, Node<T> prevNode, Node<T> nextNode) {
            this.data = data;
            this.prevNode = prevNode;
            this.nextNode = nextNode;
        }
    }
}
