package misc;

public class DoublyLinkedList {
	
	class DoubleLinkedList {

		class Node {
			private Object value;
			private Node next;
			private Node pre;
			
			public Node(Object value) {
				this.value = value;
			}
			
			public void setNext(Node n) {
				this.next = n;
			}
			public void setPre(Node n) {
				this.pre = n;
			}
			public Node getNext() {
				return this.next;
			}
			public Node getPre() {
				return this.pre;
			}
			public Object getValue() {
				return this.value;
			}
		}
		
		private Node head, tail;
		
		public DoubleLinkedList() {
			super();
		}
		
		
		public void push(Object obj) {
			Node newNode = new Node(obj);
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.setNext(newNode);
				newNode.setPre(tail);
				tail = newNode;
			}
		}
		
		public void reverse() {
			Node currentNode = head;
			while(currentNode!=null) {
				
				Node pre = currentNode.getPre();
				Node next = currentNode.getNext();
				
				currentNode.setNext(pre);
				if (pre != null) {
					pre.setPre(currentNode);
				}
				
								
				currentNode = next;
				
			}	
			Node t = tail;
			tail = head;
			head = t;
		}
		
		
		public void pop(Object obj) {
			
			Node currentNode = head;
			while(currentNode!=null) {
				if (currentNode.getValue().equals(obj)) {
					break;
				}
				currentNode = currentNode.getNext();
			}
			if (currentNode != null) {
				if (currentNode.getPre() == null) {
					head = currentNode.getNext();
					head.setPre(null);
				} else if (currentNode.getNext() == null) {
					tail = tail.getPre();
					tail.setNext(null);
				} else {
					currentNode.getPre().setNext(currentNode.getNext());
					currentNode.getNext().setPre(currentNode.getPre());
				}
			}
		}
		
		public void print() {
			System.out.println("");
			Node currentNode = head;
			while(currentNode!=null) {
				System.out.print(currentNode.getValue() + " -> ");
				currentNode = currentNode.getNext();
			}
		}
		
	}
	
	public static void main(String args[]) {
		
		DoublyLinkedList dls = new DoublyLinkedList();
		
		DoubleLinkedList dl = dls.new DoubleLinkedList();
		dl.push("hello");
		dl.push("how");
		dl.push("are");
		dl.push("you");
		dl.print();
		/*dl.pop("are");
		dl.print();
		dl.pop("hello");
		dl.print();*/
		dl.reverse();
		dl.print();
	}
	
	

}
