package preparations.linkedlist;
/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing 
together the nodes of the first two lists.
*/

public class MergeTwoSortedLinkedLists {
	

	private static Node mergeLists(Node n1, Node n2) {
		Node root = null;
		Node pre = null;
		
		if (n1 != null && (n2 == null || n1.value < n2.value)) {
				root=n1;
				pre=n1;
				n1 = n1.next;
		} else {
			root = n2;
			pre=n2;
			n2 = n2.next;
		}
		while(n1 !=null || n2 != null) {
			
			if (n1 == null) {
				pre.next=n2;
				pre = n2;
				n2 = n2.next;
			} else if (n2 == null) {
				pre.next = n1;
				pre = n1;
				n1 = n1.next;
			} else {
				if (n1.value < n2.value) {
					pre.next = n1;
					pre=n1;
					n1 = n1.next;
				} else {
					pre.next = n2;
					pre = n2;
					n2= n2.next;
				}
				
			}
			
		}
		
		return root;
	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2= new Node(2);
		Node n3= new Node(3);
		Node n4= new Node(4);
		Node n5= new Node(5);
		Node n6= new Node(6);
		Node n7= new Node(7);
		Node n8= new Node(8);
		Node n9= new Node(9);
		Node n10= new Node(10);
		Node n11= new Node(11);
		
		n1.next=n5;
		n5.next=n6;
		n6.next=n11;
		
		n2.next=n3;
		n3.next=n4;
		n4.next=n7;
		n7.next=n8;
		n8.next=n9;
		n9.next=n10;
		printList("Before List 1 : ", n1);
		printList("Before List 2 : ", n2);
		Node root = mergeLists(n1, n2);
		printList("After List  : ", root);
		
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
