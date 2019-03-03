package HomeWork;

public class BoardPost {

    public static void main(String[] args) {
        int[] nums = new int[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i]=i;
        }

        nums[9] = -4;

        System.out.println(findMin(nums));
    }//main

    public static int findMin(int[] nums){
        return helpFindMin(nums,nums[0],0);
    }

    private static int helpFindMin(int[] nums, int min, int count){

       min = min > nums[count] ? nums[count] : min;

        if (count == nums.length-1){
            return min;
        } else {
            return helpFindMin(nums,min,count+1);
        }
    }

}//BoardPost
