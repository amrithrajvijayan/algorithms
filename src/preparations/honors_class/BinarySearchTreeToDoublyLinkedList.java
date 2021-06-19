package preparations.honors_class;

public class BinarySearchTreeToDoublyLinkedList {

	public static Node convertTreeToLinkedList(Node root) {
		build(root, root, root, true, true);
		Node head = root;
		while (head.left != null)
			head = head.left;
		return head;
	}

	private static Node getRightLeftMost(Node n) {

		Node node = n;
		node = node.right;
		while (node.left != null)
			node = node.left;
		return node;
	}

	private static void build(Node n, Node parent, Node root, boolean isFromLeft, boolean isRightMostPath) {

		if (n == null)
			return;

		Node left = n.left;
		Node right = n.right;

		// Handle three cases separately..
		// 1: Root node
		// 2: Non root path through left navigation
		// 3: Non root path through right navigation
		if (n == root) { // In case of root, handle left/right children and then attach current right
							// node to right-leftmost node
			Node rightLeftMost = getRightLeftMost(n);
			build(left, n, root, true, false);
			build(right, n, root, false, true);
			n.right = rightLeftMost;
			rightLeftMost.left = n;
		} else if (isFromLeft) { // if this is non-root left path, any left navigation will have current node (n)
									// as parent..any right navigation will have parent as its parent
			if (right == null) {
				build(n.left, n, root, true, false);
				n.right = parent; // if there is no right child, current nodes right should point to parent
									// object..
				parent.left = n;
			} else { // if there is a right child, current nodes left navigation will have current
						// node ( n) as parent,.. right navigations will have 'parent' as parent.
				Node rightLeftMost = getRightLeftMost(n);
				build(left, n, root, true, false);
				build(right, parent, root, false, false);
				n.right = rightLeftMost;
				rightLeftMost.left = n;
			}
		} else { // right navigation path
			if (right == null) {
				build(left, n, root, true, false);
			} else {
				Node rightLeftMost = getRightLeftMost(n);
				build(left, n, root, true, false);
				build(right, parent, root, false, isRightMostPath);
				n.right = rightLeftMost;
				rightLeftMost.left = n;
			}
			if (parent != root || parent == root && !isRightMostPath) { // except for the right most element in the
																		// tree, the right attribute should point to
																		// parent.. but dont do this for right most
																		// element as it will point back to root and
																		// hence will create cycle
				n.right = parent;
				parent.left = n;
			}
		}

	}

	public static void main(String[] args) {
		// construct the tree
		Node root = constructBinaryTree();
		// convert to doubly linked list
		Node head = convertTreeToLinkedList(root);
		// verify if the list is correct
		printLinkedList(head);
	}

	private static void printLinkedList(Node head) {

		System.out.println("Forward");
		Node n = head;
		Node tail = null;
		while (n != null) {
			System.out.print(n.value + " ");
			tail = n;
			n = n.right;
		}
		System.out.println("\n\nBackward");
		n = tail;
		while (n != null) {
			System.out.print(n.value + " ");
			n = n.left;
		}
	}

	private static Node constructBinaryTree() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);

		n5.left = n3;
		n5.right = n8;
		n3.left = n1;
		n3.right = n4;
		n1.right = n2;
		n8.left = n7;
		n8.right = n9;
		n7.left = n6;

		return n5;
	}

}
