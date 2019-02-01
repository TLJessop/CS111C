package com.Tljessop.VideoCodeAlong;

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


}//Class ListClient
