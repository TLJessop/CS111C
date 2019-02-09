package com.Tljessop.InterfacePractice;

import java.util.Arrays;
import java.util.List;

/**
 * This class was made as exercise in using the ListInterface class,
 * and contains four methods that will remove the lowest score from a test list
 *
 * @author Thomas Jessop
 * @version 1.0
 * @since 2019-01-31
 */

public class ListClient {

    /**
     * Driver method
     * @param args not used
     */

    public  static  void  main(String[] args){

        //Making test list
        ListInterface<Integer> scoreList = new AList<Integer>();

        scoreList.add(100);
        scoreList.add(80);
        scoreList.add(70);
        scoreList.add(50);
        scoreList.add(90);
        scoreList.add(80);
        scoreList.add(70);
        scoreList.add(50);
        scoreList.add(90);

        //Testing removeEveryLowestScore
        System.out.println(Arrays.toString(scoreList.toArray()));
        System.out.println();

        try {
            removeEveryLowestScore(scoreList);
        } catch (IllegalAccessException e){
            e.getMessage();
        }

        System.out.println(Arrays.toString(scoreList.toArray()));



        //Testing removeFirstLowestScore
        System.out.println(Arrays.toString(scoreList.toArray()));
        System.out.println();

        try {
            removeFirstLowestScore(scoreList);
        } catch (IllegalAccessException e){
            e.getMessage();
        }

        System.out.println(Arrays.toString(scoreList.toArray()));

        //Testing removeLastLowestScore
        System.out.println(Arrays.toString(scoreList.toArray()));
        System.out.println();

        try {
            removeLastLowestScore(scoreList);
        } catch (IllegalAccessException e){
            e.getMessage();
        }

        System.out.println(Arrays.toString(scoreList.toArray()));


    }// main

    /**
     * Removes the lowest score form the list.
     * If there a matching values of the lowest score only the first is removed
     * @param scoreList The list of scores that this method will remove the min value from
     * @return returns the value of the removed score
     * @throws IllegalAccessException is thrown if passed an empty list
     */
    public static Integer removeFirstLowestScore(ListInterface<Integer> scoreList) throws IllegalAccessException{
        if(!scoreList.isEmpty()) {
                int lowestScore = scoreList.getEntry(1);
                int lowestScoreIndex = 1;

                //indexed with starting point of one
                for (int i = 2; i <= scoreList.getLength(); i++) {
                    int currentScore = scoreList.getEntry(i);

                    if (currentScore < lowestScore) {
                        lowestScore = currentScore;
                        lowestScoreIndex = i;
                    }
                }

                scoreList.remove(lowestScoreIndex);
                return lowestScore;
        } else {
            throw new IllegalAccessException("removeFirstLowestScore can not be used on an empty score list ");
        }

    }// removeFirstLowestScore

    /**
     * Removes the lowest score form the list.
     * If there a matching values of the lowest score only the last is removed
     * @param scoreList The list of scores that this method will remove the min value from
     * @return returns the value of the removed score
     * @throws IllegalAccessException is thrown if passed an empty list
     */
    public static Integer removeLastLowestScore(ListInterface<Integer> scoreList) throws IllegalAccessException{
        if(!scoreList.isEmpty()) {
            int lowestScore = scoreList.getEntry(1);
            int lowestScoreIndex = 1;

            //indexed with starting point of one
            for (int i = scoreList.getLength(); i >= 1; i--) {
                int currentScore = scoreList.getEntry(i);
                if (currentScore < lowestScore) {
                    lowestScore = currentScore;
                    lowestScoreIndex = i;
                }
            }

            scoreList.remove(lowestScoreIndex);
            return lowestScore;
        } else {
            throw new IllegalAccessException("removeLastLowestScore can not be used on an empty score list ");
        }

    }// removeLastLowestScore

