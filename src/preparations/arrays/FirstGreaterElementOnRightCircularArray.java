package preparations.arrays;

import java.util.*;

public class FirstGreaterElementOnRightCircularArray {
 

	  public static int[] nextGreaterElement(int[] array) {
	    int[] result = new int[array.length];
			Arrays.fill(result, -1);
			
			Stack<Integer> stack = new Stack<Integer>();
			
			for (int index=0; index < 2*array.length; index++) { // will have to iterate two times through the array
				int circularIndex = index % array.length;
				
				while(stack.size() > 0 &&
						 array[stack.peek()] < array[circularIndex]) {
					int top = stack.pop();
					result[top] = array[circularIndex];
				}
				stack.push(circularIndex);
			}
			
	    return result;
	  }
	
		public static void main(String[] args) {
			int[] arr  = {2, 5, -3, -4, 6, 7, 2};
			
			System.out.println("Greater elements are : " + Arrays.toString(nextGreaterElement(arr)));
		}
}
