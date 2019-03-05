package HomeWork;

import java.util.Arrays;

public class QuizMethods {

    public static void main(String[] args) {

        System.out.println(qNotFollowedByU("Qu"));

        int[] nums = new int[6];
        for (int i = 0; i <nums.length ; i++) {
            nums[i] = i;
        }
        reverseArray(nums);
        System.out.println(Arrays.toString(nums));


    }//main

    public static boolean qNotFollowedByU(String word){
        // Making a single case copy make comparing simpler
        String lowerCaseWord = word.toLowerCase();

        return qHelper(0,lowerCaseWord);
    }

    private static boolean qHelper( int count ,String searchWord) {

        if (searchWord.length() > count +1){
            if(searchWord.charAt(count) == 'q' && searchWord.charAt(count+1) == 'u'){
                return false;
            }else {
                return qHelper(count+1, searchWord);
            }
        } else {
            return true;
        }
    }

    public static void reverseArray(int[] array){
        reverseHelper(array,0,array.length-1);
    }
    private static void reverseHelper(int[] nums, int forwardCount, int backwardCount){
        if(forwardCount < backwardCount){
            int temp = nums[forwardCount];
            nums[forwardCount] = nums[backwardCount];
            nums[backwardCount] = temp;

            reverseHelper(nums,forwardCount+1,backwardCount-1);
        }
    }

}//QuizMethods
