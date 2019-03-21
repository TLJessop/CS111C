package com.Tjlessop.VideoCodeAlong;

public class BoxTester {


    public static void main( String[] args ) {

    BoxRaw numberBox = new BoxRaw(5);
    numberBox.replaceContents(3);

    Integer boxContents = (Integer) numberBox.getContents();

    Box<Integer> numBox = new Box<>(34);
    Box<String> wordBox = new Box<>("Hello, world");


    }//main

}//class
