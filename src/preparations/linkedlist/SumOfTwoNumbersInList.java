package preparations.linkedlist;

class Node {
	int value;
	Node next;
	public Node(int v) {
		this.value = v;
	}
}

public class SumOfTwoNumbersInList {

	
	private static int findSum(Node n1, Node n2, Node targetNode, int count1, int count2) {
		
		if (n1 ==null && n2 == null || (count1 <0 && count2 <0)) 
			return 0;
		
		int v1 = 0;
		Node nextN1 = n1;
		Node nextN2 = n2;
		int newCount1 = count1;
		int newCount2 = count2;
		if (n1 != null && count1 >=count2) {
			v1 = n1.value;
			nextN1 = n1.next;
			newCount1--;
		}
		int v2 = 0;
		if (n2 != null && count2 >=count1) {
			v2 = n2.value;
			nextN2 = n2.next;
			newCount2--;
		}
		
		Node newNode = new Node(0);
		targetNode.next = newNode;
		
		int sum = v1 + v2 + findSum(nextN1, nextN2, newNode, newCount1, newCount2);
		int reminder = 0;
		if (sum > 9) {
			sum = sum %10;
			reminder = 1;
		}
		newNode.value = sum;
		return reminder;
	}
	
	
	
	private static Node calculateNodesSum(Node n1, Node n2) {
		// Find number of nodes.
		int count1 = 0;
		int count2 = 0;
		Node t1 = n1; Node t2 = n2;
		while(t1 != null || t2 != null) {
			if (t1 != null) {
				t1 = t1.next;
				count1++;
			}
			if (t2 != null) {
				t2 = t2.next;
				count2++;
			}
		}
		
		//Create empty node for storing carry forward value.
		Node newRoot = new Node(Integer.MIN_VALUE);
		int reminder = findSum(n1, n2, newRoot, count1, count2);
		// If carry forward is 0, discard root node
		if (reminder != 0) {
			newRoot.value = reminder;
		} else {
			newRoot = newRoot.next;
		}
		return newRoot;
	}
	
	
	
	public static void main(String[] args) {

		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		n2.next = n3;
		n3.next = n4;
		
		Node p5 = new Node(9);
		Node p1 = new Node(9);
		Node p2 = new Node(9);
		p5.next = p1;
		p1.next = p2;
		
		// Node currNode = calculateNodesSum(n2, p5);
		
		Node currNode = calculateNodesSumRepeat(n2, p5);
				
		while(currNode != null) {
			System.out.print(currNode.value);
			currNode = currNode.next;
		}
		
	}
	
	///   repeat ////////
	
	private static Node calculateNodesSumRepeat(Node n1, Node n2) {
		if (n1 == null)
			return n2;
		if (n2== null)
			return n1;
		
		Node firstNode = new Node(Integer.MIN_VALUE);
		
		int n1Length = 0;
		int n2Length = 0;
		Node tempN1 = n1;
		Node tempN2 = n2;
		while(tempN1 != null || tempN2 != null) {
			if (tempN1 != null) {
				n1Length++;
				tempN1 = tempN1.next;
			}
			if (tempN2 != null) {
				n2Length++;
				tempN2 = tempN2.next;
			}
		}
		
		int reminder = addNodesRepeat(n1, n2, firstNode, n1Length, n2Length);
		if (reminder > 0) {
			firstNode.value = reminder;
		} else firstNode = firstNode.next;
		
		return firstNode;
	}
	
	private static int addNodesRepeat(Node n1, Node n2, Node pre, int n1Length, int n2Length) {
		
		if (n1==null && n2==null || n1Length ==0 && n2Length == 0)
			return 0;
		
		int reminder = 0;
		Node currentNode = new Node(0);
		int val1=0;
		int val2=0;
		int preReminder= 0;
		
		if (n1Length == n2Length) {
			preReminder = addNodesRepeat(n1.next, n2.next, currentNode, n1Length-1, n2Length-1);
			val1 = n1.value;
			val2 = n2.value;
		} else if (n1Length > n2Length) {
		    preReminder = addNodesRepeat(n1.next, n2, currentNode, n1Length-1, n2Length);
		    val1 = n1.value;
		} else if (n2Length > n1Length) {
			preReminder = addNodesRepeat(n1, n2.next, currentNode, n1Length, n2Length-1);
			val2 = n2.value;
		}

		int sum = val1+val2 + preReminder;
		
		if(sum > 10) {
			sum = sum - 10;
			reminder = 1;
		}
		currentNode.value = sum;
		
		pre.next = currentNode;
		
		return reminder;
	}

}
