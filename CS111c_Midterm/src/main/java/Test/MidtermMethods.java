package Test;

public class MidtermMethods {

    public static void main(String[] args) {
        AList<Integer> nums = new AList<>();
      //  nums.add(8);

        System.out.println(recursiveCountMultiples(nums,2));



    }//main


    public static int recursiveCountMultiples(ListInterface<Integer> list, int number){
        if (number != 0 && !list.isEmpty()){
            return  helperRCM(list,number,1);
        } else {
            return 0;
        }
    }

    private static int helperRCM(ListInterface<Integer> list, int searchNum, int index){

        int count = ((list.getEntry(index) % searchNum) == 0) ? 1:0;
        if (index < list.getLength()){
            return count + helperRCM(list,searchNum,index+1);
        } else {
           return count;
        }
    }

}//MidtermMethods
