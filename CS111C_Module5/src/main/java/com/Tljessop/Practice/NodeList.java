package com.Tljessop.Practice;

import java.util.Arrays;

public class NodeList<T> implements ListInterface<T> {

    private int numOfNodes;
    private Node<T> headNode;

    private class Node<T>{

        private T data;
        private Node<T> next;

        public Node(T data, Node next){
            this.data = data;
            this.next = next;
        }

        public Node(T data){
            this(data, null);
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public String toString(){
            return this.data.toString();
        }
    }

    public NodeList(){

        headNode = null;
        numOfNodes = 0;

    }



    @Override
    public void add(T newEntry) {
        Node<T> tempNode = headNode;
        Node<T> newHead = new Node<T>(newEntry, tempNode);
        headNode = newHead;
        numOfNodes++;
        System.out.println(headNode.next);

    }


    @Override
    public void add(int newPosition, T newEntry) {
         validIndex(newPosition);
        Node<T> nodeBefore;
        Node<T> newNode = new Node<T>(newEntry);

        if (newPosition != 1) {
            nodeBefore = iterateNode(newPosition - 1);
        }else {
            this.add(newEntry);
            return;
        }

        if(nodeBefore.getNext().getNext() != null){
            newNode.setNext(nodeBefore.getNext().getNext());
        }

        nodeBefore.setNext(newNode);
        numOfNodes++;

    }


    @Override
    public T remove(int givenPosition) {
        validIndex(givenPosition);

        T thing = iterateNode(givenPosition).getData();
        Node<T> nodeBefore;

        if(givenPosition == 1){
            headNode = headNode.getNext();
        } else {
            nodeBefore = iterateNode(givenPosition - 1);
            if (nodeBefore.getNext().getNext() != null){
                nodeBefore.setNext(nodeBefore.getNext().getNext());
            }
        }

        numOfNodes--;
        return thing;
    }

    /**
     * Removes all entries from this list.
     */
    @Override
    public void clear() {
        headNode = null;
        numOfNodes = 0;
    }

    /**
     * Replaces the entry at a given position in this list.
     *
     * @param givenPosition An integer that indicates the position of
     *                      the entry to be replaced.
     * @param newEntry      The object that will replace the entry at the
     *                      position givenPosition.
     * @return The original entry that was replaced.
     * @throws IndexOutOfBoundsException if either
     *                                   givenPosition < 1 or givenPosition > getLength().
     */
    @Override
    public T replace(int givenPosition, T newEntry) throws IndexOutOfBoundsException{
        validIndex(givenPosition);

        Node<T> newNode = new Node<T>(newEntry);
        Node<T> beforeNode = iterateNode(givenPosition - 1);
        T thing = null;

        if(beforeNode.getNext() != null){
            newNode.setNext(beforeNode.getNext().getNext());
            thing = beforeNode.getNext().getData();
        }

        beforeNode.setNext(newNode);

        return thing;

    }

    /**
     * Retrieves the entry at a given position in this list.
     *
     * @param givenPosition An integer that indicates the position of
     *                      the desired entry.
     * @return A reference to the indicated entry.
     * @throws IndexOutOfBoundsException if either
     *                                   givenPosition < 1 or givenPosition > getLength().
     */
    @Override
    public T getEntry(int givenPosition) {
        return iterateNode(givenPosition).getData();
    }

    /**
     * Retrieves all entries that are in this list in the order in which
     * they occur in the list.
     *
     * @return A newly allocated array of all the entries in the list.
     * If the list is empty, the returned array is empty.
     */
    @Override
    public T[] toArray() {
        T[] things = (T[]) new Object[numOfNodes ];


        for (int i = 1; i <= numOfNodes ; i++) {
            things[i -1] = iterateNode(i).data;
        }
        return things;

    }

    /**
     * Sees whether this list contains a given entry.
     *
     * @param anEntry The object that is the desired entry.
     * @return True if the list contains anEntry, or false if not.
     */
    @Override
    public boolean contains(T anEntry) {
        for (int i =1; i <= numOfNodes; i ++){
            if (anEntry == iterateNode(i).getData()){
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the length of this list.
     *
     * @return The integer number of entries currently in the list.
     */
    @Override
    public int getLength() {
        return numOfNodes;
    }

    /**
     * Sees whether this list is empty.
     *
     * @return True if the list is empty, or false if not.
     */
    @Override
    public boolean isEmpty() {
        if (this.headNode == null){
            return true;
        } else {
            return false;
        }
    }

    public void backToFront(){

        Node currentNode = headNode;
        while (currentNode.next != null){
            currentNode = currentNode.next;

        }

        currentNode.next =headNode;
        headNode = currentNode;
    }

    private Node<T> iterateNode(int index){
        validIndex(index);
            Node<T> currentNode = headNode;
            for (int i = 1; i < index; i++){
                currentNode = currentNode.next;
            }
            return currentNode;


    }

    private IndexOutOfBoundsException validIndex(int index){
        if (index < 1 || index > numOfNodes){
            return new IndexOutOfBoundsException("Not a valid index");
        } else {
            return null;
        }
    }


    public static void main(String[] args) {

        NodeList<Integer> nums = new NodeList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        System.out.println();

        System.out.println(Arrays.toString(nums.toArray()));
        nums.backToFront();
        System.out.println(Arrays.toString(nums.toArray()));

    }//main



}//Class NodeList
