package preparations.tree.binary_search_tree;

public class InvertBinaryTree {
  public static void invertBinaryTree(BinaryTree tree) {
  	
		if (tree == null) 
			return;
		
		BinaryTree temp = tree.left;
		tree.left = tree.right;
		tree.right = temp;
		
		invertBinaryTree(tree.left);
		invertBinaryTree(tree.right);
		
		return;
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
