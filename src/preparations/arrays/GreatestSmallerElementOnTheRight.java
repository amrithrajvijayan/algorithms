package preparations.arrays;

import java.util.*;

public class GreatestSmallerElementOnTheRight {
	static class Node {
		int data;
		Node left;
		Node right;
		int leftCount = 0;

		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(0, 2, 9, 4, 10, 8, 3));
		System.out.println(rightSmallerThan(list));
	}
	
	

	public static List<Integer> rightSmallerThan(List<Integer> array) {
		if (array == null || array.size() == 0) {
			return new ArrayList<Integer>();
		}
		Node node = new Node(array.get(array.size() - 1));
		Node root = node;
		List<Integer> resultsArray = new ArrayList<>(array.size());
		for (int i = 0; i < array.size(); i++) {
			resultsArray.add(0);
		}

		Collections.fill(resultsArray, new Integer(0));
		for (int i = array.size() - 2; i >= 0; i--) {

			Node newNode = new Node(array.get(i));
			Node passingNode = root;
			boolean inserted = false;
			while (!inserted) {
				if (passingNode.data >= newNode.data) {
					passingNode.leftCount++;
					if (passingNode.left != null) {
						passingNode = passingNode.left;
					} else {
						passingNode.left = newNode;
						inserted = true;
					}
				} else {
					// newNode.count++;
					// System.out.println("array list " + i + " is " + resultsArray.get(i));
					resultsArray.set(i, resultsArray.get(i) + passingNode.leftCount + 1);
					if (passingNode.right != null) {
						passingNode = passingNode.right;
					} else {
						passingNode.right = newNode;
						inserted = true;
					}
				}
			}
		}

		return resultsArray;
	}
}
