package VideoCodeAlong;

public class EvenMoreRecursionMethods {

    public static void main(String[] args) {

        System.out.println(sumUp(10));

        System.out.println(charCounter("this works", 's'));

        int[] nums = new int[5];
        nums[0] = 1;
        nums[1] = 1;
        nums[2] = 1;
        nums[3] = 1;
        nums[4] = 1;

        System.out.println(arraySum(nums)+"\n");

        System.out.println("6 - 3 = " + recursiveSubtraction(6,3));

        int fNum = 20;

        System.out.println("\n" + "fibonacci " +fNum +" count is " + fibonacci(fNum));
    }//main

    public static int sumUp(int cap){
        return helperSumUp(cap, 0,0);
    }

    private static int helperSumUp(int cap, int count,int sum){
        sum += count;
        if (count == cap){
            return sum;
        } else {
           return helperSumUp(cap,count+1,sum);
        }
    }

    public static int charCounter(String string, char searchChar){
        return helperCharCount(string, searchChar, 0,0);
    }

    private static int helperCharCount(String string, char searchChar, int index, int charCount){

        if(searchChar == string.charAt(index)){
            charCount++;
        }

        if ( index == string.length() - 1){
            return charCount;
        } else {
            return helperCharCount(string,searchChar,index + 1,charCount);
        }
    }

    public static int arraySum(int[] nums){
        return helperArraySum(nums, 0);
    }

    private static int helperArraySum(int[] nums, int count){

        if (count == nums.length - 1){
            return nums[count];
        } else {
            return nums[count] + helperArraySum(nums,count+1);
        }
    }

    public static int recursiveSubtraction(int base, int reduction){
        if (base == reduction){
            return 0;
        } else {
            return recursiveSubtraction(base-1, reduction) + 1;
        }
    }

    public static int fibonacci(int num){
        if (num < 2 ){
            return num;
        } else {
            return fibonacci(num -1) + fibonacci(num -2);
        }
    }
}//EvenMoreRecursionMethods
