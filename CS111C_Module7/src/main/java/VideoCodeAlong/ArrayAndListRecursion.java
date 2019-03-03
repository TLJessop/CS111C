package VideoCodeAlong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAndListRecursion {

    public static void main(String[] args) {
        linePerChar("hello");

        int[] nums = new int[5];
        nums[0]=1;
        nums[1]=2;
        nums[2]=3;
        nums[3]=4;
        nums[4]=5;

        System.out.println("\n" + Arrays.toString(nums));
        doubleNums(nums);
        System.out.println(Arrays.toString(nums) + "\n");

        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numList.add(i);
        }

        System.out.println(Arrays.toString(numList.toArray()));
        doubleNums(numList);
        System.out.println(Arrays.toString(numList.toArray()));

    }//main

    public static void linePerChar(String string){
        System.out.println(string.charAt(0));

        if (string.length() != 1){
            linePerChar(string.substring(1));
        }

    }

    public static int[] doubleNums(int[] nums){
        return helperDoubleNums(nums,0);
    }

    public static List<Integer> doubleNums(List<Integer> numList){
        return helperDoubleNumList(numList,0);
    }

    private static int[] helperDoubleNums(int[] nums, int count){
        nums[count] = nums[count] *2;

        if (count == nums.length -1) {
            return nums;
        } else{
            return helperDoubleNums(nums,count+1);
        }
    }

    public static List<Integer> helperDoubleNumList(List<Integer> numList, int count){
        numList.set(count, numList.get(count) * 2);

        if (count == numList.size() -1) {
            return numList;
        } else{
            return helperDoubleNumList(numList,count+1);
        }
    }

}//ArrayAndListRecursion
