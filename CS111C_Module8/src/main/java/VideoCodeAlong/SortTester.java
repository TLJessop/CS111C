package VideoCodeAlong;

import java.util.Arrays;

public class SortTester {

    public static void main(String[] args){
        Integer[] nums = new Integer[4];

        for (int i = 0; i < nums.length; i++){
            nums[i] = (int) (Math.random() * nums.length);
        }

        System.out.println(Arrays.toString(nums) +'\n');

        //Sorts.selectionSort(nums);

        //Sorts.insertionSort(nums);

        //Sorts.shellSort(nums);

        //Sorts.mergeSort(nums);
        FasterSorts.mergeSort(nums);

        System.out.println(Arrays.toString(nums));

        System.out.println();
    }

}//SortTester
