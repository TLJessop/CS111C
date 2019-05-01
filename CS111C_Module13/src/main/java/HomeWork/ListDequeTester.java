package HomeWork;

public class ListDequeTester {
    public static void main(String[] args) {
        DequeInterface<Integer> numDeque = new LinkedDeque<>();

        numDeque.addToFront(3);
        numDeque.addToFront(2);
        numDeque.addToFront(1);
        numDeque.addToBack(4);
        numDeque.addToBack(5);
        System.out.println(numDeque.isEmpty());
        System.out.println(numDeque.removeFront());
        System.out.println(numDeque.removeFront());
        System.out.println(numDeque.removeFront());
        System.out.println(numDeque.removeBack());
        System.out.println(numDeque.isEmpty());
        numDeque.clear();
        System.out.println(numDeque.isEmpty());


    }
}//ListDequeTester
