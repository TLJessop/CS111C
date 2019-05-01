package HomeWork;

import java.util.Objects;

public class VoterHashTableSeparateChaining {

	private Node<Voter>[] hashTable;
	private int tableSize;

	public VoterHashTableSeparateChaining(int size) {
		hashTable = (Node<Voter>[]) new Node[size];
		tableSize = size;
	}
	
	public int getHashLocation(int voterID) {
		return voterID % tableSize;
	}


	// implementing extra credit.
	public boolean addVoter(Voter voterToAdd) {

		boolean added = true;
		int hashLocation = getHashLocation(voterToAdd.getId());
		Node<Voter> voterNode = new Node<>(voterToAdd, null);

		if (hashTable[hashLocation] != null){
			Node<Voter> curentNode = hashTable[hashLocation];
			while (curentNode != null){
				if (curentNode.data.getId()== voterToAdd.getId() &&
					curentNode.data.getName().equals(voterToAdd.getName())){
					added = false;
				}
				curentNode = curentNode.next;
			}
			voterNode.setNextNode(hashTable[hashLocation]);
		}
		if (added){
			hashTable[hashLocation] = voterNode;
		}
		return added;
	}

	public Voter getVoter(int voterID) {
		int count = 0;
		int hashLocation = getHashLocation(voterID);

		while (hashTable[hashLocation] != null && count <= tableSize){

			Node<Voter> curentNode = hashTable[hashLocation];
			while (curentNode != null) {
				if (curentNode.data.getId() == voterID) {
					return curentNode.data;
				}
				curentNode = curentNode.next;
			}

			hashLocation ++;
			count++;
			hashLocation = hashLocation % tableSize;
		}
		return null;
	}

	public void printTable() {
		for (int i = 0; i < tableSize; i++) {
			if (hashTable[i] != null) {
				System.out.print(i + ": ");
				Node<Voter> current = hashTable[i];
				while (current != null && current.next != null) {
					System.out.print(current.data.getName() + " -> ");
					current = current.next;
				}
				System.out.println(current.data.getName());
			}
		}
	}

}
