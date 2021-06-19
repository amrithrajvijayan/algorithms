package preparations.linkedlist;

public class LinkedListPalindrom {
	public boolean linkedListPalindrome(LinkedList head) {
		
		LinkedList slowNode = head;
		LinkedList fastNode = head;
		
		while(fastNode != null && fastNode.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}
		
		LinkedList reversedSecondHalfNode = reverseLinkedList(slowNode);
		LinkedList firstHalfNode = head;
		
		while(reversedSecondHalfNode != null) {
			if (reversedSecondHalfNode.value != firstHalfNode.value) 
				return false;
			reversedSecondHalfNode = reversedSecondHalfNode.next;
			firstHalfNode = firstHalfNode.next;
		}
		
		return true;
		
	}
	
	
	public static LinkedList reverseLinkedList(LinkedList head) {
		
		LinkedList previousNode = null;
		LinkedList currentNode = head;
		while(currentNode != null) { 
			LinkedList nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		return previousNode;
	}
	
	
	
	
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

}
