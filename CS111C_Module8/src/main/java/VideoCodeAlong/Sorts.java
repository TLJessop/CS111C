package VideoCodeAlong;

import java.util.Arrays;
import java.util.List;

public class Sorts {


    public static <T extends Comparable<T>> void selectionSort(Comparable<T>[] items){
        for (int i = 0; i < items.length; i++) {
           int indenOfMin = getMinIndex(items, i);
           Comparable temp = items[i];
           items[i] = items[indenOfMin];
           items[indenOfMin] = temp;
        }
    }

    private static <T extends Comparable<T>> int getMinIndex(Comparable<T>[] items, int arrayPosition ){
        Comparable minObject = items[arrayPosition];
        int minIndex = arrayPosition;

        for (int i = arrayPosition + 1; i < items.length; i++) {
            if (minObject.compareTo(items[i]) > 0 ) {
                minObject = items[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static <T extends Comparable<T>> void insertionSort(Comparable<T>[] items){
        for (int i = 1; i < items.length; i++) {
            Comparable unsortedItem = items[i];
            int sortedTop = i-1;
            insertHelper(unsortedItem, items, sortedTop);
        }
    }
    private static <T extends Comparable<T> > void insertHelper(Comparable unsortedItem, Comparable<T>[] items, int sortedTop ){
        int index = sortedTop;
        while (index >= 0 && unsortedItem.compareTo(items[index]) < 0){
            items[index + 1] = items[index];
            index--;
        }
        items[index+1] =unsortedItem;
    }







}//Sorts
