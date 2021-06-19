package preparations.tree.binary_search_tree;

/*
<p>
  Write a function that takes in a Binary Tree, transforms it into a Right
  Sibling Tree, and returns its root.
</p>
  
  <p>
  A Right Sibling Tree is obtained by making every node in a Binary Tree have
  its <span>right</span> property point to its right sibling instead of its
  right child. A node's right sibling is the node immediately to its right on
  the same level or <span>None</span> / <span>null</span> if there is no node
  immediately to its right.
</p>

<p>
  Note that once the transformation is complete, some nodes might no longer have
  a node pointing to them. For example, in the sample output below, the node
  with value <span>10</span> no longer has any inbound pointers and is
  effectively unreachable.
</p>

<p>
  The transformation should be done in place, meaning that the original data
  structure should be mutated (no new structure should be created).
</p>

<p>
  Each <span>BinaryTree</span> node has an integer <span>value</span>, a
  <span>left</span> child node, and a <span>right</span> child node. Children
  nodes can either be <span>BinaryTree</span> nodes themselves or
  <span>None</span> / <span>null</span>.
</p>

Input

<pre><span class="CodeEditor-promptParameter">tree</span> =     1
      /         \
     2           3
   /   \       /   \
  4     5     6     7
 / \     \   /     / \
8   9    10 11    12 13
           /
          14
</pre>


Output

<pre>           1 <span class="CodeEditor-promptComment">// the root node with value 1</span>
      /
     2-----------3
   /           /
  4-----5-----6-----7
 /           /     /
8---9    10-11    12-13 <span class="CodeEditor-promptComment">// the node with value 10 no longer has a node pointing to it</span>
           /
          14
</pre>
  */

public class RightSiblingTree {
  public static BinaryTree rightSiblingTree(BinaryTree root) {
    modify(root, null, false);
    return root;
  }
	
	private static void modify(BinaryTree node, BinaryTree parent, boolean isLeftChild) {
		
		if (node == null) {
			return;
		}
		
		BinaryTree leftChild = node.left;
		BinaryTree rightChild = node.right;
		modify(leftChild, node, true);
		
		if(parent ==null) {
			node.right = null;
		} else if (isLeftChild) {
			node.right = parent.right;
		} else {
			if (parent.right == null) {
				node.right = null;
			} else {
				node.right = parent.right.left;
			}
		}
		
		modify(rightChild, node, false);
	}
	
	
	
	

  // This is the class of the input root. Do not edit it.
  static class BinaryTree {
    int value;
    BinaryTree left = null;
    BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
