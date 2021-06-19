package preparations.tree.binary_search_tree;

import java.util.*;

public class BranchSumsOfAllPathsFromRootInBinaryTree {
	public static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		BinaryTree(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	private static void findBranchSums(BinaryTree node, List<Integer> retList, int sumTillNow) {

		if (node == null) {
			retList.add(sumTillNow);
			return;
		}
		if (node.left == null && node.right == null) {
			retList.add(sumTillNow + node.value);
			return;
		}
		if (node.left != null)
			findBranchSums(node.left, retList, sumTillNow + node.value);
		if (node.right != null)
			findBranchSums(node.right, retList, sumTillNow + node.value);
	}

	public static List<Integer> branchSums(BinaryTree root) {
		List<Integer> retList = new ArrayList<>();

		findBranchSums(root, retList, 0);

		return retList;
	}
}
