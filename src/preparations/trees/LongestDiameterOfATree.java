package preparations.trees;

import java.util.*;

public class LongestDiameterOfATree {

	private static class Node {
		public Node right;
		public Node left;
		public int value;

		public Node(int val) {
			this.value = val;
		}
	}
	
	/*
	
	        10
	        /  \
	       2     15
	      / \      \
	     7  13     5
	    /       \
	 20         18
	                \
	               19
	*/
	private static Node constructTree() {
		Node root = new Node(10);
		Node n5 = new Node(5);
		Node n2 = new Node(2);
		Node n7 = new Node(7);
		Node n15 = new Node(15);
		Node n13 = new Node(13);
		Node n18 = new Node(18);
		Node n19 = new Node(19);
		Node n20 = new Node(20);

		root.left = n2;
		root.right = n15;
		n2.left = n7;
		n2.right = n13;
		n7.left = n20;
		n13.right = n18;
		n18.right = n19;
		// n20.right=n5;
		n15.right = n5;

		return root;
	}

	static class TreeInfo {
		int longestLength;
		int depth;
		List<Integer> longestPath;
		List<Integer> branchPath;

		public TreeInfo(int l, int d) {
			this.longestLength = l;
			this.depth = d;
			this.longestPath = new ArrayList<Integer>();
			this.branchPath = new ArrayList<Integer>();
		}
	}

	private static TreeInfo longestDiameter(Node node) {

		if (node == null)
			return new TreeInfo(0, 0);

		TreeInfo leftInfo = longestDiameter(node.left);
		TreeInfo rightInfo = longestDiameter(node.right);

		int longestChildPath = Math.max(leftInfo.longestLength, rightInfo.longestLength);

		int longestAsRoot = leftInfo.depth + rightInfo.depth + 1;

		int maxDepth = Math.max(leftInfo.depth, rightInfo.depth);

		if (longestAsRoot > longestChildPath) {
			TreeInfo ti = new TreeInfo(longestAsRoot, maxDepth + 1);

			// Update longest path - create longest path by using current node as root
			ti.longestPath.addAll(leftInfo.branchPath);
			ti.longestPath.add(node.value);
			ti.longestPath.addAll(rightInfo.branchPath); // ideally, this list should be reversed

			// Update branch path to include longest branch going through current node. this
			// will be required if
			// there is a new longest path found later
			if (longestChildPath == leftInfo.longestLength) {
				ti.branchPath.addAll(leftInfo.branchPath);
			} else {
				ti.branchPath.addAll(rightInfo.branchPath);
			}
			// add current node to branch path
			ti.branchPath.add(node.value);

			return ti;
		} else {

			TreeInfo t = new TreeInfo(longestChildPath, maxDepth + 1);
			// update longest path and branch path.
			if (longestChildPath == leftInfo.longestLength) {
				t.longestPath.addAll(leftInfo.longestPath);
				t.branchPath.addAll(leftInfo.branchPath);
			} else {
				t.longestPath.addAll(rightInfo.longestPath);
				t.branchPath.addAll(rightInfo.branchPath);
			}
			// add current node to branch path
			t.branchPath.add(node.value);

			return t;
		}
	}

	public static void main(String[] args) {
		Node root = constructTree();

		TreeInfo t = longestDiameter(root);
		System.out.println("Longest Diameter = " + t.longestLength);
		System.out.println("Path is " + t.longestPath);
	}

}
