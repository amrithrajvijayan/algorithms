package misc;

import java.util.Stack;

public class InorderBinaryWithoutRecursion {
	private static class Node {
		int data;
		Node left;
		Node right;
		public Node(int i) {
			this.data = i;
		}
	}
	
	private static void inorderWithoutRecursion(Node root) {
		
		
		Stack<Node> stack = new Stack<>();
		Node current = root;
		while(current != null || stack.size() > 0) {
			while(current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			System.out.println(current.data);
			current = current.right;
			
		}
		
		
		
	}
	

	public static void main(String[] args) {
		Node root = new Node(5);
		Node l3 = new Node(3);
		Node l7 = new Node(7);
		root.left = l3;
		root.right = l7;
		Node l1 = new Node(1);
		Node l4 = new Node(4);
		l3.left = l1;
		l3.right = l4;
		Node l6 = new Node(6);
		Node l10 = new Node(10);
		l7.left = l6;
		l7.right = l10;
		
		inorderWithoutRecursion(root);
		
		
		
		
		

	}

}
