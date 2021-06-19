package preparations.trees;

public class IsSymmetricTree {

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
		Node n5_1 = new Node(5);
		Node n5_2 = new Node(5);
		
		root.left=n5_1;root.right=n5_2;
		
		Node n7_1 = new Node(7);
		Node n7_2 = new Node(7);
		
		n5_1.left=n7_1;
		n5_2.right=n7_2;
		
		Node n8_1 = new Node(8);
		Node n8_2 = new Node(8);
		
		n5_1.right=n8_1;
		n5_2.left = n8_2;
		
		
		return root;
	}
	
	
	private static boolean isSymmetric(Node root) {
		return checkSymmetric(root.left, root.right);
	}
	
	private static boolean checkSymmetric(Node n1, Node n2) {

		if (n1 == null && n2 == null)
			return true;
		else if (n1 == null || n2 == null)
			return false;
		
		if (n1.value != n2.value)
			return false;
		
		boolean b1 = checkSymmetric(n1.left, n2.right);
		boolean b2 = checkSymmetric(n1.right, n2.left);
		
		
		return b1 && b2;
	}
	
	
	
	public static void main(String[] args) {
		Node root = constructTree();
		System.out.println("Is Symmetric = " + isSymmetric(root));
	}

}
