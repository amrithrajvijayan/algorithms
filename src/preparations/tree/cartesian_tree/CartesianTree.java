package preparations.tree.cartesian_tree;

// Cartesian Tree maintains the order during inorder traversal, at the same time, keeps the heap property
// Its not a balanced tree

public class CartesianTree {

	// Cartesian Tree Node
	static class Node {
		int data;
		Node left = null, right = null;

		Node(int data) {
			this.data = data;
		}
	}

	// Recursive function to perform inorder traversal on a Cartesian tree
	public static void inorderTraversal(Node root) {
		if (root == null) {
			return;
		}

		inorderTraversal(root.left);
		System.out.print(root.data + " ");
		inorderTraversal(root.right);
	}

	// Function to find the minimum element index in sequence represented by
	// `inorder[start, end]`
	public static int findMinElementIndex(int[] inorder, int start, int end) {
		int minIndex = start;
		for (int i = start + 1; i <= end; i++) {
			if (inorder[minIndex] > inorder[i]) {
				minIndex = i;
			}
		}

		return minIndex;
	}

	// Recursive function to construct a Cartesian tree from a given inorder
	// sequence
	public static Node constructTree(int[] inorder, int start, int end) {
		// base case
		if (start > end) {
			return null;
		}

		// Find the index of the minimum element in sequence `inorder[start, end]`
		int index = findMinElementIndex(inorder, start, end);

		// The minimum element in a given range of inorder sequence becomes the root
		Node root = new Node(inorder[index]);

		// recursively construct the left subtree
		root.left = constructTree(inorder, start, index - 1);

		// recursively construct the right subtree
		root.right = constructTree(inorder, index + 1, end);

		// return the current node
		return root;
	}

	public static void main(String[] args) {
		// input sequence of numbers representing the inorder sequence
		int[] inorder = { 9, 3, 7, 1, 8, 12, 10, 20, 15, 18, 5 };

		// construct the Cartesian tree
		Node root = constructTree(inorder, 0, inorder.length - 1);

		// print the Cartesian tree
		System.out.print("Inorder traversal of the constructed Cartesian tree is ");
		inorderTraversal(root);
	}

}
