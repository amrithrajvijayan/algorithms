package preparations.tree.binary_search_tree;

/*

Write a function that takes in the root nodes of two Binary Trees and returns
a boolean representing whether their leaf traversals are the same.


The leaf traversal of a Binary Tree traverses only its leaf nodes from left to
right. A leaf node is any node that has no left or
right children.


For example, the leaf traversal of the following Binary Tree is
1, 3, 2.

*/

public class CompareLeafNodesOfTwoTrees {

	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	static class TreeData {
		public BinaryTree head;
		public BinaryTree previous;
	}

	public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {

		TreeData td1 = new TreeData();
		TreeData td2 = new TreeData();

		createLinkedList(tree1, td1);
		createLinkedList(tree2, td2);

		return compareLists(td1, td2);
	}

	private boolean compareLists(TreeData td1, TreeData td2) {
		BinaryTree t1 = td1.head;
		BinaryTree t2 = td2.head;

		while (t1 != null && t2 != null) {
			if (t1.value != t2.value)
				return false;
			t1 = t1.right;
			t2 = t2.right;
		}

		if (t1 != null || t2 != null)
			return false;

		return true;
	}

	private void createLinkedList(BinaryTree tree, TreeData td) {

		if (tree == null)
			return;

		if (tree.left == null && tree.right == null) {
			if (td.head == null) {
				td.head = tree;
				td.previous = tree;
			} else {
				td.previous.right = tree;
				td.previous = tree;
			}

		}
		createLinkedList(tree.left, td);
		createLinkedList(tree.right, td);
	}

	public static void main(String[] args) {
		

	}

}
