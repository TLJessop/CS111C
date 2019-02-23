
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HomeWork {

    public static void main(String[] args){

        int[] nums = new  int[10];

        randomFill(nums);

       // System.out.println(Arrays.toString(nums));


        List<Integer> numies = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numies.add(2);
        }

        //numies.add(2);
       // numies.add(17);
        //numies.add(39);


        List<Integer> repeats = findDuplicates(numies);

        for (Integer num: repeats
             ) {
            System.out.println(num);
        }


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


    public static List<Integer> findDuplicates(List<Integer> numbers) {

        //Using arrays because most list methods have a big o notation on O(n)
        Integer[] cloneArray = new Integer[numbers.size()];
        Integer[] repeatNums = new Integer[numbers.size()-1];


        for (int i = 0; i < numbers.size(); i++){
                cloneArray[i] = numbers.get(i);
        }

        //I checked the big notation of this method is O(log(n) )
        // source https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#sort(int[])
        Arrays.sort(cloneArray);

        for (int i = 0; i < cloneArray.length -1 ; i++) {
            if (cloneArray[i] == cloneArray[i+1]){
                repeatNums[i] = Integer.valueOf(cloneArray[i]);
            }
        }


        for (int i = 1; i < repeatNums.length; i++){
            if (repeatNums[i-1] == null){
                repeatNums[i-1] = repeatNums[i];
                repeatNums[i] = null;
            }
        }

        //Removing any nulls.
        Integer[] outArray = Arrays.stream(repeatNums).filter(Objects::nonNull).toArray(Integer[]::new);

        List<Integer> duplicateList =  Arrays.asList(outArray);

        return duplicateList;
    }

}
