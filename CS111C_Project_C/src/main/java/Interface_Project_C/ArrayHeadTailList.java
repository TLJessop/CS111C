package Interface_Project_C;

import java.util.Arrays;

public class ArrayHeadTailList<T> implements HeadTailListInterface<T> {

        private T[] listArray;
        private int numberOfElements;
        private static int defaultSize = 25;


        public ArrayHeadTailList(int size){
            numberOfElements = 0;
            listArray = (T[]) new Object[size];
        }

        public ArrayHeadTailList(){
           this(defaultSize);
        }


        @Override
        public void addFront(T newEntry) {

            System.out.println(Arrays.toString(listArray));
            if(listArray[0] != null ){
                this.shiftBack();
            }
            numberOfElements++;
            listArray[0] = newEntry;
            System.out.println(Arrays.toString(listArray));
            System.out.println();
        }

        @Override
        public void addBack(T newEntry) {
            if(isEmpty()){
                listArray[0] = newEntry;
            } else {
                if(listArray[listArray.length-1] != null){
                makeRoom(); }
                listArray[numberOfElements] = newEntry;
            }


            numberOfElements++;
            System.out.println(Arrays.toString(listArray));

        }

        @Override
        public T removeFront() {
            if (!isEmpty()){
                T temp = listArray[0];
                listArray[0] = null;
                shiftUp();
                numberOfElements--;
                return temp;
            } else {
                throw new IndexOutOfBoundsException("Can not remove from the front of an empty list");
            }
        }

        @Override
        public T removeBack() {
            if (!isEmpty()){
                T temp = listArray[numberOfElements -1];
                listArray[numberOfElements-1] = null;
                numberOfElements--;
                return temp;
            } else {
                throw new IndexOutOfBoundsException("Can not remove from the back of an empty list");
            }
        }

        @Override
        public T getEntry(int position) throws IndexOutOfBoundsException {
            if(listArray[position] != null) {
                return listArray[position];
            }
           else {
               throw new IndexOutOfBoundsException("There is no element at position :" + position);
            }
        }


        @Override
        public void display() {
            for (int i = 0; i < listArray.length ; i++) {
                System.out.println("Element at index :" + i + "\n\t" + listArray[i]);
            }
        }

        @Override
        public int contains(T entry) {
            int count = -1;


            return count;
        }

        @Override
        public boolean isEmpty() {
            if(numberOfElements == 0){
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int size() {
            return numberOfElements;
        }

        @Override
        public void clear() {
            for (int i = 0; i > listArray.length; i++){
                listArray[i] = null;
            }
            numberOfElements = 0;
        }

        private void shiftBack(){

            if (numberOfElements + 1 > listArray.length){
                makeRoom();
            }
            for (int i = numberOfElements -1; i > -1; i--) {
                listArray[i + 1] = listArray[i];
            }

        }

        private void shiftUp(){
            if (numberOfElements + 1 > listArray.length){
                makeRoom();
            }
            for (int i = 0; i < numberOfElements -1; i++) {
                listArray[i] = listArray[i+1];
            }
        }

        private int makeRoom(){
            T[] newArray = (T[]) new Object[listArray.length * 2];

            for (int i = 0; i < listArray.length; i++){
                newArray[i] = listArray[i];
            }
            listArray = newArray;
            return listArray.length;
        }

}
