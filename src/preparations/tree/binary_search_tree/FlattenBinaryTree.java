package preparations.tree.binary_search_tree;

/*
  A flattened Binary Tree is a structure that's nearly identical to a Doubly
  Linked List (except that nodes have <span>left</span> and
  <span>right</span> pointers instead of <span>prev</span> and
  <span>next</span> pointers), where nodes follow the original tree's
  left-to-right order.
*/

public class FlattenBinaryTree {

	public static BinaryTree flattenBinaryTree(BinaryTree root) {
		// Write your code here.
		processNode(root);
		BinaryTree start = root;
		while (start.left != null) {
			start = start.left;
		}
		return start;
	}

	private static void processNode(BinaryTree node) {
		if (node == null) {
			return;
		}
		BinaryTree leftChild = (node.left != null ? node.left : null);
		BinaryTree rightChild = (node.right != null ? node.right : null);

		BinaryTree listLeft = findRightMostChild(leftChild);
		BinaryTree listRight = findLeftMostChild(rightChild);

		if (leftChild != null) {
			processNode(leftChild);
		}
		if (rightChild != null) {
			processNode(rightChild);
		}

		if (listLeft != null)
			listLeft.right = node;
		node.left = listLeft;
		node.right = listRight;
		if (listRight != null)
			listRight.left = node;

		return;
	}

	private static BinaryTree findRightMostChild(BinaryTree node) {
		BinaryTree parentNode = node;
		while (node != null) {
			parentNode = node;
			node = node.right;
		}
		return parentNode;
	}

	private static BinaryTree findLeftMostChild(BinaryTree node) {
		BinaryTree parentNode = node;
		while (node != null) {
			parentNode = node;
			node = node.left;
		}
		return parentNode;
	}

	// This is the class of the input root. Do not edit it.
	static class BinaryTree {
		int value;
		BinaryTree left = null;
		BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}
}
