package preparations.tree.binary_search_tree;

public class SumOfNodeDepthsForBinaryTree {
	private static int calculateDepth(BinaryTree node, int depth) {

		if (node == null) {
			return 0;
		}

		int leftDepth = calculateDepth(node.left, depth + 1);
		int rightDepth = calculateDepth(node.right, depth + 1);

		return leftDepth + rightDepth + depth;
	}

	public static int nodeDepths(BinaryTree root) {
		return calculateDepth(root, 0);
	}

	static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}
}
