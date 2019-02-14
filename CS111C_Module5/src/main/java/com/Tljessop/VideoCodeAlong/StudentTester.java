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

        System.out.println(node1.getData());

        Node<Student> firstNode = new Node<>(s4,
                        new Node<Student>(s2,
                                new Node<Student>(s2,
                                        new Node<Student>(s1, null))));
        System.out.println(firstNode.getData());
        System.out.println(firstNode.next.data);
        System.out.println(firstNode.next.next.getData());
        System.out.println(firstNode.next.next.next.getData());
        System.out.println(firstNode.next.next.next.data);

    }//main

}//StudentTester
