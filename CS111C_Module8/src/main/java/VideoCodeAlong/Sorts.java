package VideoCodeAlong;

import java.util.Arrays;

public class Sorts {


    public static <T extends Comparable<T>> void selectionSort(Comparable<T>[] items){
        for (int i = 0; i < items.length; i++) {
           int indexOfMin = getMinIndex(items, i);
           Comparable temp = items[i];
           items[i] = items[indexOfMin];
           items[indexOfMin] = temp;
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

    public static  <T extends Comparable<T>> void shellSort(Comparable<T>[] items){
        int spacing = items.length / 2;

        while (spacing > 0){
            if (spacing % 2 == 0){
                spacing += 1;
            }
            for (int i = 0; i < spacing; i++){
                shellHelper(items, i, items.length-1,spacing);
            }
            spacing /= 2;
        }
    }

    private static <T extends Comparable<T>> void shellHelper(Comparable<T>[] items, int first, int last, int space){

        for (int i = first + space; i <= last; i += space){
            Comparable next = items[i];

            int index = i - space ;
            while (index >= first && next.compareTo(items[index]) < 0){
                items[index + space] = items[index];
                index--;
            }
            items[index+1] = next;

        }
    }

    public static <T extends Comparable<T>>  void mergeSort(Comparable[] items){
        Comparable[] tempArray = new  Comparable[items.length];
        mergeSortHelper(items,tempArray,0, items.length-1);
    }

    private static  <T extends Comparable<T>> void mergeSortHelper(Comparable[] array, Comparable[] tempArray, int first, int last ){

        if (first < last) { System.out.println(Arrays.toString(array) +"or\ntr"+Arrays.toString(tempArray)+"\n");
            int mid = (first + last) / 2;
            mergeSortHelper(array,tempArray,first,mid);
            mergeSortHelper(array,tempArray,mid +1 , last);

            if (array[mid].compareTo(array[mid +1]) > 0 ){
                merge(array,tempArray,first,mid,last);
            }
        }
    }

    private static void merge(Comparable[] array, Comparable[] tempArray, int first, int mid, int last){

        int startPoint1 = first;
        int endPoint1 = mid;
        int halfStartPoint2 = mid+1;
        int halfEndPoint2 = last;

        int index = startPoint1;

        while ((startPoint1 <= endPoint1) && (halfStartPoint2 <= halfEndPoint2 )){
            if (array[startPoint1].compareTo(halfStartPoint2) < 0 ){
                System.out.println(array[startPoint1]);
                tempArray[index] = array[startPoint1];
                startPoint1 ++;
            } else {
                tempArray[index] = array[halfStartPoint2];
                halfStartPoint2 ++;
            }
            index++;
        }
        /*
        		int beginHalf1 = first;
		int endHalf1 = mid;
		int beginHalf2 = mid+1;
		int endHalf2 = last;

		int index = beginHalf1;

		// there are more elements still in both lists
		while((beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2) ) {
			if (array[beginHalf1].compareTo(array[beginHalf2]) < 0) {
				tempArray[index] = array[beginHalf1];
				beginHalf1++;
			} else {
				tempArray[index] = array[beginHalf2];
				beginHalf2++;
			}
			index++;
		}

         */

        while (startPoint1 <= endPoint1 ){
            tempArray[index] = array[index];
            startPoint1++;
            index++;
        }
        while (halfStartPoint2 <= halfEndPoint2 ){
            tempArray[index] = array[index];
            halfStartPoint2++;
            index++;
        }

        for ( index = first; index <= last; index ++){
            array[index] = tempArray[index];
        }


    }


}//Sorts
