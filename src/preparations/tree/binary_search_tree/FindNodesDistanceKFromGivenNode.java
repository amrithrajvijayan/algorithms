package preparations.tree.binary_search_tree;
import java.util.*;
/*

  You're given the root node of a Binary Tree, a target value of a
  node that's contained in the tree, and a positive integer k.
  Write a function that returns the values of all the nodes that are exactly
  distance k from the node with target value.

  
  
  The distance between two nodes is defined as the number of edges that must be
  traversed to go from one node to the other. For example, the distance between
  a node and its immediate left or right child is 1. The same holds
  in reverse: the distance between a node and its parent is 1. In a
  tree of three nodes where the root node has a left and right child, the left
  and right children are distance 2 from each other.

  
  
  Each BinaryTree node has an integer value, a
  left child node, and a right child node. Children
  nodes can either be BinaryTree nodes themselves or
  None / null.

  
  
  Note that all BinaryTree node values will be unique, and your
  function can return the output values in any order.


tree = 1
     /   \
    2     3
  /   \     \
 4     5     6
           /   \
          7     8
target = 3
k = 2



[2, 7, 8] // These values could be ordered differently.

  */

public class FindNodesDistanceKFromGivenNode {
	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	
	public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {

		// create a map of node -> parent
		Map<Integer, BinaryTree> parentsMap = new HashMap<>();
		constructParentMap(tree, parentsMap, null);
		// find out the target node
		BinaryTree targetNode = getTargetNode(tree, parentsMap, target);
		// find all nodes k distant from target.
		ArrayList<Integer> retList = new ArrayList<>();
		if (targetNode != null)
			findKDistantNodes(parentsMap, retList, targetNode, k);

		return retList;
	}
	
	
	
	private void constructParentMap(BinaryTree tree, Map<Integer, BinaryTree> map, BinaryTree parent) {
		if (tree == null)
			return;
		map.put(tree.value, parent);

		constructParentMap(tree.left, map, tree);
		constructParentMap(tree.right, map, tree);
	}

	public BinaryTree getTargetNode(BinaryTree root, Map<Integer, BinaryTree> parentsMap, int target) {
		if (root.value == target)
			return root;

		BinaryTree parent = parentsMap.get(target);
		if (parent == null)
			return null;

		if (parent.left != null && parent.left.value == target)
			return parent.left;
		else if (parent.right != null && parent.right.value == target)
			return parent.right;

		return parent;
	}


	private static class Pair {
		BinaryTree tree;
		Integer distance;

		public Pair(BinaryTree b, Integer i) {
			this.tree = b;
			this.distance = i;
		}
	}

	private void findKDistantNodes(Map<Integer, BinaryTree> parentsMap, ArrayList<Integer> retList, BinaryTree target,
			int k) {

		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(target, 0));
		Map<Integer, Boolean> visited = new HashMap<>();
		visited.put(target.value, true);

		while (!queue.isEmpty()) {
			Pair current = queue.remove();
			int currentDistance = current.distance;

			if (currentDistance == k) {
				retList.add(current.tree.value);
				while (!queue.isEmpty()) {
					Pair p = queue.remove();
					retList.add(p.tree.value);
				}
				return;
			}
			if (current.tree.left != null && !visited.containsKey(current.tree.left.value)) {
				visited.put(current.tree.left.value, true);
				queue.add(new Pair(current.tree.left, currentDistance + 1));
			}
			if (current.tree.right != null && !visited.containsKey(current.tree.right.value)) {
				visited.put(current.tree.right.value, true);
				queue.add(new Pair(current.tree.right, currentDistance + 1));
			}
			if (parentsMap.get(current.tree.value) != null
					&& !visited.containsKey(parentsMap.get(current.tree.value).value)) {
				visited.put(parentsMap.get(current.tree.value).value, true);
				queue.add(new Pair(parentsMap.get(current.tree.value), currentDistance + 1));
			}
		}

		return;
	}

}
