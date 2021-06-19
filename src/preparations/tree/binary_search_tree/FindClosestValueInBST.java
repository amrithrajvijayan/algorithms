package preparations.tree.binary_search_tree;

/*

  Write a function that takes in a Binary Search Tree (BST) and a target integer
  value and returns the closest value to that target value contained in the BST.

  You can assume that there will only be one closest value.
  
  Each BST node has an integer value, a left child node, and a right child node. A node is
  said to be a valid BST node if and only if it satisfies the BST property: its value is strictly greater than the values of every
  node to its left; its value is less than or equal to the values of every node to its right; and its children nodes are either valid
  BST nodes themselves or None / null.

  */

public class FindClosestValueInBST {

	private static void findClosest(BST tree, int target, int[] retValue) {

		if (tree == null)
			return;

		if (retValue[0] == Integer.MAX_VALUE)
			retValue[0] = tree.value;
		else {
			if (Math.abs(tree.value - target) < Math.abs(retValue[0] - target))
				retValue[0] = tree.value;
		}
		if (target <= tree.value)
			findClosest(tree.left, target, retValue);

		if (target > tree.value)
			findClosest(tree.right, target, retValue);

	}

	public static int findClosestValueInBst(BST tree, int target) {
		int[] retValue = new int[] { Integer.MAX_VALUE };
		findClosest(tree, target, retValue);
		if (retValue[0] == Integer.MAX_VALUE)
			return -1;
		return retValue[0];
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}
	}
}
