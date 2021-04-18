package preparations.linkedlist;

public class SwapNodesInPairs {

	static class Node {
		int value;
		Node next;

		public Node(int v) {
			this.value = v;
		}
	}
	
	
	
	
	private static Node swapInPairs(Node n) {
		Node returnNode = null;
		if (n.next == null)
			return n;
		if (n.next.next == null) {
			
			Node n1 = n;
			Node n2 = n.next;
			n2.next = n1;
			n1.next = null;
			return n2;
		}
		
		Node pre = null;
		Node n1 = n;
		Node n2 = n.next;
		Node n3 = n.next.next;
		
		while(true) {
			
			if (pre != null) 
				pre.next = n2;
			else returnNode = n2;
			
			n2.next = n1;
			n1.next = n3;
			
			pre = n1;
			n1 = n1.next;
			if (n1 == null)
				break;
			n2 = n1.next;
			if (n2 == null)
				break;
			n3 = n2.next;
			if  (n3 == null)
				break;
		}
		
		if (n3 == null) {
			pre.next = n2;
			n2.next = n1;
			n1.next = null;
		}
		
		
		return returnNode;
	}
	
	
	
	

	public static void main(String[] args) {
		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next =n8;
		
		
		Node head = swapInPairs(n1);
		
		Node n = head;
		while(n!=null) {
			System.out.print(n.value + " -> ");
			n = n.next;
		}
	}

}
