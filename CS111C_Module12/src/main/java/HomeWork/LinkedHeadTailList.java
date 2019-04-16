package HomeWork;

public class LinkedHeadTailList<T extends Comparable<? super T>> implements HeadTailListInterface<T>, Comparable<LinkedHeadTailList<T>>{

    //Instance data
    private int numberOfEntries;
    private Node headNode;

    //Constructors
    public LinkedHeadTailList( T firstEntry){
        headNode = new Node(firstEntry, null, null);
        numberOfEntries = 1;
    }

    public LinkedHeadTailList(){
        headNode = null;
        numberOfEntries = 0;
    }



    public void addFront(T newEntry) {
        if (headNode == null){
            headNode = new Node(newEntry,null,null);
        } else {
            Node tempNode = headNode;
            headNode =  new Node(newEntry,null,null);
            tempNode.before = headNode;
            headNode.next = tempNode;
        }
        numberOfEntries++;
    }

    /**
     * Adds a new entry to the end of the list.
     * Entries currently in the list are unaffected.
     * The list's size is increased by 1.
     *
     * @param newEntry The object to be added as a new entry.
     */
    @Override
    public void addBack(T newEntry) {

        if (headNode == null){
            headNode = new Node(newEntry,null,null);
        } else {
            Node curentNode = headNode;
            while (curentNode.next != null){
                curentNode = curentNode.next;
            }
            System.out.println(curentNode.data);
            curentNode.next = new Node(newEntry,null,curentNode);
        }
        numberOfEntries++;
    }

    /**
     * Removes an entry from the beginning of the list.
     * Entries currently in the list are shifted up.
     * The list's size is decreased by 1.
     *
     * @return A reference to the removed entry or null if the list is empty.
     */
    @Override
    public T removeFront() {
        return null;
    }

    /**
     * Removes an entry from the end of the list.
     * Entries currently in the list are unaffected.
     * The list's size is decreased by 1.
     *
     * @return A reference to the removed entry or null if the list is empty.
     */
    @Override
    public T removeBack() {
        return null;
    }

    /**
     * Removes all entries from this list.
     */
    @Override
    public void clear() {

    }

    /**
     * Retrieves the entry at a given position in this list.
     *
     * @param givenPosition An integer that indicates the position of the desired entry.
     * @return A reference to the indicated entry or null if the index is out of bounds (less than zero greater than or equal to the size).
     */
    @Override
    public T getEntry(int givenPosition) {
        return null;
    }

    /**
     * Displays the contents of the list to the console, in order.
     */
    @Override
    public void display() {
        System.out.print("LinkedHeadList { ");
        Node curentNode = headNode;
        while (curentNode != null){
            System.out.print(curentNode.data + ", ");
            curentNode = curentNode.next;
        }
        System.out.println("}");

    }

    /**
     * Checks whether this list contains a given entry.
     *
     * @param anEntry the object to search for in the list.
     * @return the position of the entry that was found or -1 if the object is not found.
     */
    @Override
    public int contains(T anEntry) {
        return 0;
    }

    /**
     * Gets the length of this list.
     *
     * @return The integer number of entries currently in the list.
     */
    @Override
    public int size() {
        return numberOfEntries;
    }

    /**
     * Checks whether this list is empty.
     *
     * @return True if the list is empty, or false if the list contains one or more elements.
     */

    public boolean isEmpty() {
        return (headNode == null ) ? true : false;
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





    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(LinkedHeadTailList<T> o) {
        return 0;
    }

    public static void main(String[] args) {
        LinkedHeadTailList<String> test = new LinkedHeadTailList<>();

        test.addFront("one");
        test.addFront("two");
        test.addFront("three");
        test.addFront("four");
        test.addBack("Zore");

        test.display();

    }
}//LinkedHeadTailList
