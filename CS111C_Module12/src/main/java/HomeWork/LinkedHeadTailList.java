package HomeWork;

import java.util.Objects;

public class LinkedHeadTailList<T extends Comparable<? super T>> implements HeadTailListInterface<T>, Comparable<LinkedHeadTailList<T>>{

    //Instance data
    private int numberOfEntries;
    private Node headNode, tailNode;

    //Constructors
    public LinkedHeadTailList( T firstEntry){
        headNode = new Node(firstEntry, null, null);
        tailNode = headNode;
        numberOfEntries = 1;
    }

    public LinkedHeadTailList(){
        headNode = null;
        numberOfEntries = 0;
    }

    public void addFront(T newEntry) {
        if (headNode == null){
            headNode = new Node(newEntry,null,null);
            tailNode = headNode;
        } else {
            Node tempNode = headNode;
            headNode =  new Node(newEntry,null,null);
            tempNode.before = headNode;
            headNode.next = tempNode;
        }
        numberOfEntries++;
    }

    public void addBack(T newEntry) {

        if (tailNode == null){
            tailNode = new Node(newEntry,null,null);
            headNode = tailNode;
        } else {
            Node tempNode = tailNode;
            tailNode = new Node(newEntry,null, null);
            tempNode.next = tailNode;
            tailNode.before = tempNode;
        }
        numberOfEntries++;
    }


    public T removeFront() {
        if (headNode != null){
            Node tempNode = headNode;

            headNode = headNode.next;
            if (headNode != null) {
                headNode.before = null;
            }
            numberOfEntries--;
            return tempNode.data;
        } else {
            return null;
        }
    }

    public T removeBack() {

        if (tailNode != null) {
         Node tempNode = tailNode;
         tailNode = tailNode.before;

         if (tailNode != null ){
             tailNode.next = null;

         }
         numberOfEntries--;
         if (numberOfEntries == 0) this.clear();
         return tempNode.data;
        } else {
            return null;
        }

    }

     public void clear() {
        headNode = null;
        tailNode = null;
        numberOfEntries =0;
    }

    public T getEntry(int givenPosition) {
        if (givenPosition < 0  || givenPosition > numberOfEntries -1 ){
            return null;
        } else {
            Node currentNode = headNode;
            for (int i = 0; i < givenPosition; i++) {

                currentNode = currentNode.next;
            }
            return currentNode.data;
        }
    }

    public void display() {
        System.out.println(this);
    }

    public int contains(T anEntry) {
        int count = 0;
        Node currenNode = headNode;
        while (currenNode != null){
            if (currenNode.data.equals(anEntry)){
                return count;
            }
            currenNode = currenNode.next;
            count++;
        }
        return -1;
    }


    public int size() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


// Node class copied over from LList and added a leading reference
    private class Node {
        private T data; // Entry in list
        private Node next; // Link to next node

        //Added leading reference
        private Node before;

        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
            before = null;
        } // end constructor

        private Node(T dataPortion, Node nextNode, Node beforeNode) {
            data = dataPortion;
            next = nextNode;
            before = beforeNode;
        } // end constructor

        private T getData() {
            return data;
        } // end getData

        private void setData(T newData) {
            data = newData;
        } // end setData

        private Node getNextNode() {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode) {
            next = nextNode;
        } // end setNextNode

        private Node getBeforeNode(){
            return before;
        }

        private void setBeforeNode(Node beforeNode){
            before = beforeNode;
        }

    } // end Node





    //This will run O(n), but it makes sure to keep the hashCode / equals contract
    @Override
    public int hashCode() {
        int hash = Objects.hash(headNode);
        Node current = headNode;
        while (current != null){
            hash += Objects.hash(current.data);
        }
        return hash;
    }

    //This runs O(n), but it makes sure to check all items
    @Override
    public boolean equals(Object obj) {
        if (obj == null ) return false;
        if (obj == this ) return true;
        if (obj instanceof  LinkedHeadTailList<?>){

            LinkedHeadTailList<?> other = (LinkedHeadTailList<?>) obj;

            if (other.numberOfEntries != this.numberOfEntries) return false;

            Node currentNode =  headNode;
            //I know this looks weird, but it makes typeeraser happy
            Node otherNode = (Node) other.headNode;

            while (currentNode != null){
                if (!currentNode.data.equals(otherNode.data)){
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
    public String toString() {
        StringBuilder outString = new StringBuilder("[");
        Node currentNode = headNode;
        while (currentNode != null){
            outString.append(currentNode.data);
            if (currentNode != tailNode) outString.append(" ,");
            currentNode = currentNode.next;
        }
        outString.append("]");
        if (headNode != null && tailNode != null){
            outString.append(" head =" + (headNode.data) + " tail=" + tailNode.data);
        }
        return outString.toString();
    }

    @Override
    public int compareTo(LinkedHeadTailList<T> other) {

        Node currentNode = headNode;
        Node otherNode = other.headNode;
        while (currentNode != null && otherNode != null){
            if (!currentNode.data.equals(otherNode.data)){
                return currentNode.data.compareTo(otherNode.data);
            }
            currentNode = currentNode.next;
            otherNode = otherNode.next;
        }

        return Integer.compare(this.numberOfEntries, other.numberOfEntries);
    }

}//LinkedHeadTailList
