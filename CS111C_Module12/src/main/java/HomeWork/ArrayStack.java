package HomeWork;

import java.util.EmptyStackException;
import java.util.Objects;

public class ArrayStack<T> implements StackInterface<T>{

    private int topIndex, numberOfItems;
    private T[] stack;

    private static final int DEFAULT_SIZE = 100;
    private static final int MIN_SIZE = 20;

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

}//ArrayStack
