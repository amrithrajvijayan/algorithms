package preparations.linkedlist;

public class RemoveDuplicatesFromLinkedList {
	public static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}

	public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {

		LinkedList node = linkedList;
		LinkedList pre = null;
		int lastValue = 0;

		while (node != null) {
			if (lastValue != node.value)
				pre = node;

			lastValue = node.value;
			node = node.next;
			pre.next = node;

		}

		return linkedList;
	}
}
