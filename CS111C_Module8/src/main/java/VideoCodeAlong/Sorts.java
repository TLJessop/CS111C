package VideoCodeAlong;

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









}//Sorts
