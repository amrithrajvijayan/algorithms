package preparations.linkedlist;

public class ReverseLinkedList {
  public static LinkedList reverseLinkedList(LinkedList head) {
    
		LinkedList current = head;
		LinkedList pre = null;
		LinkedList next = current.next;
		
		while(next != null) {

			current.next = pre;
			pre = current;
			current = next;
			next = next.next;
			
		}
		current.next = pre;
		
    return current;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
