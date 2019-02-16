package com.Tljessop.VideoCodeAlong;

public class StudentTester {

    public static void main(String[] args) {

        Student s1 = new Student("Bill", "s4561");
        Student s2 = new Student("Bob", "s7612");
        Student s3 = new Student("Tom", "s4957");
        Student s4 = new Student("Dick", "s3047");

        //chain of nodes
        Node<Student> node1 = new Node<>(s1, null);
        Node<Student> node2 = new Node<>(s2, node1);
        Node<Student> node3 = new Node<>(s3, node2);
        Node<Student> node4 = new Node<>(s4, node3);

        //System.out.println(node1.getData());

        Node<Student> firstNode = new Node<>(s4,
                        new Node<>(s2,
                                new Node<>(s3,
                                        new Node<>(s1, null))));
        /*System.out.println(firstNode.getData());
        System.out.println(firstNode.next.data);
        System.out.println(firstNode.next.next.getData());
        System.out.println(firstNode.next.next.next.getData());
        System.out.println(firstNode.next.next.next.data);
        */

        printRoster(firstNode);

        removeStudent(3,firstNode);
        System.out.println();
        printRoster(firstNode);
        System.out.println();

        firstNode = firstNode.next;
        printRoster(firstNode);
    }//main

    public static void printRoster(Node<Student> headNode){
        Node<Student> currentNode = headNode;

        while (currentNode != null){
            System.out.println(currentNode.getData());
            currentNode = currentNode.next;

        }
    }
    public  static  Node<Student> removeStudent(int listPosition, Node<Student> headNode){
        if(headNode == null){
            return null;
        } else {
            Node<Student> nodeBefore = headNode;
            for (int i = 0; i < listPosition -1; i++) {
                nodeBefore = nodeBefore.next;
            }
            if (nodeBefore.next == null){
                return null;
            }else {
               Node<Student> returnNode = nodeBefore.next;
                nodeBefore.next = nodeBefore.next.next;
                return returnNode;
            }
        }
    }


}//StudentTester
