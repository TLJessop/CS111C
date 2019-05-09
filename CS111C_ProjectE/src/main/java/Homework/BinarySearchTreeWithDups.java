package Homework;

import java.util.*;

public class BinarySearchTreeWithDups<T extends Comparable<? super T>> extends BinarySearchTree<T>
		implements SearchTreeInterface<T>, java.io.Serializable {

	public BinarySearchTreeWithDups() {
		super();
	}

	public BinarySearchTreeWithDups(T rootEntry) {
		super(rootEntry);
		setRootNode(new BinaryNode<T>(rootEntry));
	}

	@Override
	public T add(T newEntry) {
		T result = newEntry;
		if (isEmpty()) {
			setRootNode(new BinaryNode<T>(newEntry));
		} else {
			addEntryHelperNonRecursive(newEntry);
		}
		return result;
	}

	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	private void addEntryHelperNonRecursive(T newEntry) {
		BinaryNode<T> currentNode = super.getRootNode();


		while (currentNode != null){
			if (currentNode.getData().compareTo(newEntry) >= 0){
				if (currentNode.hasLeftChild()){
					currentNode = currentNode.getLeftChild();
				} else {
					currentNode.setLeftChild(new BinaryNode<>(newEntry));
					currentNode = null;
				}
			} else {
				if (currentNode.hasRightChild()){
					currentNode = currentNode.getRightChild();
				} else {
					currentNode.setRightChild(new BinaryNode<>(newEntry));
					currentNode = null;
				}

			}
		}

	}


	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countEntriesNonRecursive(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNode<T> currentNode = getRootNode();

		while (currentNode != null){
			if (currentNode.getData().equals(target)){
				count++;
			}

			if(currentNode.hasLeftChild() && currentNode.getData().compareTo(target) >= 0){
				currentNode = currentNode.getLeftChild();
			} else if (currentNode.hasRightChild() && currentNode.getData().compareTo(target) < 0){
				currentNode = currentNode.getRightChild();
			} else {
				currentNode = null;
			}
		}
		
		return count;
	}

	// YOUR CODE HERE! MUST BE RECURSIVE! YOU ARE ALLOWED TO CREATE A PRIVATE HELPER.
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countGreaterRecursive(T target) {
		return countGreaterHelper(target,getRootNode());
	}

	private int countGreaterHelper(T target, BinaryNode<T> node){
		int result = 0;
		if (node.hasRightChild()){
			result += countGreaterHelper( target,node.getRightChild());
		}

		if (node.getData().compareTo(target) > 0){
			if (node.hasLeftChild()){
				result += countGreaterHelper(target, node.getLeftChild());
			}
			result++;
		}
		return result;
	}

	// YOUR CODE HERE! MUST USE A STACK!! MUST NOT BE RECURSIVE! 
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countGreaterWithStack(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNode<T> rootNode = getRootNode();
		Stack<BinaryNode<T>> nodeStack = new Stack<BinaryNode<T>>();
		nodeStack.push(rootNode);
		while (!nodeStack.isEmpty()){
			BinaryNode<T> currentNode = nodeStack.pop();

			if (currentNode.getData().compareTo(target) < 0 &&
					currentNode.hasRightChild()) {
				nodeStack.push(currentNode.getRightChild());
			} else {
					if (currentNode.hasRightChild()){
						nodeStack.push(currentNode.getRightChild());
					}
					if (currentNode.hasLeftChild()){
						nodeStack.push(currentNode.getLeftChild());
					}
					if (currentNode.getData().compareTo(target) > 0) {
						count++;
					}
				}
		}
		return count;
	}
		
	// YOUR EXTRA CREDIT CODE HERE! THIS METHOD MUST BE O(n). 
	// YOU ARE ALLOWED TO USE A HELPER METHOD. THE METHOD CAN BE ITERATIVE OR RECURSIVE. 
	public int countUniqueValues() {
	    Set<T> foundValues = new HashSet<>();
        ArrayDeque<BinaryNode<T>> nodeDeque = new ArrayDeque<>();

        nodeDeque.push(getRootNode());
        while (!nodeDeque.isEmpty()){
            BinaryNode<T> currentNode = nodeDeque.pop();
            if (currentNode.hasRightChild()){
                nodeDeque.push(currentNode.getRightChild());
            }
            if (currentNode.hasLeftChild()){
                nodeDeque.push(currentNode.getLeftChild());
            }
            foundValues.add(currentNode.getData());
        }

		return foundValues.size();
	}

	
	
	
	public int getLeftHeight() {
		BinaryNode<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasLeftChild()) {
			return 0;
		} else {
			return rootNode.getLeftChild().getHeight();
		}
	}

	public int getRightHeight() {
		BinaryNode<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasRightChild()) {
			return 0;
		} else {
			return rootNode.getRightChild().getHeight();
		}
	}


}