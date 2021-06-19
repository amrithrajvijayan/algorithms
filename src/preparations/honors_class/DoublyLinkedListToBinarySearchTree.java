package preparations.honors_class;

// Time : O(nlog(n))   Space: log(n)
public class DoublyLinkedListToBinarySearchTree {

	
	private static Node findTail(Node head) {
		Node n = head;
		while(n.right != null)
			n = n.right;
		return n;
	}
	
	public static Node binaryTreeFromDoublyLinkedList(Node head) {
		Node tail = findTail(head);
		Node root = buildTree(head, tail, null, true);
		return root;
	}
	
	private static Node buildTree(Node start, Node end, Node parent, boolean isLeft) {
	
		//Base case.. if the start or end is null, attach to parent and return.
		if (start == null || end == null || start == end) {
			if (isLeft)
				parent.left = (start != null ? start : end);
			else 
				parent.right = (start != null ? start : end);
			
			return parent;
		}
		
		
		Node tempStart = start;
		Node tempEnd = end;
		
		Node newEnd = null;
		Node newStart = null;
		Node newParent = null;
		
		while(true) {
			
			if (tempStart.right == tempEnd) { // if the number of nodes is even, we will not have tempStart == tempEnd.. In that case, take tempStart as middle element
				newParent = tempStart;
				newEnd = tempStart.left;
				newStart = tempEnd;
				break;
			} else if (tempStart == tempEnd){ // if number of nodes is odd, we will get exact middle element.
				newParent = tempStart;
				newEnd = tempStart.left;
				newStart = tempEnd.right;
				break;
			}
			// advance end and start pointers
			tempStart = tempStart.right;
			tempEnd = tempEnd.left;
		}
		
		// Attach the current middle element ( newParent ) to previous parent.
		if (parent != null) { // non root node
			if (isLeft)
				parent.left = newParent;
			else 
				parent.right = newParent;
		} else { // for root node processing, parent will be null.
			parent = newParent;
		}
		// if newEnd is not null, detach newEnd from the rest of the list and call the same method recursively, but for sublist (start, newEnd)
		if (newEnd != null) {
			newEnd.right = null;
			buildTree(start, newEnd, newParent, true);
		}
		// if newStart is not null, detach newStart from the previous elements of the list and recursively call for sublist (newStart, end)
		if (newStart != null) {
			newStart.left = null;
			buildTree(newStart, end, newParent, false);
		}
		
		return parent; // this is used only for the root node..
	}
	
	
	
	public static void main(String[] args) {
		//construct the linked list
		Node head = constructLinkedList();
		//convert to binary tree.
		Node root = binaryTreeFromDoublyLinkedList(head);
		// verify if the tree is correct
		inOrder(root);
	}
	
	private static void inOrder(Node n) {
		if (n == null)
			return;
		inOrder(n.left);
		System.out.print(n.value + " ");
		inOrder(n.right);
	}
	
	
	private static Node constructLinkedList() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		
		n1.right = n2;
		n2.left = n1;n2.right=n3;
		n3.left = n2;n3.right=n4;
		n4.left = n3;n4.right=n5;
		n5.left = n4;n5.right=n6;
		n6.left = n5;n6.right=n7;
		n7.left = n6;n7.right=n8;
		n8.left = n7;n8.right=n9;
		n9.left = n8;
		
		return n1;
	}
	

}
