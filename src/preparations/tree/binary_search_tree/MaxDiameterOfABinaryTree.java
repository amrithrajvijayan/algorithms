package preparations.tree.binary_search_tree;

/*
  Write a function that takes in a Binary Tree and returns its diameter. The
  diameter of a binary tree is defined as the length of its longest path, even
  if that path doesn't pass through the root of the tree.

  A path is a collection of connected nodes in a tree, where no node is
  connected to more than two other nodes. The length of a path is the number of
  edges between the path's first node and its last node.

  Each <span>BinaryTree</span> node has an integer <span>value</span>, a
  <span>left</span> child node, and a <span>right</span> child node. Children
  nodes can either be <span>BinaryTree</span> nodes themselves or
  <span>None</span> / <span>null</span>.
*/


public class MaxDiameterOfABinaryTree {
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
	
	static class TreeInfo {
		public int diameter;
		public int height;
		public TreeInfo(int diameter, int height) {
			this.diameter = diameter;
			this.height = height;
		}
	}

	public TreeInfo getTreeInfo(BinaryTree tree) {
		if (tree == null)
			return new TreeInfo(0, 0);
		
		TreeInfo leftInfo = getTreeInfo(tree.left);
		TreeInfo rightInfo = getTreeInfo(tree.right);
		
		int longestAsRoot = leftInfo.height + rightInfo.height;
		int maxDiameterSoFar = Math.max(leftInfo.diameter, rightInfo.diameter);
		int currentDiameter = Math.max(longestAsRoot, maxDiameterSoFar);
		int currentHeight = 1 + Math.max(leftInfo.height, rightInfo.height);
	
		return new TreeInfo(currentDiameter, currentHeight);
	}
	
	
	
  public int binaryTreeDiameter(BinaryTree tree) {
    return getTreeInfo(tree).diameter;
  }
}
