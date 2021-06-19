package preparations.linkedlist;

public class SumOfLinkedLists {
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
    
		LinkedList head = null, currentNode = null, pre = null;
		int carry = 0;
			
		while(linkedListOne != null || linkedListTwo!= null) {
			int sum = carry;
			if (linkedListOne != null) {
				sum = sum + linkedListOne.value;
				linkedListOne = linkedListOne.next;
			}
			if (linkedListTwo != null) {
				sum = sum + linkedListTwo.value;
				linkedListTwo = linkedListTwo.next;
			}
			currentNode = new LinkedList(sum % 10);
			carry = sum / 10;
			if (head == null) {
				head = currentNode;
			}
			if (pre != null)
				pre.next = currentNode;
			
			pre = currentNode;
			
		}
		if (carry > 0) {
			LinkedList lastNode = new LinkedList(carry);
			pre.next = lastNode;
		}
		
    return head;
  }
}
