package preparations.tree.binary_search_tree;

import java.util.*;

public class SideViewOfBinaryTree {
	
	static class Node {
		int value;
		Node left;
		Node right;
		public Node(int v) {
			this.value = v;
		}
	}
	
	
	private static int[] topOrBottomView(Node root, boolean isTop) {
		Map<Integer, Integer> map = new HashMap<>();
		navigateRecursive(root, map, 0, isTop);
		
		int[] retArray = new int[map.size()];
		int index = 0;
		for (Integer key : map.keySet()) {
			retArray[index] = map.get(key);
			index++;
		}
		return retArray;
	}
	
	
	private static void navigateRecursive(Node node, Map<Integer, Integer> map, int xAxisIndex, boolean isTop) {
		if (node== null)
			return;
		
			navigateRecursive(node.left, map, xAxisIndex-1, isTop);
			
			if (isTop) {
				if (!map.containsKey(xAxisIndex)) {
					map.put(xAxisIndex, node.value);
				}
			} else {
				map.put(xAxisIndex, node.value);				
			}
			
			navigateRecursive(node.right, map, xAxisIndex+1, isTop);

	}
	
	
	

	/*
	                10
	               /   \
	             8      15
	                    /   \
                     12     18  	
	                         /   \
	                      16      20
	                                  \
	                                   35
	*/
	public static void main(String[] args) {
		
		Node n10 = new Node(10);
		Node n8 = new Node(8);
		Node n15 = new Node(15);
		Node n12 = new Node(12);
		Node n18 = new Node(18);
		Node n16 = new Node(16);
		Node n20 = new Node(20);
		Node n35 = new Node(35);
		
		n10.left=n8;n10.right=n15;
		n15.left=n12;n15.right=n18;
		n18.left=n16;n18.right=n20;
		n20.right=n35;
		
		System.out.println("Top View = " + Arrays.toString(topOrBottomView(n10, true)));
		System.out.println("Bottom View = " + Arrays.toString(topOrBottomView(n10, false)));
		
	}

}
