package preparations.linkedlist;

/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.

Note: Given n will always be valid. Try to do this in one pass.
*/


public class RemoveNthNodeFromEnd {
	
	
	private static void deleteNthFromEnd(Node n, int position) {
		int size = 0;
		Node node = n;
		while(node != null) {
			size++;
			node = node.next;
		}
		int toNavigateCount = size-position;
		node = n;
		Node pre=null;
		while(toNavigateCount>0) {
			pre = node;
			node = node.next;
			toNavigateCount--;
		}
		pre.next = node.next;
		return;
	}
	
	

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		
		printList("Before ", n1);
		deleteNthFromEnd(n1, 4);
		printList("After ", n1);
	}
	
	private static void printList(String prefix, Node node) {
		System.out.print("\n" + prefix);
		while(node != null){
			System.out.print(node.value+ " -> ");
			node = node.next;
		}
		return;
		
	}

}
