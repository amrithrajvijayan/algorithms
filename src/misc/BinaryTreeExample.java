package misc;

public class BinaryTreeExample {
	
	
	
	private int getDepth(TreeNode TreeNode) {
		if (TreeNode == null) {
			return 0;
		}
		int leftDepth = getDepth(TreeNode.getLeft());
		int rightDepth = getDepth(TreeNode.getRight());
		return (leftDepth >= rightDepth ? leftDepth +1 : rightDepth + 1);
	}
	
	private void inorder(TreeNode TreeNode) {
		if (TreeNode.getLeft() != null) {
			inorder(TreeNode.getLeft());
		}
		
		System.out.print(TreeNode.getValue() + " ");
		if (TreeNode.getRight() != null) {
			inorder(TreeNode.getRight());
		}
		
	}
	
	private void insertTreeNode(TreeNode TreeNode, TreeNode newTreeNode) {

		if (TreeNode.getValue() > newTreeNode.getValue()) {
			if (TreeNode.getLeft() == null) {
				TreeNode.setLeft(newTreeNode);
			} else {
				insertTreeNode(TreeNode.getLeft(), newTreeNode);
			}
		} else if (TreeNode.getValue() < newTreeNode.getValue()) {
			if (TreeNode.getRight() == null) {
				TreeNode.setRight(newTreeNode);
			} else {
				insertTreeNode(TreeNode.getRight(), newTreeNode);
			}
		}

	}
	
	private boolean search(TreeNode TreeNode, int value) {
		if (TreeNode.getValue() == value) {
			return true;
		} 
		boolean returnValue = false;
		if (TreeNode.getValue() > value && TreeNode.getLeft() != null) {
			returnValue = returnValue || search(TreeNode.getLeft(), value);
		} else if (TreeNode.getValue() < value && TreeNode.getRight() != null) {
			returnValue = returnValue || search(TreeNode.getRight(), value);
		}
		return returnValue;
	}
	
	public static void main(String args[]) {
		TreeNode rootTreeNode = new TreeNode(10);
		TreeNode left1 = new TreeNode(5);
		TreeNode right1 = new TreeNode(15);
		rootTreeNode.setLeft(left1);
		rootTreeNode.setRight(right1);
		
		TreeNode left11 = new TreeNode(2);
		TreeNode left12 = new TreeNode(7);
		left1.setLeft(left11);
		left1.setRight(left12);
		
		TreeNode right11 = new TreeNode(13);
		TreeNode right12 = new TreeNode(17);
		right1.setLeft(right11);
		right1.setRight(right12);

		TreeNode left111 = new TreeNode(0);
		TreeNode left112 = new TreeNode(3);
		left11.setLeft(left111);
		left11.setRight(left112);

		
		
		BinaryTreeExample bte = new BinaryTreeExample();
		System.out.println("------inorder traversal-----");
		bte.inorder(rootTreeNode);
		
		System.out.println("\n------inserting new TreeNode 4-----");
		TreeNode newTreeNode = new TreeNode(4);
		bte.insertTreeNode(rootTreeNode, newTreeNode);
		System.out.println("------inorder traversal-----");
		bte.inorder(rootTreeNode);
		
		System.out.println("\n\nDepth = " + bte.getDepth(rootTreeNode));
		
		System.out.println("\n-----Searching for 13");
		System.out.println((bte.search(rootTreeNode, 17) ? "Found" : "Not found"));
	}

}
