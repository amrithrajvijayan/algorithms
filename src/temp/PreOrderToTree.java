package temp;

import java.util.ArrayList;
import java.util.Arrays;

import preparations.tree.binary_search_tree.BSTConstructionFromPreOrderTraversal.BST;
import preparations.tree.binary_search_tree.BSTConstructionFromPreOrderTraversal.TreeInfo;

public class PreOrderToTree {

	
	
	
	private static BST constructBST(int[] arr) {
		TreeInfo treeInfo = new TreeInfo(0);
		return constructBSTIteratively(Integer.MIN_VALUE, Integer.MAX_VALUE, treeInfo, arr);
	}
	
	private static BST constructBSTIteratively(int minValue, int maxValue, TreeInfo treeInfo, int[] arr) {
		
		if (treeInfo.rootIdx == arr.length)
			return null;
		
		int val = arr[treeInfo.rootIdx];
		
		if (val < minValue || val >= maxValue)
			return null;
		
		treeInfo.rootIdx++;
		
		BST left = constructBSTIteratively(minValue, val, treeInfo, arr);
		BST right =  constructBSTIteratively(val, maxValue, treeInfo, arr);
		
		BST node = new BST(val);
		node.left = left;
		node.right = right;
		
		return node;
	}

	public static void main(String[] args) {

		int[] arr = { 5, 3, 2, 1, 4, 8, 6, 7, 9, 10 };
		BST root = constructBST(arr);
		printInorder(root);
	}

	private static void printInorder(BST node) {

		if (node == null)
			return;

		printInorder(node.left);
		System.out.print(node.value + " ");
		printInorder(node.right);
	}

}
