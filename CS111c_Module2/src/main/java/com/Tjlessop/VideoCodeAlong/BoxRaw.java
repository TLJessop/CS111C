package com.Tjlessop.VideoCodeAlong;

public class BoxRaw {

    //Instance variables
    private Object thingy;
    private int thingCount;
    // End of instance variables

    //constructor
    public BoxRaw(Object thingy){
        this.thingy = thingy;
        this.thingCount++;
    }

    //Getters and setters
    public Object getContents() {
        return thingy;
    }

    public void replaceContents(Object newThing){
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

        if (other instanceof BoxRaw){
            BoxRaw otherBox = (BoxRaw) other;

            if(this.thingy.equals(otherBox.thingy)){
                return true;
            } else return false;

        } else {
            return false;
        }
    }
}//class
