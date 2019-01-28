package com.Tjlessop.VideoCodeAlong;

import java.util.Objects;

public class Pair<T extends Comparable<T>> implements Comparable<Pair<T> >{

    private T item1, item2;

    public Pair(T item1,T item2){
        this.item1 = item1;
        this.item2 = item2;
    }

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
    //End of Getters and Setters

    public boolean sameItems(){
        return item1.equals(item2);
    }

    @Override
    public String toString() {
        return item1 + "\t" + item2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null ) return false;
        if ( this == obj) return true;

        if (obj.getClass().getName() == this.getClass().getName()){
           Pair<?> otherPair = (Pair<?>) obj;
            if((this.item1.equals(otherPair.item1) && this.item2.equals(otherPair.item2))
                    || (this.item1.equals(otherPair.item2) && this.item2.equals(otherPair.item1) ) ){
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
        return Objects.hash(item1,item2);
    }

    @Override
    public int compareTo(Pair<T> otherPair){
        if (this == otherPair) return 0;

        if (this.item1.compareTo(otherPair.item1) !=0 ){
            return this.item1.compareTo(otherPair.item1);
        } else {
            return this.item2.compareTo(otherPair.item2);
        }
    }

}//class
