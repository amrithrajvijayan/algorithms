package misc;

public class LinkedListToBinarySearchTree {

	private static TreeNode rootNode = null;

	private static void convertToBinaryTreeOrderN(ListNode node, int length, TreeNode treeNode, String direction) {
		int[] valueArray = new int[length];
		for (int i = 0; i < length; i++) {
			valueArray[i] = node.getValue();
			node = node.getNext();
		}

		constructTree(valueArray, 0, valueArray.length - 1, "root", null);

	}

	private static void constructTree(int[] valueArray, int startPos, int endPos, String direction, TreeNode parent) {

		int midPosition = startPos + (endPos - startPos) / 2;

		TreeNode tn = new TreeNode(valueArray[midPosition]);

		if (direction.equals("root")) {
			rootNode = tn;
		} else {
			if (direction.equals("left")) {
				parent.setLeft(tn);
			} else {
				parent.setRight(tn);
			}
		}

		//if (startPos == midPosition || midPosition == endPos) {
		//	return;
		//}

		if (startPos != midPosition) {
			constructTree(valueArray, startPos, midPosition - 1, "left", tn);
		}
		if (endPos != midPosition) {
			constructTree(valueArray, midPosition + 1, endPos, "right", tn);
		}

	}

	public static void main(String[] args) {

		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(7);
		ListNode n3 = new ListNode(10);
		ListNode n4 = new ListNode(12);
		ListNode n5 = new ListNode(15);
		ListNode n6 = new ListNode(20);
		ListNode n7 = new ListNode(25);
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);

		// convertToBinaryTree(n1, 2, null, "");
		convertToBinaryTreeOrderN(n1, 7, null, "");
		System.out.println(rootNode);

	}

	private static void convertToBinaryTree(ListNode node, int length, TreeNode treeNode, String direction) {
		if (node == null)
			return;

		ListNode pre = null;
		ListNode startNode = node;

		for (int i = 1; i <= length / 2; i++) {
			pre = node;
			node = node.getNext();
		}

		if (rootNode == null) {
			rootNode = new TreeNode(node.value);
			treeNode = rootNode;
		} else {
			TreeNode midNode = new TreeNode(node.value);
			if (direction.equals("left")) {
				treeNode.setLeft(midNode);
			} else {
				treeNode.setRight(midNode);
			}
			treeNode = midNode;
		}

		if (node != null) {
			ListNode nextNode = node.getNext();
			if (pre != null) {
				pre.setNext(null);
				// treeNode.setLeft(new TreeNode(pre.getValue()));
				convertToBinaryTree(startNode, length / 2, treeNode, "left");
			}
			if (nextNode != null) {
				// treeNode.setRight(new TreeNode(nextNode.getValue()));
				convertToBinaryTree(nextNode, length / 2, treeNode, "right");
			}
		}

	}

}
