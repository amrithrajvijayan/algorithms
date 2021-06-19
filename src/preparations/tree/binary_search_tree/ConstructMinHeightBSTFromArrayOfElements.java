package preparations.tree.binary_search_tree;

import java.util.*;

public class ConstructMinHeightBSTFromArrayOfElements {
	public static BST minHeightBst(List<Integer> array) {
		return constructBinaryTree(array, null, 0, array.size() - 1);
	}

	private static BST constructBinaryTree(List<Integer> array, BST bst, int startIndex, int endIndex) {
		if (endIndex < startIndex)
			return null;
		int midIndex = (startIndex + endIndex) / 2;
		int valueToAdd = array.get(midIndex);
		if (bst == null) {
			bst = new BST(valueToAdd);
		} else {
			bst.insert(valueToAdd);
		}
		constructBinaryTree(array, bst, startIndex, midIndex - 1);
		constructBinaryTree(array, bst, midIndex + 1, endIndex);
		return bst;
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
			left = null;
			right = null;
		}

		public void insert(int value) {
			if (value < this.value) {
				if (left == null) {
					left = new BST(value);
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					right = new BST(value);
				} else {
					right.insert(value);
				}
			}
		}
	}
}
