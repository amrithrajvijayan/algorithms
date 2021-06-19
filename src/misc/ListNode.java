package misc;

public class ListNode {
	
	ListNode prev, next;
	int value;
	
	public ListNode() {
	}
	
	public ListNode(int n) {
		this.value = n;
	}

	public ListNode getPrev() {
		return prev;
	}

	public void setPrev(ListNode prev) {
		this.prev = prev;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	

}
