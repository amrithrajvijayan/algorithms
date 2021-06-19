package misc;

public class TreeNode {
	
	TreeNode left, right;
	int value;
	
	public TreeNode() {
	}
	
	public TreeNode(int n) {
		this.value = n;
	}
	
	public void setLeft(TreeNode n) {
		this.left = n;
	}
	
	public void setRight(TreeNode n) {
		this.right = n;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int n) {
		this.value = n;
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode getRight() {
		return right;
	}

}
