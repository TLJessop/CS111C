package HomeWork;

public class DequeStackTester {
    public static void main(String[] args) {
        StackInterface<Integer> numStack = new DequeStack<>();

        numStack.push(1);
        numStack.push(2);
        numStack.push(3);
        numStack.push(4);
        System.out.println(numStack.isEmpty());
        System.out.println(numStack.peek());
        System.out.println(numStack.pop());
        System.out.println(numStack.pop());
        numStack.clear();
        System.out.println(numStack.isEmpty());

    }
}//DequeStackTester
