package preparations.tree.binary_search_tree;

public class CheckIfHeightBalancedTree {
	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	static class TreeInfo {
		boolean isBalanced;
		int height;

		public TreeInfo(boolean a, int b) {
			this.isBalanced = a;
			this.height = b;
		}
	}

	private static TreeInfo isBalanced(BinaryTree tree) {

		if (tree == null)
			return new TreeInfo(true, -1);

		TreeInfo isLeftBalanced = isBalanced(tree.left);
		TreeInfo isRightBalanced = isBalanced(tree.right);

		boolean isBalanced = isLeftBalanced.isBalanced && isRightBalanced.isBalanced
				&& (Math.abs(isLeftBalanced.height - isRightBalanced.height) <= 1);

		int height = Math.max(isLeftBalanced.height, isRightBalanced.height) + 1;

		return new TreeInfo(isBalanced, height);
	}

	public boolean heightBalancedBinaryTree(BinaryTree tree) {
		TreeInfo treeInfo = isBalanced(tree);
		return treeInfo.isBalanced;
	}
}
