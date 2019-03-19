package VideoCodeAlong;

import java.util.*;
import java.time.*;
//Given by Prof. Masters
public class EfficiencyExamples {

	public static void main(String[] args) {
		int listSize = 10;
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		fillList(numberList, listSize);
		System.out.println(numberList);

		Instant start = Instant.now();
		System.out.println("What's the middle value? " + getMiddleValue(numberList));
		Instant end = Instant.now();
		Duration timeSpent = Duration.between(start, end);
		System.out.println("Constant algorithm ran in " + timeSpent.toMillis() + " milliseconds.\n");	

		start = Instant.now();
		System.out.println("What's the sum? " + calculateSum(numberList));
		end = Instant.now();
		timeSpent = Duration.between(start, end);
		System.out.println("Linear algorithm ran in " + timeSpent.toMillis() + " milliseconds.\n");
		
		start = Instant.now();
		System.out.println("Contains a duplicate? " + containsDuplicates(numberList));
		end = Instant.now();
		timeSpent = Duration.between(start, end);
		System.out.println("Quadratic algorithm ran in " + timeSpent.toMillis() + " milliseconds.\n");

	}
	//The following three methods I wrote the functionality from Prof. Masters method headers

    //O(1)
	public static int getMiddleValue(ArrayList<Integer> numberList) {
			return numberList.get(numberList.size() / 2);
	}

	//O(n)
	public static int calculateSum(ArrayList<Integer> numberList) {
		int sum =0;

		for (Integer num: numberList
			 ) { sum += num;
		}
		return sum;
	}
	
	//O(n^2)
	public static boolean containsDuplicates(ArrayList<Integer> numberList) {

		for (int i = 0; i < numberList.size(); i++) {
			for (int j = 0; j < numberList.size() ; j++) {
				if (i != j){
					if (numberList.get(i) == numberList.get(j)){
						return true;
					}
				}
			}

		}

		return false;
	}

	private static void fillList(List<Integer> numberList, int size) {
		Random generator = new Random();
		int minNumber = 0;
		int maxNumber = size*2;
		for(int i=0; i<size; i++) {
			numberList.add(generator.nextInt(maxNumber - minNumber + 1) + minNumber);

		}
	}
}
