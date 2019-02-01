package com.Tljessop.VideoCodeAlong;

import java.util.Arrays;

public class BagClient {

    public static void main(String[] args) {

        //Testing removeLowestScore(
        ArrayBag<Integer> scoreBag = new ArrayBag<>();
        scoreBag.add(20);
        scoreBag.add(40);
        scoreBag.add(100);
        scoreBag.add(80);

        System.out.println(Arrays.toString(scoreBag.toArray()));

        try{
            removeLowestScore(scoreBag);
        } catch (IllegalAccessException e){
            e.getMessage();
        }

        System.out.println();
        System.out.println(Arrays.toString(scoreBag.toArray()));
        System.out.println();

        //Testing printStringContainingChar
        ArrayBag<String> nameBag = new ArrayBag<>();

        nameBag.add("Jack");
        nameBag.add("Tom");
        nameBag.add("Lynn");
        nameBag.add("Bob");

        System.out.println(Arrays.toString(nameBag.toArray()));
        System.out.println();

        printStringContainingChar(nameBag,'o');

        System.out.println(Arrays.toString(nameBag.toArray()));
        System.out.println();

        nameBag.clear();
        printStringContainingChar(nameBag,'o');




    }//main


    /**
     * Find the lowest score in the bag and removes it.
     * If there a matching values of the lowest score all are removed
     * @param quizBag the bag to be have the min value(s) removed
     * @throws IllegalAccessException is thrown if passed an empty bag
     */
    public static void removeLowestScore(BagInterface<Integer> quizBag) throws IllegalAccessException{
        if(!quizBag.isEmpty()){
            BagInterface<Integer> tempBag = new ArrayBag<>();
            Integer lowestScore = quizBag.remove();
            tempBag.add(lowestScore);

            while (!quizBag.isEmpty()){
                Integer currentScore = quizBag.remove();
                tempBag.add(currentScore);
                if (lowestScore > currentScore){
                    lowestScore = currentScore;
                }
            }

            while (!tempBag.isEmpty()){
                Integer score = tempBag.remove();
                quizBag.add(score);
            }

            quizBag.remove(lowestScore);
        } else {
            throw new IllegalAccessException("removeLowestScore can not be used on an empty score bag");
        }


    }


    public static void printStringContainingChar(BagInterface<String> stringBag, char targetChar){
        BagInterface<String> tempBag = new ArrayBag<>();

        while (!stringBag.isEmpty()){
            String word = stringBag.remove();
            tempBag.add(word);

            if (word.indexOf(targetChar) >= 0){
                System.out.println(word);
            }
        }

        while (!tempBag.isEmpty()){
            stringBag.add(tempBag.remove());
        }
    }

}//Class BagClient
