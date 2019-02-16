package com.Tljessop.Practice;

public class DoubleNode<T> {

    //Instance variables
    private T data;
    private DoubleNode next;
    private DoubleNode previous;

    //Constructor
    public DoubleNode(T data, DoubleNode next, DoubleNode previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    //Getters and Setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public DoubleNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode previous) {
        this.previous = previous;
    }

}//Class DoubleNode
