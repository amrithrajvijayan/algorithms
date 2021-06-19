package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class Node {
	int data;
	Node left;
	Node right;
	int leftCount=0;
		public Node(int data) {
			this.data = data;
		}
}


public class MinRightCount {

	
	  public static List<Integer> rightSmallerThan(List<Integer> array) {

			Node node = new Node(array.get(array.size() -1));
			Node root = node;
			
			List<Integer> resultsArray = new ArrayList<>(array.size());
			for (int i=0; i<array.size(); i++) {
				resultsArray.add(0);
			}
			

			
			for (int i=array.size()-2; i>=0; i--) {
				Node newNode = new Node(array.get(i));
				Node passingNode = root;
				boolean inserted = false;
				while(!inserted) {
					if (passingNode.data >= newNode.data) {
						passingNode.leftCount++;
						if (passingNode.left !=null) {
							passingNode = passingNode.left;
						} else {
							passingNode.left = newNode;
							inserted = true;
						}
					} else {
						//newNode.count++;
						System.out.println("array list " + i + " is " + resultsArray.get(i));
							resultsArray.set(i, resultsArray.get(i)+passingNode.leftCount + 1);
						if (passingNode.right != null) {
							passingNode = passingNode.right;
						} else {
							passingNode.right = newNode;
							inserted = true;
						}
					}
				}
			}
			
			//for (int i : resultsArray) {
			//	System.out.print(i + " ");
			//}
			
		
			
	    // Write your code here.
	    return resultsArray;
	  }	
	
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(8);
		list.add(5);
		list.add(11);
		list.add(-1);
		list.add(3);
		list.add(4);
		list.add(2);
		
		System.out.println(new MinRightCount().rightSmallerThan(list));
//		[5, 4, 4, 0, 1, 1, 0]
	}

}
