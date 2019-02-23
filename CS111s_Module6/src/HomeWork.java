
import java.util.Arrays;

public class HomeWork {

    public static void main(String[] args){

        int[] nums = new  int[10];

        randomFill(nums);

        System.out.println(Arrays.toString(nums));



    }

    public static void randomFill(int[] numArray){
        int swapIndex;
        //Making an array 5 times bigger then the passed in array
        int[] asignmentNums = new int[(numArray.length * 5) + 1];

        //filling it with non-repeating values
        for (int i = 0; i < asignmentNums.length; i++) {
                asignmentNums[i] =i;
        }

        // Fisher-Yates shuffle, except I started from thr front because forward iterating
        for (int i = 0; i <= asignmentNums.length-1 ; i++) {
            swapIndex = (int) (Math.random() * (i + 1) );
            int temp = asignmentNums[i];
            asignmentNums[i] = asignmentNums[swapIndex];
            asignmentNums[swapIndex] = temp;

        }

        //Assigning values to the passed in array
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = asignmentNums[i];

        }

    }

}
