package Workspace;

public class TestArea {


    public static void main(String[] args) {
            QueueInterface<Integer> testQueue = new LinkedQueue<Integer>();
            testQueue.enqueue(-1);
            testQueue.enqueue(2);
            testQueue.enqueue(3);
            testQueue.enqueue(1);
            testQueue.enqueue(5);
            testQueue.enqueue(5);

            System.out.println(testQueue);
            removeNegativesFromQueue(testQueue);
            System.out.println(testQueue);


    }

    public static ListInterface<Integer> removeNegativesFromQueue(QueueInterface<Integer> queue){
        ListInterface<Integer> returnList = new AList();
        QueueInterface<Integer> tempQueue = new LinkedQueue<Integer>();

        while (!queue.isEmpty()){
            Integer currentNum = queue.dequeue();
            if (currentNum < 0 ){
                returnList.add(currentNum);
            } else {
                tempQueue.enqueue(currentNum);
            }
        }

        while (!tempQueue.isEmpty()){
            queue.enqueue(tempQueue.dequeue());
        }

        return  returnList;
    }

}//TestArea
