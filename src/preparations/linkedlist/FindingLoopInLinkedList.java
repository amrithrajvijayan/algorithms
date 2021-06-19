package preparations.linkedlist;

public class FindingLoopInLinkedList {
  public static LinkedList findLoop(LinkedList head) {
    
		LinkedList ptr1 = head;
		LinkedList ptr2 = head;
		do {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
		} while(ptr1 != ptr2);
		
		ptr1 = head;
		while(ptr1 != ptr2) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		
		
    return ptr1;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
