package preparations.tree.binary_search_tree;

import java.util.*;

public class BSTConstructionFromPreOrderTraversal {
	
	public static void main(String[] args) {
		
		Integer[] arr = {5, 3, 2, 1, 4, 8, 6, 7, 9, 10};
		
		ArrayList<Integer> preOrderValue= new ArrayList<>(Arrays.asList(arr));
		BSTConstructionFromPreOrderTraversal bstPre = new BSTConstructionFromPreOrderTraversal();
		BST root = bstPre.reconstructBst(preOrderValue);
		printInorder(root);
	}
	
	private static void printInorder(BST node) {
		
		if (node == null)
			return;
		
		printInorder(node.left);
		System.out.print(node.value +  " ");
		printInorder(node.right);
	}
	
	
	
	public static class BST {
		public int value;
		public BST left = null;
		public BST right = null;

		public BST(int value) {
			this.value = value;
		}
	}

	public static class TreeInfo {
		public int rootIdx;

		public TreeInfo(int rootIdx) {
			this.rootIdx = rootIdx;
		}
	}

	public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
		TreeInfo treeInfo = new TreeInfo(0);
		return reconstructBstFromRange(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues, treeInfo);
	}

	public BST reconstructBstFromRange(int lowerBound, int upperBound, List<Integer> preOrderTraversalValues,
			TreeInfo currentSubtreeInfo) {

		if (currentSubtreeInfo.rootIdx == preOrderTraversalValues.size()) {
			return null;
		}

		int rootValue = preOrderTraversalValues.get(currentSubtreeInfo.rootIdx);

		if (rootValue < lowerBound || rootValue >= upperBound) {
			return null;
		}

		currentSubtreeInfo.rootIdx++;
		BST leftSubtree = reconstructBstFromRange(lowerBound, rootValue, preOrderTraversalValues, currentSubtreeInfo);

		BST rightSubtree = reconstructBstFromRange(rootValue, upperBound, preOrderTraversalValues, currentSubtreeInfo);

		BST bst = new BST(rootValue);
		bst.left = leftSubtree;
		bst.right = rightSubtree;

		return bst;
	}

}
