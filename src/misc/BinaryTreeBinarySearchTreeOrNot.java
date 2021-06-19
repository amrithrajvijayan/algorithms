package misc;

public class BinaryTreeBinarySearchTreeOrNot {
	
	
	public void inordertraverse(BinaryNode bn) {
		
		
		if (bn.getLeft() != null)
			inordertraverse(bn.getLeft());
		
		System.out.print(" " + bn.getData());
		
		if (bn.getRight() != null)
			inordertraverse(bn.getRight());
		
		
	}
	
	
	public boolean checkIfBinarySearchTreeOrNot(BinaryNode bn) {
		
		if (bn.getLeft() == null || bn.getRight() == null) {
			return true;
		} else {
			
			boolean status = (checkIfBinarySearchTreeOrNot(bn.getLeft()) && checkIfBinarySearchTreeOrNot(bn.getRight()));
			boolean currentStatus = (bn.getLeft().getData() < bn.getData() && bn.getRight().getData() > bn.getData());
			
			return status && currentStatus;
			
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
		
		BinaryTreeBinarySearchTreeOrNot bt = new BinaryTreeBinarySearchTreeOrNot();
		//bt.inordertraverse(n10);
		
		boolean isBST = bt.checkIfBinarySearchTreeOrNot(n10);
		System.out.println("is BST ? = " + isBST);
		
	}

}
