package HomeWork;

import java.text.NumberFormat;
import java.util.Arrays;

@SuppressWarnings({"rawtypes", "unchecked"})
public class HomeworkM8Driver {

	public static void main(String[] args) {
		NumberFormat formatter = NumberFormat.getPercentInstance();

		System.out.println("*********************Array Sortedness Tester");
		Integer[] array1 = {1, 2, 3, 3, 5};
		Integer[] array2 = {1, 2, 3, 4, 5, 5};
		Integer[] array3 = {10, 8, 5, 3, 1};
		Integer[] array4 = {12, 11, 9, 3, 2, 1};
		Integer[] array5 = {2, 8, 3, 9, 6};
		Integer[] array6 = {7, 1, 6, 8, 5, 2};
		String[] array7 = {"abc", "def", "ghi"};

		System.out.println("Sortedness \t100% \t" + formatter.format(sortedness(array1)));
		System.out.println("Sortedness \t100% \t" + formatter.format(sortedness(array2)));
		System.out.println("Sortedness \t0% \t" + formatter.format(sortedness(array3)));
		System.out.println("Sortedness \t0% \t" + formatter.format(sortedness(array4)));
		System.out.println("Sortedness \t50% \t" + formatter.format(sortedness(array5)));
		System.out.println("Sortedness \t40% \t" + formatter.format(sortedness(array6)));
		System.out.println("Sortedness \t100% \t" + formatter.format(sortedness(array7)));

		System.out.println("\n*********************Node Sortedness Tester: Iterative");

		// this code uses the same values as the arrays above
		Node<Comparable> chain1 = new Node<Comparable>(1, new Node<Comparable>(2, new Node<Comparable>(3,
				new Node<Comparable>(3, new Node<Comparable>(5)))));
		Node<Comparable> chain2 = new Node<Comparable>(1, new Node<Comparable>(2, new Node<Comparable>(3,
				new Node<Comparable>(4, new Node<Comparable>(5, new Node<Comparable>(5))))));
		Node<Comparable> chain3 = new Node<Comparable>(10, new Node<Comparable>(8, new Node<Comparable>(5,
				new Node<Comparable>(3, new Node<Comparable>(1)))));
		Node<Comparable> chain4 = new Node<Comparable>(12, new Node<Comparable>(11, new Node<Comparable>(9,
				new Node<Comparable>(3, new Node<Comparable>(2, new Node<Comparable>(1))))));
		Node<Comparable> chain5 = new Node<Comparable>(2, new Node<Comparable>(8, new Node<Comparable>(3,
				new Node<Comparable>(9, new Node<Comparable>(6)))));
		Node<Comparable> chain6 = new Node<Comparable>(7, new Node<Comparable>(1, new Node<Comparable>(6,
				new Node<Comparable>(8, new Node<Comparable>(5, new Node<Comparable>(2))))));
		Node<Comparable> chain7 = new Node<Comparable>("abc",
				new Node<Comparable>("def", new Node<Comparable>("ghi")));

//		System.out.println("Sortedness \t100% \t" + formatter.format(sortednessIterative(chain1)));
//		System.out.println("Sortedness \t100% \t" + formatter.format(sortednessIterative(chain2)));
//		System.out.println("Sortedness \t0% \t" + formatter.format(sortednessIterative(chain3)));
//		System.out.println("Sortedness \t0% \t" + formatter.format(sortednessIterative(chain4)));
//		System.out.println("Sortedness \t50% \t" + formatter.format(sortednessIterative(chain5)));
//		System.out.println("Sortedness \t40% \t" + formatter.format(sortednessIterative(chain6)));
//		System.out.println("Sortedness \t100% \t" + formatter.format(sortednessIterative(chain7)));
////
//		System.out.println("\n*********************Node Sortedness Tester: Recursive (Extra Credit Option)");
//		System.out.println("Sortedness \t100% \t" + formatter.format(sortednessRecursive(chain1)));
//		System.out.println("Sortedness \t100% \t" + formatter.format(sortednessRecursive(chain2)));
//		System.out.println("Sortedness \t0% \t" + formatter.format(sortednessRecursive(chain3)));
//		System.out.println("Sortedness \t0% \t" + formatter.format(sortednessRecursive(chain4)));
//		System.out.println("Sortedness \t50% \t" + formatter.format(sortednessRecursive(chain5)));
//		System.out.println("Sortedness \t40% \t" + formatter.format(sortednessRecursive(chain6)));
//		System.out.println("Sortedness \t100% \t" + formatter.format(sortednessRecursive(chain7)));

	}

	public static double sortedness(Comparable[] array) {
		Comparable[] temp = new Comparable[array.length];

		for (int i=0; i<array.length; i++) {

			temp[i] = array[i];

		}

		Arrays.sort(temp);

		int correctPos = 0;

		for (int i=0; i<array.length; i++) {

			if (temp[i].compareTo(array[i]) == 0) {

				correctPos ++;

			}

		}

		return (1.0 * correctPos)/(1.0 * array.length);


	}
//
//	public static double sortednessIterative(Node<Comparable> node) {
//		double sortedVal = 1;
//
////((double) specieMap.get(genus).size() / totalSpeciesCount )  * 100)
//
//		double changeRate = (1.0 / array.length ) ;
//
//		while (node.next != null) {
//			if(node.data.compareTo(node.next.data ) > 0 ){
//				sortedVal -= changeRate;
//			} else if (node.data.compareTo(node.next.data ) < 0){
//				sortedVal += changeRate;
//			}
//			node = node.next;
//		}
//
//
//		sortedVal = sortedVal > 1 ? 1 : sortedVal;
//
//
//		return sortedVal;
//	}
////
//	public static double sortednessRecursive(Node<Comparable> node) {
//		// YOUR CODE HERE
//		return 0;
//	}

}