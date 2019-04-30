package Homework;

public class HomeworkM14Driver {

	public static void main(String[] args) {
		//leaves
		BinaryTree<Integer> tree42a = new BinaryTree<Integer>(42);
		BinaryTree<Integer> tree46 = new BinaryTree<Integer>(46);
		BinaryTree<Integer> tree13a = new BinaryTree<Integer>(13);
		BinaryTree<Integer> tree65a = new BinaryTree<Integer>(65);
		BinaryTree<Integer> tree63 = new BinaryTree<Integer>(63);
		BinaryTree<Integer> tree13b = new BinaryTree<Integer>(13);
		
		// next level up from leaves
		BinaryTree<Integer> tree2 = new BinaryTree<Integer>(2, tree42a, tree46);
		BinaryTree<Integer> tree42b = new BinaryTree<Integer>(42, tree65a, null);
		BinaryTree<Integer> tree13c = new BinaryTree<Integer>(13, tree63, tree13b);

		// next level up
		BinaryTree<Integer> tree13d = new BinaryTree<Integer>(13, tree2, tree13a);
		BinaryTree<Integer> tree65b = new BinaryTree<Integer>(65, tree42b, tree13c);
		
		// root
		BinaryTree<Integer> numberTree = new BinaryTree<Integer>(42, tree13d, tree65b);

		System.out.println(" 2 count is 1: " + numberTree.count(2));
		System.out.println("13 count is 4: " + numberTree.count(13));
		System.out.println("42 count is 3: " + numberTree.count(42));
		System.out.println("46 count is 1: " + numberTree.count(46));
		System.out.println("63 count is 1: " + numberTree.count(63));
		System.out.println("65 count is 2: " + numberTree.count(65));
		System.out.println("99 count is 0: " + numberTree.count(99));
		
		numberTree.clear();
		System.out.println("13 count is 0: " + numberTree.count(13)); // should not throw an exception

	}
}
