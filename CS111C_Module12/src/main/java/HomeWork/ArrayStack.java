package HomeWork;

import java.util.EmptyStackException;
import java.util.Objects;

public class ArrayStack<T> implements StackInterface<T>{

    //Instance data
    private int topIndex, numberOfItems;
    private T[] stack;

    //Class constants
    private static final int DEFAULT_SIZE = 100;
    private static final int MIN_SIZE = 20;

    //Constructors
    public ArrayStack(int numItems){
        if (numItems >= MIN_SIZE){
            stack = (T[]) new Object[numItems];
        } else {
            stack = (T[]) new Object[MIN_SIZE];
        }

        topIndex = -1;
        numberOfItems = 0;
    }

    public ArrayStack(){
        this(DEFAULT_SIZE);
    }

    //Core methods
    public void push(T newEntry) {
        if (numberOfItems == stack.length - 1) {
            T[] tempArray = stack;
            stack = (T[]) new Object[tempArray.length * 2];

            for (int i = 0; i <= topIndex; i++) {
                stack[i] = tempArray[i];
            }
        }

        stack[topIndex + 1] = newEntry;
        topIndex++;
        numberOfItems++;
    }


    public T pop() {
        if (numberOfItems > 0){
            T returnValue = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            numberOfItems--;
            return returnValue;
        } else {
            throw new EmptyStackException();
        }
    }


    public T peek() {
        if(numberOfItems > 0){
            return stack[topIndex];
        } else {
            throw new EmptyStackException();
        }
    }


    public boolean isEmpty() {
        return numberOfItems == 0;
    }


    public void clear() {
        for (int i = topIndex; i >= 0; i--){
            stack[i] = null;
        }
        numberOfItems = 0;
        topIndex = -1;
    }

    public int getNumberOfItems(){
        return numberOfItems;
    }

    //Standard Object class overrides
    @Override
    public String toString(){
        StringBuilder returnString = new StringBuilder("ArrayStack [");
        for (int i = topIndex; i >= 0; i--){
            returnString.append(stack[i]);
            if (i > 0){
                returnString.append(", ");
            }
        }
        returnString.append("]");

        return returnString.toString();
    }

    @Override
    public int hashCode(){
        int hash = Objects.hash(numberOfItems);

        for (int i = 0; i <= topIndex; i++){
            hash += Objects.hash(stack[i]);
        }

        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this ) return true;
        if (obj.getClass() == ArrayStack.class){
            ArrayStack<?> other = (ArrayStack<?>) obj;
            if (this.numberOfItems != other.numberOfItems){
                return false;
            }
            for (int i = 0; i <= topIndex; i++){
                if (!stack[topIndex].equals(other.stack[other.topIndex])){
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

}//ArrayStack
