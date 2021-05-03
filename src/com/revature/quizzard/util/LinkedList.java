package com.revature.quizzard.util;

/**
 * A simple implementation of a doubly linked-list structure that
 * does not accept null data.
 *
 * @param <T>
 */
public class LinkedList<T> implements List<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    /**
     * Adds a generic element into linked list.  Element cannot be null.
     *
     *
     */
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
     * @return null
     */
    @Override
    public T pop() {

        if (head == null) {
            return null;
        }

        T soughtData = head.data;
        head = head.nextNode;

        if (head != null) {
            head.prevNode = null;
        } else {
            tail = null;
        }

        size--;

        return soughtData;

    }

    /**
     * Returns generic at the index position within the list
     *
     * @return T
     */
    @Override
    public T get(int index) {

        if(size <= index){
            throw new IllegalArgumentException("Index is out of bounds of linked list size!");
        }

        Node<T> soughtData = this.head;
        //Node<T> soughtData = new Node<T>(this.head.data);
        //T soughtData = head.data;

        //just in case index == 0
        if(index == 0){
            return soughtData.data;
        }

        //go through loop until i==index, and the final assigned value/type will be the one to return
        for (int i = 0; i < index; i++){//will want to stop prior to index value due to "nextNode"
            soughtData = soughtData.nextNode;
        }

        return soughtData.data;
    }


    /**
     * Returns generic at the index position within the list
     *
     * @return boolean
     */
    @Override
    public boolean contains(T data) {

        return false;
    }

    @Override
    public int size() {
        return size;
    }

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

    /**
     * Prints to console all data contained in the linked list.
     *
     *
     */
    public void printLinkedList(){
        if (size == 0) {
            throw new IllegalArgumentException("This linked list is empty!");
        }

        Node<T> temp = this.head;

        for (int i = 0; i < size; i++){//will want to stop prior to index value due to "nextNode"
            System.out.println(temp.data);
            if(i == size-1) {
                break;
            }else{
                temp = temp.nextNode;
            }
        }
    }

}