package com.Tjlessop.Homework;


import java.util.Objects;

public class Trio<T> {

    //Instance variables
    private T item1;
    private T item2;
    private T item3;
    //End of instance variables

    //Constructors
    public Trio (T item1, T item2, T item3){
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public Trio (T item1){
        this.item1 = item1;
    }
    // End of Constructors

    //Getters and Setters
    public T getItem1() {
        return item1;
    }

    public void setItem1(T item1) {
        this.item1 = item1;
    }

    public T getItem2() {
        return item2;
    }

    public void setItem2(T item2) {
        this.item2 = item2;
    }

    public T getItem3() {
        return item3;
    }

    public void setItem3(T item3) {
        this.item3 = item3;
    }
    //End of Getters and Setters

    public int contains( T checkThing){
        int occurrenceNum =0;

        if (checkThing.equals(item1)) occurrenceNum++;
        if (checkThing.equals(item2)) occurrenceNum++;
        if (checkThing.equals(item3)) occurrenceNum++;

        return occurrenceNum;
    }

    public boolean hasDuplicates(){

        // Because of the symmetric clause of the equals contract this is all the testing needed
        return item1.equals(item2) || item1.equals(item3) ||
                item2.equals(item3);
    }


    @Override
    public String toString() {
        return "Trio \t{ " +
                "item1=" + item1 +
                "\n\t\titem2=" + item2 +
                "\n\t\titem3=" + item3 +
                "\t}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() == obj.getClass()){
            Trio<?> otherTrio = (Trio<?>) obj;
            boolean thing1Matched;
            boolean thing2Matched;
            boolean thing3Matched;

            if (this.item1.equals(otherTrio.item1) || this.item1.equals(otherTrio.item2)||
                this.item1.equals(otherTrio.item3)){
                thing1Matched = true;
            } else {
                thing1Matched = false;
            }
            if (this.item2.equals(otherTrio.item1) || this.item2.equals(otherTrio.item2)||
                    this.item2.equals(otherTrio.item3)){
                thing2Matched = true;
            } else {
                thing2Matched = false;
            }
            if (this.item3.equals(otherTrio.item1) || this.item3.equals(otherTrio.item2)||
                    this.item3.equals(otherTrio.item3)){
                thing3Matched = true;
            } else {
                thing3Matched = false;
            }

            if (thing1Matched && thing2Matched && thing3Matched){
                return true;
            } else {
                return false;
            }


        } else {
            return false;
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(getItem1(), getItem2(), getItem3());
    }
}//Class Trio
