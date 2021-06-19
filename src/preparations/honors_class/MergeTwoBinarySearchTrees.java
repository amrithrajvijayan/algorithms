package preparations.honors_class;
import preparations.honors_class.BinarySearchTreeToDoublyLinkedList;

public class MergeTwoBinarySearchTrees {

	
	private static Node mergeTrees(Node root1, Node root2) {

		// convert both the binary trees to doubly linked lists. Space: O(log(n))
		Node head1 = BinarySearchTreeToDoublyLinkedList.convertTreeToLinkedList(root1);
		Node head2 = BinarySearchTreeToDoublyLinkedList.convertTreeToLinkedList(root2);

		// Merge both linked lists to one.
		Node newHead = mergeSortedLinkedLists(head1, head2);

		// Create tree from merged linked list
		Node newRoot = DoublyLinkedListToBinarySearchTree.binaryTreeFromDoublyLinkedList(newHead);

		return newRoot;
	}

	private static Node mergeSortedLinkedLists(Node head1, Node head2) {

		Node n1 = head1;
		Node n2 = head2;
		Node newHead = null;
		if (n1.value < n2.value) {
			newHead = n1;
		} else
			newHead = n2;
		Node pre = null;
		while (n1 != null && n2 != null) {
			if (n1.value < n2.value) {
				if (pre != null) {
					pre.right = n1;
				}
				n1.left = pre;
				pre = n1;
				n1 = n1.right;
			} else {
				if (pre != null) {
					pre.right = n2;
				}
				n2.left = pre;
				pre = n2;
				n2 = n2.right;
			}
		}

		if (n1 != null) {
			while (n1 != null) {
				pre.right = n1;
				n1.left = pre;
				pre = n1;
				n1 = n1.right;
			}
		}
		if (n2 != null) {
			while (n2 != null) {
				pre.right = n2;
				n2.left = pre;
				pre = n2;
				n2 = n2.right;
			}
		}

		return newHead;
	}

	public static void main(String[] args) {

		Node root1 = constructBinaryTree1();
		Node root2 = constructBinaryTree2();
		Node root = mergeTrees(root1, root2);

		inOrder(root);
	}

	private static void inOrder(Node n) {
		if (n == null)
			return;
		inOrder(n.left);
		System.out.print(n.value + " ");
		inOrder(n.right);
	}
	
	/*
			5
		   /  \ 
	      3    8
	     /     /
	    1     6
	    
	*/
	private static Node constructBinaryTree1() {
		Node n1 = new Node(1);
		Node n3 = new Node(3);
		
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n8 = new Node(8);
		
		n5.left= n3;n5.right=n8;
		n3.left=n1;
		n8.left=n6;
		
		return n5;
	}
	

	/*
			7
		   /  \ 
	      2    9     
	    
	*/
	private static Node constructBinaryTree2() {
		Node n7 = new Node(7);
		Node n2 = new Node(2);
		Node n9 = new Node(9);
		
		n7.left= n2;n7.right=n9;
		
		return n7;
	}	
	

}
