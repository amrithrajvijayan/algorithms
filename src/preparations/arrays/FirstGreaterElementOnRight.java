package preparations.arrays;
import java.util.*;

public class FirstGreaterElementOnRight {

	private static int[] findFirstGreaterElement(int[] arr, int n) {
		
		Stack<int[]> stack = new Stack<>();
		int[] results = new int[arr.length]; // contain next higher value in the array
		
		// Have a stack.. keep adding elements as long as they are in decreasing order in stack..
		// the moment we see increasing pattern, pop all elements which are smaller than current and mark current value 
		// as next immediate greater element for all those popped values.
		for (int i=0; i<arr.length; i++) {
			
			if (stack.isEmpty())
				stack.push(new int[] {i, arr[i]});
			else {
				// peek the top element of stack
				int[] stackTop = stack.peek();
				// if top element is greater than current value, then just push the current value to stack
				if (stackTop[1] >= arr[i]) {
					stack.push(new int[] {i, arr[i]});					
				} else {
					//else pop the values from the stack as long as top of stack is less than current value
					//for all those values from stack, the current value is the next highest value. Use stored
					//index for updating results array.
					do {
						stackTop = stack.pop();
						results[stackTop[0]] = arr[i];
						if (stack.isEmpty())
							break;
						stackTop = stack.peek();
					}while(stackTop[1] < arr[i] && !stack.isEmpty());
					// finally, need to push current value into stack.
					stack.push(new int[] {i, arr[i]});										
				}
			}
			
			
		}
		
	
		return results;
	}
	
	
	
	public static void main(String[] args) {
		int[] arr  = {7, 3, 2, 6, 11, 9, 8, 10, 13};
		
		int n = 11;
		System.out.println("First greater elements are : " + Arrays.toString(findFirstGreaterElement(arr, n)));
		//System.out.println("\nRetry                      : " + Arrays.toString(findGreaterRightArray(arr)));
		
		System.out.println("\nRetry                      : " + Arrays.toString(findGreaterRightArrayBetterCode(arr)));
	}
	
	private static int[] findGreaterRightArrayBetterCode(int[] arr) {
		int[] retArray = new int[arr.length];
		Arrays.fill(retArray, 0);
		Stack<Integer> stack = new Stack<>();
		for (int i=0; i<arr.length; i++) {
			if (stack.size() == 0)
				stack.push(i);
			else {
				while(stack.size() > 0 && arr[i] > arr[stack.peek()]) 
					retArray[stack.pop()] = arr[i];
				stack.push(i);
			}
		}
		return retArray;
	}
	
	
	
	
	
	private static int[] findGreaterRightArray(int[] arr) {
		
		int[] retArray = new int[arr.length];
		Stack<Integer[]> stack = new Stack<>();
		
		for (int index=0; index<arr.length; index++) {
			if (stack.size() == 0) {
				stack.push(new Integer[] {arr[index], index});
			} else {
				Integer[] top = stack.peek();
				
				if (top[0] < arr[index]) {
					while(top[0] < arr[index]) {
						top = stack.pop();
						retArray[top[1]] = arr[index];
						if (stack.size() == 0)
							break;
						top = stack.peek();
					}
				}
				stack.push(new Integer[] {arr[index], index});					
			}
		}
		
		
		return retArray;
	}
	
	
	
	

}
