package HomeWork;

public class StackTester {

    public static void main(String[] args) {
        StackInterface<Integer> numStack = new ArrayStack<>(20);
        System.out.println(numStack);

        numStack.push(1);
        numStack.push(2);
        numStack.push(3);
        numStack.push(4);
        numStack.push(5);
        numStack.push(6);
        numStack.push(7);

        System.out.println(numStack);

        System.out.println(numStack.pop());
        System.out.println(numStack.pop());
        System.out.println(numStack.pop());
        System.out.println(numStack.pop());
        System.out.println(numStack.pop());
        System.out.println(numStack.pop());
        System.out.println(numStack.pop());

        numStack.clear();

        System.out.println(numStack);
    }

}//StackTester
