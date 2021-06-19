package preparations.linkedlist;

public class MergeLinkedLists {

	public static class LinkedList {
		int value;
		LinkedList next;

		LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}

	public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {

		LinkedList firstListPtr = headOne;
		LinkedList secondListPtr = headTwo;
		LinkedList head = null;
		LinkedList temp = null;
		LinkedList lastPtr = null;
		while (firstListPtr != null && secondListPtr != null) {
			if (firstListPtr.value < secondListPtr.value) {
				if (lastPtr == null) {
					lastPtr = firstListPtr;
					head = firstListPtr;
				} else {
					lastPtr.next = firstListPtr;
				}
				lastPtr = firstListPtr;
				firstListPtr = firstListPtr.next;
			} else {
				if (lastPtr == null) {
					lastPtr = secondListPtr;
					head = secondListPtr;
				} else {
					lastPtr.next = secondListPtr;
				}
				lastPtr = secondListPtr;
				secondListPtr = secondListPtr.next;
			}
		}
		if (firstListPtr != null) {
			lastPtr.next = firstListPtr;
		} else if (secondListPtr != null) {
			lastPtr.next = secondListPtr;
		}

		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
