package preparations.arrays;
import java.util.*;

public class FirstGreaterElementOnRight {

	private static int[] findFirstGreaterElement(int[] arr, int n) {
		
		Stack<int[]> stack = new Stack<>();
		int[] results = new int[arr.length]; // contain indexes of next higher value in the array
		
		// Have a stack.. keep adding elements as long as they are in decreasing order in stack..
		// the moment we see increasing pattern, pop all elements which are smaller than current and mark current value 
		// as next immediate greater element for all those popped values.
		for (int i=0; i<arr.length; i++) {
			
			if (stack.isEmpty())
				stack.push(new int[] {i, arr[i]});
			else {
				int[] stackTop = stack.peek();
				if (stackTop[1] >= arr[i]) {
					stack.push(new int[] {i, arr[i]});					
				} else {
					do {
						stackTop = stack.pop();
						results[stackTop[0]] = i;
						if (stack.isEmpty())
							break;
						stackTop = stack.peek();
					}while(stackTop[1] < arr[i] && !stack.isEmpty());
					stack.push(new int[] {i, arr[i]});										
				}
			}
			
			
		}
		
	
		return results;
	}
	
	
	
	public static void main(String[] args) {
		int[] arr  = {7, 3, 2, 6, 11, 9, 8, 10, 13};
		
		int n = 11;
		
		System.out.println("First greater element of " + n + " is " + Arrays.toString(findFirstGreaterElement(arr, n)));
		
		
	}

}
