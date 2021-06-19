package preparations.stack;

import java.util.*;

/*
Write a function that takes in an array of integers representing a stack,
recursively sorts the stack in place (i.e., doesn't create a brand new array),
and returns it.

<p>
The array must be treated as a stack, with the end of the array as the top of
the stack. Therefore, you're only allowed to
</p>

<ul>
<li>
  Pop elements from the top of the stack by removing elements from the end of
  the array using the built-in <span>.pop()</span> method in your programming
  language of choice.
</li>
<li>
  Push elements to the top of the stack by appending elements to the end of
  the array using the built-in <span>.append()</span> method in your
  programming language of choice.
</li>
<li>
  Peek at the element on top of the stack by accessing the last element in the
  array.
</li>
</ul>

<p>
You're not allowed to perform any other operations on the input array,
including accessing elements (except for the last element), moving elements,
etc.. You're also not allowed to use any other data structures, and your
solution must be recursive.
</p>

*/
public class SortStackInPlace {

	  public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
	    
			if (stack.size() == 0)
				return stack;
			
			int top = stack.remove(stack.size() -1);
			sortStack(stack);
			insertIntoStackInOrder(stack, top);
			
	    return stack;
	  }
		
		private void insertIntoStackInOrder(ArrayList<Integer> stack, int value) {
			
			if ( (stack.size() == 0) || 
					(stack.get(stack.size()-1) <= value)) {
				stack.add(value);
				return;
			}
			
			int top = stack.remove(stack.size()-1);
			insertIntoStackInOrder(stack, value);
			stack.add(top);
			
		}
		
}
