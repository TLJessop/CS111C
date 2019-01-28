package com.Tjlessop.VideoCodeAlong;

public class PairTester {

    public static void main(String[] args) {

        Pair<Integer> numPair = new Pair<>(3,7);
        Pair<String> wordPair = new Pair<>("AAAA", "BBBB");

        //System.out.println(numPair);
        //System.out.println(wordPair);

        String s1 = "AAAA";
        String s2 = "aaaa";
        Pair<String> applePair = new Pair<>(s1,s2);
        System.out.println(applePair.compareTo(wordPair));

        System.out.println(s1.compareTo(wordPair.getItem1()));



    }//main

}//class