    /**
     * Removes the lowest score form the list.
     * If there a matching values of the lowest score all are removed
     * @param scoreList The list of scores that this method will remove the min value from
     * @return returns the value of the removed score
     * @throws IllegalAccessException is thrown if passed an empty list
     */
    public static Integer removeEveryLowestScore(ListInterface<Integer> scoreList) throws IllegalAccessException{
        Integer targetScore = removeFirstLowestScore(scoreList);
        while (scoreList.contains(targetScore)){
            removeFirstLowestScore(scoreList);
        }
        return targetScore;
    }

    /**
     * Overloaded version that take a List as oppose to ListInterface
     * Removes the lowest score form the list.
     * If there a matching values of the lowest score only the first is removed
     * @param scoreList The list of scores that this method will remove the min value from
     * @return returns the value of the removed score
     * @throws IllegalAccessException is thrown if passed an empty list
     */
    public static Integer removeFirstLowestScore(List<Integer> scoreList) throws IllegalAccessException{
        if (!scoreList.isEmpty()){
            int lowestScore = scoreList.get(0);

            for (Integer currentScore:
                 scoreList) {
               if (currentScore < lowestScore) lowestScore = currentScore;
            }

            scoreList.remove(Integer.valueOf(lowestScore));
            return lowestScore;
        }else {
            throw new IllegalAccessException("removeFirstLowestScore can not be used on an empty score list ");
        }
    }

    /**
     * This method takes in a word list returns a new version of said list,
     * that  contains all the words on the original word list that are shorter than a specific length.
     * @param wordList The word list be have a modified copy made of
     * @param length The length that the words on the new list must be shorter than
     * @return A new word list that contains all the words the were shorter then the specified length
     */

    public static ListInterface<String> createShortWordList(ListInterface<String> wordList, int length){
       ListInterface<String> newList = new AList<>();
        for (int i = 1; i <= wordList.getLength() ; i++) {
            if (wordList.getEntry(i).length() < length ){
                newList.add(wordList.getEntry(i));
            }
        }
        return newList;
    }//ListInterface

    /**
     * This method returns the last index of the target word in the passed String list.
     * @param wordList The String list to be searched
     * @param targetWord The String the the String list will be checked for
     * @return The last index of the target word, or if the target word is not in the String list -1 will be returned
     */
    public static int lastPosition(List<String> wordList, String targetWord){
        int lastIndex = -1;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(targetWord)){
                 lastIndex = i;
                }
        }
        return lastIndex;
    }

    /**
     * This method test to see if a given List and ListInterface are logically equal
     * @param numberList Integer list to be test against the Integer ListInterface
     * @param numberListInterface Integer ListInterface to be test against the Integer list
     * @return Returns true if the list have the same Integers in the same order and are the same length.
     *          Otherwise returns false
     */
    public static boolean equivalentLists(List<Integer> numberList, ListInterface<Integer> numberListInterface){
        boolean equivalent = false;

        if(numberList.size() == numberListInterface.getLength()){
            //Safeguard against edge case of double uninitiated lists, because the for loop will not been entered
            if (numberList.size() == 0 && numberListInterface.getLength() == 0) return true;

            for (int i =0; i < numberList.size(); i++){
                if (numberList.get(i) == numberListInterface.getEntry(i + 1)){
                    equivalent = true;
                }
            }
        }
        return equivalent;
    }// equivalentLists

    /**
     * This method puts the lowest value in the list at the front.
     * Note this is not an equivalent to sort, the positions of values greater than the minimum are not guaranteed
     * @param numberList The Integer list that will be searched through
     */
    public static void prioritizeMinimumValue(List<Integer> numberList){
       if(numberList.size()!=0) {
           int minimum = numberList.get(0);
           for (int i = 0; i < numberList.size(); i++) {
               if (numberList.get(i) <= minimum) {
                   minimum = numberList.get(i);
                   numberList.remove(i);
                   numberList.add(0, minimum);
               }
           }
       }
    }



}//Class ListClient
