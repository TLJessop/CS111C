package com.Tjlessop.VideoCodeAlong;

public class Box<T> {

    //Instance variables
    private T thingy;
    private int thingCount;
    // End of instance variables

    //constructor
    public Box(T thingy){
        this.thingy = thingy;
        this.thingCount++;
    }

    //Getters and setters
    public T getContents() {
        return thingy;
    }

    public void replaceContents(T newThing){
        this.thingy = newThing;
        this.thingCount++;
    }

    public int getThingCount() {
        return thingCount;
    }
    // End of getters and setters

    @Override
    public String toString() {
        return thingy.toString() + "( item : " + thingCount + " )";
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if ( this == other) return true;

        if (other instanceof Box<?>){
            Box<?> otherBox = (Box<?>) other;

            if(this.thingy.equals(otherBox.thingy)){
                return true;
            } else return false;

        } else {
            return false;
        }
    }

}//class
