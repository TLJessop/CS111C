package com.Tljessop.VideoCodeAlong;

import java.util.Objects;

public class Student implements Comparable<Student>{

    //Instance variables
    private String firstName;
    private String lastName;
    private int studentId;
    //End of instance variables

    //Constructor
    public Student(String firstName, String lastName, int studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
    }

    //Getters and Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    // End of Getters and Setters

    //Overridden methods
    @Override
    public String toString() {
        return "Student Id:" + this.studentId + "\n" +
                "First Name: " + this.firstName + '\n' +
                "Last Name: " + this.lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null ) return false;
        if (this.getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return getStudentId() == student.getStudentId() &&
                getFirstName().equals(student.getFirstName()) &&
                getLastName().equals(student.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getStudentId());
    }

    @Override
    public int compareTo(Student otherStudent) {
        if (this == otherStudent) return 0;
        if( this.lastName.compareTo(otherStudent.lastName)!= 0){
            return this.lastName.compareTo(otherStudent.lastName);
        } else if ( this.firstName.compareTo(otherStudent.firstName) !=0){
            return this.firstName.compareTo(otherStudent.firstName);
        } else {
            return Integer.compare(this.studentId, otherStudent.studentId);
        }
    }
}//Class Student
