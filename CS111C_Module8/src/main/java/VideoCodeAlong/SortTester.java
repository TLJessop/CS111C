package VideoCodeAlong;

import java.util.Arrays;

public class SortTester {

    public static void main(String[] args){
        Integer[] nums = new Integer[1000];

        for (int i = 0; i < nums.length; i++){
            nums[i] = (int) (Math.random() * nums.length);
        }

        System.out.println(Arrays.toString(nums));

        Sorts.selectionSort(nums);

        System.out.println(Arrays.toString(nums));

    }

}//SortTester
