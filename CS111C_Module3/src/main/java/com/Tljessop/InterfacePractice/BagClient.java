package com.Tljessop.InterfacePractice;

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

        System.out.println(occurInBag(nameBag,"ff"));
        System.out.println(Arrays.toString(nameBag.toArray()));
        System.out.println();

        System.out.println();
        System.out.println();
        System.out.println();

        BagInterface<String> wordBag= new ArrayBag<>();

        wordBag.add("Hi");
        System.out.println(isSet(wordBag));

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

    /**
     * This method empties the given Integer bag
     * @param quizScoreBag the Integer bag to be emptied
     */
    public static  void emptyBag(BagInterface<Integer> quizScoreBag){
        while (!quizScoreBag.isEmpty()){
            quizScoreBag.remove();
        }
    }

    /**
     * Counts the number of time the search word occurs in the given string bag
     * @param wordBag The bag of strings to be searched
     * @param searchWord The string that this method will try to find in the bag
     * @return The number of occurrences of the search word in the string bag
     */
    public static int occurInBag(BagInterface<String> wordBag, String searchWord){
        BagInterface<String> tempBag = new ArrayBag<>();
        int occurrences =0;
        while (!wordBag.isEmpty()){
            String word = wordBag.remove();
            tempBag.add(word);

            if (word.equals(searchWord)){
                occurrences++;
            }
        }

        while (!tempBag.isEmpty()){
            wordBag.add(tempBag.remove());
        }
        return occurrences;
    }

    /**
     * This method checks for repeat words in the passed in wordBag
     * @param wordBag The String type BagInterface object that will be checked for duplicates
     * @return Returns true if no repeat words are found, false if the bag contains any duplicates.
     */
    public static boolean isSet(BagInterface<String> wordBag){
        if(!wordBag.isEmpty()){
            BagInterface<String> tempBag = new ArrayBag<>();
            while (!wordBag.isEmpty()){
                String word = wordBag.remove();
                tempBag.add(word);
                if(wordBag.contains(word)){
                    return false;
                }//test if
            }//test while

            while (!tempBag.isEmpty()){
                wordBag.add(tempBag.remove());
            }//refill while
            return true;
        } else return false;
    }//isSet



}//Class BagClient
