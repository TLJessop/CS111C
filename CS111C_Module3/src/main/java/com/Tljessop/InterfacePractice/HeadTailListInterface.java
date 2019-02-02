package com.Tljessop.InterfacePractice;

/** An interface for the HeadTailList abastract data type.
 Entries in a HeadTailList can only added or removed from either the first or last index.
 Yet entries may be accessed from any position on the list.
 @author Thomas Lynn Jessop
 @version 1.0
 @since 2019-01-31
 */

public interface HeadTailListInterface<T> {

    /**
     * Adds a new object of the specified type to the first index of the list
     * @param newEntry The object to be placed at the beginning of the list
     */
    void addFront(T newEntry);

    /**
     * Adds a new object of the specified type to the last index of the list
     * @param newEntry The object to be placed at the end of the list
     */
    void addBack(T newEntry);

    /**
     * Removes the first object on the list, and shifts to the front the remaining objects on the list.
     * After doing so the size of the list is decremented
     * @return The object that was at the beginning of the list
     * @throws IndexOutOfBoundsException This exception is thrown if the method is used on an empty list
     */
    T removeFront();

    /**
     * Removes the last object on the list.
     * After doing so the size of the list is decremented
     * @return The object that was at the beginning of the list
     * @throws IndexOutOfBoundsException This exception is thrown if the method is used on an empty list
     */
    T removeBack();

    /**
     * Returns the contains of the list at the given index
     * @param position The index of the desired object
     * @return The object at the given index
     * @throws IndexOutOfBoundsException This exception is thrown if the given index does not exist on the list
     */
    T getEntry(int position);

    /**
     * Formats the list in to a user-friendly String and writes that String to standard out
     */
    void display();

    /**
     * Searches the list for a given object of the specified type.
     * Note the a positive result will occur for matches that aliases or logical equal
     * @param entry the object that is to be deemed whether or not is contained in the list
     * @return If the given object is found in the list the index of the matching object is returned.
     *         If the given object is not found returns -1
     */
    int contains (T entry);

    /**
     * Informs the caller of whether the list currently contains any objects
     * @return Returns true if there are no objects in the list, otherwise returns false
     */
    boolean isEmpty();

    /**
     * Returns the current length of the list
     * @return The number of objects currently in the list.
     */
    int size();

    /**
     * Removes all objects from the list and sets the list length to 0
     */
    void clear();


}//Class HeadTailListInterface
