package VideoCodeAlong;

import java.util.Stack;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
        System.out.println(stackFiboncaai(10));
    }

    public static int fibonacci(int num){
        if (num == 1 || num == 2){
            return 1;
        } else {
            return fibonacci(num - 1) + fibonacci( num - 2);
        }
    }

    public static int stackFiboncaai(int num){
        Stack<Integer> fibStack = new Stack<>();

        int result = 0;
        fibStack.push(num);

        while (!fibStack.empty()){
            int currentNum = fibStack.pop();

            if (currentNum == 1 || currentNum == 2){
                result +=1;
            } else {

                fibStack.push(currentNum -1);
                fibStack.push(currentNum -2);

            }

        }
        return result;
    }

}//Fibonacci
