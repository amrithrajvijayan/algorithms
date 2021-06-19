package preparations.linkedlist;

public class NodeSwap {

	/*
	  Write a function that takes in the head of a Singly Linked List, swaps every
	  pair of adjacent nodes in place (i.e., doesn't create a brand new list), and
	  returns its new head.
	
	  
	  If the input Linked List has an odd number of nodes, its final node should
	  remain the same.
	
	  
	  
	  Each <span>LinkedList</span> node has an integer <span>value</span> as well as
	  a <span>next</span> node pointing to the next node in the list or to
	  <span>None</span> / <span>null</span> if it's the tail of the list.
	
	  
	  
	  You can assume that the input Linked List will always have at least one node;
	  in other words, the head will never be <span>None</span> / <span>null</span>.
	
	  
	  
	  <span class="CodeEditor-promptParameter">head</span> = 0 -> 1 -> 2 -> 3 -> 4 -> 5 <span class="CodeEditor-promptComment">// the head node with value 0</span>
	  
	  
	  1 -> 0 -> 3 -> 2 -> 5 -> 4 <span class="CodeEditor-promptComment">// the new head node with value 1</span>
	  */
	
	
	  public static class LinkedList {
		    public int value;
		    public LinkedList next;

		    public LinkedList(int value) {
		      this.value = value;
		      this.next = null;
		    }
		  }

		  public LinkedList nodeSwap(LinkedList head) {
		    
				LinkedList pre = null;
				LinkedList first = head;
				LinkedList second = first.next;
				LinkedList newHead = null;
				
				if (second == null)
					return first;
				
				while(first != null && second !=null){
					if (pre != null)
						pre.next = second;
					first.next = second.next;
					second.next = first;
					
					if (newHead == null) 
						newHead = second;
					
					pre = first;
					first = pre.next;
					if (first == null)
						break;
					second = first.next;
					if (second == null)
						break;
				}
				
				
				
		    return newHead;
		  }	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
