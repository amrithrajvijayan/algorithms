package misc;

public class ConstructTreeFromInorderPreorder {

	private static class Node {
		String data;
		Node left;
		Node right;
		public Node(String d) {
			this.data = d;
		}
	}
	static int preIndex = 0;
	private static Node constructTree(String inOrder, String preOrder, int inStart, int inEnd) {
		
		if (inStart >= inEnd || preIndex >=preOrder.length()) return null;
		
		String currentData = preOrder.substring(preIndex, preIndex+1);
		preIndex++;
		Node current = new Node(currentData);
		int inLocation = inOrder.indexOf(currentData);
		
		
		current.left = constructTree(inOrder, preOrder, inStart, inLocation);
		current.right = constructTree(inOrder, preOrder, inLocation+1, inEnd);
		return current;
	}
	
	
	public static void main(String[] args) {
	// Inorder sequence: D B E A F C
	// Preorder sequence: A B D E C F
	    String inOrder = "DBEAFC";
	    String preOrder = "ABDECF";
	    
		Node root = constructTree(inOrder, preOrder, 0, inOrder.length()-1);
		System.out.println(root);
		
	}

}
