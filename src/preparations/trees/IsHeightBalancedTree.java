package preparations.trees;

public class IsHeightBalancedTree {

	private static class Node {
		public Node right;
		public Node left;
		public int value;
		
		public Node(int val) {
			this.value = val;
		}
	}
	
	public static class TreeInfo {
		int height;
		boolean isBalanced;
		public TreeInfo(int h, boolean isB) {
			this.height = h;
			this.isBalanced = isB;
		}
	}
	
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
				
		root.left = n5;root.right=n15;
		n5.left = n2;n5.right = n7;
		n15.left = n13; n15.right=n18;
		
		n18.right = n19;
		n19.right = n20;
		return root;
	}
	
	
	private static boolean isBalanced(Node root) {
	
		TreeInfo ti = checkHeights(root);
		
		return ti.isBalanced;
	}
	
	private static TreeInfo checkHeights(Node node) {
		if (node == null)
			return new TreeInfo(-1, true);
		
		TreeInfo left = checkHeights(node.left);
		TreeInfo right = checkHeights(node.right);
		
		if (Math.abs(left.height - right.height) > 1) {
			return new TreeInfo(Math.max(left.height, right.height) + 1, false);
		}
		
		return new TreeInfo(Math.max(left.height, right.height) + 1, left.isBalanced && right.isBalanced);
	}
	
	
	
	public static void main(String[] args) {
		Node root = constructTree();
		System.out.println("IsBalanced = " + isBalanced(root));
	}

}
