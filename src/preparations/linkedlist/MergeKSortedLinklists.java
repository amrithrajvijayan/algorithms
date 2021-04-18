package preparations.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

public class MergeKSortedLinklists {

	public static Node mergeLists(List<Node> list) {
		Node root = null;
		Node pre = null;
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				return (n1.value - n2.value);
			}
		});
		
		for (Node n : list) {
			pq.add(n);
		}

		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if (pre == null) {
				pre = n;
				root = n;
			} else {
				pre.next = n;
				pre = n;
			}
			if (n.next != null) 
				pq.add(n.next);
		}
		
		
		return root;
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
		Node n10 = new Node(10);
		Node n11 = new Node(11);

		n1.next = n5;
		n5.next = n6;
		n6.next = n11;

		n2.next = n3;
		n3.next = n4;
		n4.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		printList("Before List 1 : ", n1);
		printList("Before List 2 : ", n2);
		List<Node> list = new ArrayList<Node>();
		list.add(n1);
		list.add(n2);
		Node root = mergeListsNew(list);
		printList("Merged List  : ", root);
	}
	
	private static Node mergeListsNew(List<Node> list) {
		Node retNode = null;
		Node pre = null;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
					public int compare(Node n1, Node n2) {
						return (n1.value - n2.value);
					}
			});
			
		
		for (Node node  : list) {
			pq.add(node);
		}
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if (retNode == null) { 
				retNode = n;
				pre = n;
			}
			else {
				pre.next = n;
				pre = n;
			}
			if (n.next != null) {
				pq.add(n.next);
			}
		}
		
		
		
		
		return retNode;
	}
	
	
	

	private static void printList(String prefix, Node node) {
		System.out.print("\n" + prefix);
		while (node != null) {
			System.out.print(node.value + " -> ");
			node = node.next;
		}
		return;

	}

}
