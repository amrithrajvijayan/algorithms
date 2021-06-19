package preparations.linkedlist;

public class RearrangeLinkedListAroundK {
  public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
		
		
		LinkedList node = head, pre=null;
		LinkedList lesserHead=null, lesserTail=null, equalHead=null, equalTail=null, higherHead=null, higherTail=null;
		
		while(node != null) {
			
			if (node.value < k) {
				if (lesserHead == null) {
					lesserHead = node;
					lesserTail = node;
				} else {
					lesserTail.next = node;
					lesserTail = node;
				}
			}
			if (node.value > k) {
				if (higherHead == null) {
					higherHead = node;
					higherTail = node;
				} else {
					higherTail.next = node;
					higherTail = node;
				}
			}
			if (node.value == k) {
				if (equalHead == null) {
					equalHead = node;
					equalTail = node;
				} else {
					equalTail.next = node;
					equalTail = node;
				}
			}			
			pre = node;
			node = node.next;
		}
		LinkedList returnHead = lesserHead;
		
		if (lesserHead == null) {
			if (equalHead != null) {
				returnHead = equalHead;
				equalTail.next = higherHead;
			} else {
				returnHead = higherHead;
			}
		} else {
			if (equalHead != null) {
				lesserTail.next = equalHead;
				equalTail.next = higherHead;
			} else {
				lesserTail.next = higherHead;
			}
		}
		if (higherTail != null) {
			higherTail.next = null;
		} else if (equalTail != null) {
			equalTail.next = null;
		} else if (lesserTail != null) {
			lesserTail.next = null;
		}
    
    return returnHead;
  }

  static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      next = null;
    }
  }
}
