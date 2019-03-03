package VideoCodeAlong;

public class BlastOff {

    public static void main(String[] args) {
        countDown(10);
    }//main

    public static void countDown(int num){
        if (num == 0){
            System.out.println("Blastoff!");
        } else {
            System.out.println(num);
            countDown(num -1);
        }
    }

}//BlastOff
