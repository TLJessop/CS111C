package com.Tljessop.VideoCodeAlong;


public class Node<T> {

    //Instance variables
    public T data;
    public Node next;

    //Constructor
    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    //Getters and Setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    //End of getters and setters
//
//    @Override
//    public String toString() {
//        return "Node{" +
//                "data=" + data +
//                ", next=" + next +
//                '}';
//    }
//
//    public static void main(String[] args){
//
//        Node a = new Node(9,null);
//        Node b = new Node(8, a);
//        Node c = new Node(6, b);
//        Node d = new Node(4,c);
//        Node firstNode = null;
//        //Node currentNode = firstNode;
//
//        method(firstNode);

        //System.out.println();
       // System.out.println(d.data);
        //System.out.println("d next : " + d.next);
//        System.out.println();
//        System.out.println(c.data);
//        System.out.println("c next : " + c.next);
//        System.out.println();
//        System.out.println(b.data);
//        System.out.println("b next : " + b.next);
//        System.out.println();
//        System.out.println(a.data);
//        System.out.println("a next : " + a.next);
//        System.out.println();
//        System.out.println(firstNode.data);
//        System.out.println("first next : " + firstNode.next);
//        System.out.println("firstNode chain " + firstNode.data + " " +firstNode.next);
//        System.out.println();
//        System.out.println(currentNode.data);
//        System.out.println("current next : " + currentNode.next);
//        System.out.println("currentNode chain " + currentNode.data + " " + currentNode.next);
//        System.out.println();

//
//    }
//
//    public static void method(Node firstNode) {
//        while(firstNode != null) {
//            System.out.println(firstNode.data);
//            firstNode = firstNode.next;
//        }
//    }

    public static void main(String[] args) {

        Node a = new Node(9,null);
        Node b = new Node(12, a);
           Node c = new Node(6, b);
        Node d = new Node(4,null);
      Node firstNode = d;

        printEveryOther(firstNode);
    }//main

    public static int countDivisibleBy(Node<Integer> firstNode, int divisor){
        int count = 0;

        Node<Integer> currentNode = firstNode;

        while (currentNode != null){

            if(currentNode.data % divisor == 0){
                count++;
            }
            currentNode = currentNode.next;
        }

        return count;
    }

    public static void printEveryOther(Node firstNode){
        int count = 1;

        Node<Integer> currentNode = firstNode;

        Node current = first;
        while(current.next!=null) {
            System.out.print(current.next.data);
            current = current.next;
        }
    }

}//node
