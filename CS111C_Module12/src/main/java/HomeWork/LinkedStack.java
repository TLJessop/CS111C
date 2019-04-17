package HomeWork;

import java.util.EmptyStackException;
import java.util.Objects;

public class LinkedStack<T extends Comparable<? super T>> implements StackInterface<T>, Comparable<LinkedStack<T>>{

    //Instance data
    private Node topNode;
    private int numberOfEntries =0;

    //Constructors
    public LinkedStack( T firstThing){
        topNode = new Node(firstThing, null);
        numberOfEntries ++;
    }

    public LinkedStack(){
        topNode = null;
    }

    //Core methods
    public void push(T newEntry) {
        if (topNode == null){
            topNode = new Node(newEntry, null);
        } else {
            Node tempNode = topNode;
            topNode = new Node(newEntry, tempNode);
        }
        numberOfEntries++;
    }

    public T pop() {
        if (topNode != null){
            T returnValue = topNode.data;
            topNode = topNode.next;
            numberOfEntries--;
            return returnValue;
        } else {
            throw new EmptyStackException();
        }
    }

    public T peek() {
        if (topNode != null){
            return topNode.data;
        } else {
            throw new EmptyStackException();
        }
    }


    public boolean isEmpty() {
        return topNode == null;
    }

     public void clear() {
        topNode = null;
        numberOfEntries = 0;
    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    //Overridden methods
    @Override
    public String toString(){
        StringBuilder outString = new StringBuilder("LinkedStack [ ");
        Node currentNode = topNode;
        while (currentNode != null){
            outString.append(currentNode.data);
            if (currentNode.next != null){
                outString.append(", ");
            }
            currentNode = currentNode.next;
        }
        outString.append(" ]");

        return outString.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null ) return false;
        if (obj == this ) return true;

        if (obj.getClass() == LinkedStack.class){
            LinkedStack<?> other = (LinkedStack<?>) obj;

            if(numberOfEntries != other.numberOfEntries) return false;

            Node currentNode = topNode;
            Node otherNode = (Node) other.topNode;

            while (currentNode != null && otherNode != null){

                if(!currentNode.data.equals(otherNode.data)){
                    return false;
                }
                currentNode = currentNode.next;
                otherNode = otherNode.next;
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        int hash = Objects.hash(numberOfEntries);

        Node currentNode = topNode;

        while (currentNode != null){
            hash += Objects.hash(currentNode.data);
            currentNode = currentNode.next;
        }
        return hash;
    }

    @Override
    public int compareTo(LinkedStack<T> other) {
        Node currentNode = topNode;
        Node otherNode = other.topNode;

        while (currentNode != null && otherNode != null){
            if (!currentNode.data.equals(otherNode.data)){
                return currentNode.data.compareTo(otherNode.data);
            }
            currentNode = currentNode.next;
            otherNode = otherNode.next;
        }
        return Integer.compare(numberOfEntries, other.numberOfEntries);
    }

    //Private inner node class
    private class Node{

        //Instance data
        private T data;
        private Node next;

        //Constructor
        private Node( T data, Node next){
            this.data = data;
            this.next = next;
        }

        //Getters and setters
        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
        //End of getters and setters
    }//Node
}//LinkedStack