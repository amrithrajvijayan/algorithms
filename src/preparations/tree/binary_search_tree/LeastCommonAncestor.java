package preparations.tree.binary_search_tree;

/*
Find the lowest common ancestor in an unordered binary tree given two values in the tree.

    Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed 
    acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants. 

Example :


        ____3____
       /              \
      5              1
   /      \        /      \
   6      2     0        8
         /   \
        7    4

For the above tree, the LCA of nodes 5 and 1 is 3.

    LCA = Lowest common ancestor 

Please note that LCA for nodes 5 and 4 is 5.

        You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
        No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
        There are no duplicate values.
        You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.

*/
public class LeastCommonAncestor {

	static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
	}
	
	
	private static int lcaRecursive(TreeNode node, int i, int j, int[] result) {
		
		if (node == null)
			return 0;
		
		if (result[0] != Integer.MIN_VALUE)
			return 0;
		
		
		if (node.val == i || node.val == j) 
			return 1;
		
		int sum =  lcaRecursive(node.left, i, j, result) + lcaRecursive(node.right, i, j, result);
		
		if (sum == 2 && result[0] == Integer.MIN_VALUE)
			result[0] = node.val;
		
		return sum;
	}
	
	
	 
	public static int lca(TreeNode node, int i, int j) {
		int[] result = new int[1];
		result[0] = Integer.MIN_VALUE;
		lcaRecursive(node, i, j, result);
		return result[0];
    }
	
	/*
    ____3____
   /              \
  5              1
/      \        /   \
6      2     0      8
     /   \
    7    4
	*/
	
	public static void main(String[] args) {
    		TreeNode root = new TreeNode(3);
    		TreeNode n5 = new TreeNode(5);
    		TreeNode n1 = new TreeNode(1);
    		TreeNode n6 = new TreeNode(6);
    		TreeNode n2 = new TreeNode(2);
    		TreeNode n7 = new TreeNode(7);
    		TreeNode n4 = new TreeNode(4);
    		TreeNode n0 = new TreeNode(0);
    		TreeNode n8 = new TreeNode(8);
    		
    		root.left = n5;
    		root.right = n1;
    		n5.left = n6;
    		n5.right =n2;
    		n2.left = n7;
    		n2.right = n4;
    		n1.left = n0;
    		n1.right = n8;
    
    		int i = 6;
    		int j = 0;
    		
    		System.out.println("Least common ancestor of " + i + " and " + j + " is " + lca(root, i, j));
    }

}
