package misc;

public class DepthOfTree {
	
	
	
	
	public int findDepth(BinaryNode bn) {
		
		if (bn.getLeft() == null && bn.getRight() == null) {
			return 1;
		} else {
			
			int leftDepth = findDepth(bn.getLeft());
			int rightDepth = findDepth(bn.getRight());
			
			return (leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1);
		}
				
	}
	
	
	/*
	 *                10
	 *           4         15
	 *         5    1   12     20
	 * 
	 * 
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		
		BinaryNode n10 = new BinaryNode(10);
		BinaryNode n4 = new BinaryNode(4);
		BinaryNode n15 = new BinaryNode(15);
		BinaryNode n1 = new BinaryNode(1);
		BinaryNode n5 = new BinaryNode(5);
		BinaryNode n12 = new BinaryNode(12);
		BinaryNode n20 = new BinaryNode(20);

		n10.setLeft(n4);n10.setRight(n15);
		n4.setLeft(n5);n4.setRight(n1);
		n15.setLeft(n12);n15.setRight(n20);
		
		DepthOfTree bt = new DepthOfTree();
		//bt.inordertraverse(n10);
		
		int depth = bt.findDepth(n10);
		System.out.println("depth = " + depth);
		
	}

}
