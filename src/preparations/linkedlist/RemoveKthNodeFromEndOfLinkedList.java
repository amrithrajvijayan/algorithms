package preparations.linkedlist;

public class RemoveKthNodeFromEndOfLinkedList {
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
    
		int count = 0;
		LinkedList pointer1 = head;
		LinkedList pointer2 = head;
		
		while(count < k ) {
			pointer2 = pointer2.next;
			count++;
		}
		
		if (pointer2 == null) {
			head.value = head.next.value;
			head.next = head.next.next;
			return;
		}

		while(true) {
			
			if (pointer2.next == null)
				break;
			
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}
		

		pointer1.next = pointer1.next.next;
		
		return;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
