package com.Tljessop.VideoCodeAlong;

import java.util.Arrays;

public class StudentTester {

    public static void main(String[] args) {

        Student[] students = new Student[5];

        students[0] = new Student("Jack", "Jones",1001);
        students[1] = new Student("James", "Jones",1002);
        students[2] = new Student("Zack", "Smith",1002);
        students[3] = new Student("Dave", "Daley",1004);
        students[4] = new Student("Rachel", "Daley",10555);

        for (Student student: students
             ) { System.out.println(student);
            System.out.println();
        }
        System.out.println("------------------------------------");
        Arrays.sort(students);

        for (Student student: students
        ) { System.out.println(student);
            System.out.println();
        }


    }//main

}//Class StudentTester