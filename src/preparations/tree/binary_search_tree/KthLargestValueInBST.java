package preparations.tree.binary_search_tree;

public class KthLargestValueInBST {
	static class BST {
		public int value;
		public BST left = null;
		public BST right = null;

		public BST(int value) {
			this.value = value;
		}
	}

	static class TreeInfo {
		int count = 0;
		int value = 0;

		public TreeInfo(int c, int v) {
			this.count = c;
			this.value = v;
		}
	}

	private static void reverseBST(BST tree, int k, TreeInfo treeInfo) {

		if (tree == null || treeInfo.count == k)
			return;

		reverseBST(tree.right, k, treeInfo);

		if (treeInfo.count < k) {
			treeInfo.count++;
			if (treeInfo.count == k) {
				treeInfo.value = tree.value;
			}
			reverseBST(tree.left, k, treeInfo);
		}

	}

	public int findKthLargestValueInBst(BST tree, int k) {
		TreeInfo treeInfo = new TreeInfo(0, 0);
		reverseBST(tree, k, treeInfo);
		return treeInfo.value;
	}
}
