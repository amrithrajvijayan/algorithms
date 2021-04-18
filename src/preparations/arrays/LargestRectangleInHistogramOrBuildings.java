package preparations.arrays;
import java.util.*;

// O(n) time.. O(n) space
public class LargestRectangleInHistogramOrBuildings {
	
	
		private static int findLargestRectangleInHistogram(ArrayList<Integer> heights) {
		
		System.out.println("Inputs are  " + (heights));
		
		// construct min left array and min right array for all the elements
		int[] minLeft = new int[heights.size()];
		int[] minRight = new int[heights.size()];
		Arrays.fill(minLeft, -1);
		Arrays.fill(minRight, -1);
		
		// Populate minRight array.
		Stack<int[]> stack = new Stack<>();
		for (int i=0; i<heights.size(); i++) {
			if (stack.isEmpty())
				stack.push(new int[] {i, heights.get(i)});
			else {
				int[] top = stack.peek();
				if (top[1] <= heights.get(i)) {
					stack.push(new int[] {i, heights.get(i)});					
				} else {
					while(top[1] > heights.get(i)) {
						minRight[top[0]] = i;//heights[i];
						if(stack.isEmpty())
							break;
						top = stack.peek();
						
						if (top[1] < heights.get(i)) {
							break;
						}						
						else top = stack.pop();
					}
					stack.push(new int[] {i, heights.get(i)});												
				}
				
			}
		}
		System.out.println("minRight is " + Arrays.toString(minRight));
		
		// Populate minLeft array.
		stack = new Stack<>();
		for (int i=heights.size()-1; i>=0; i--) {
			if (stack.isEmpty())
				stack.push(new int[] {i, heights.get(i)});
			else {
				int[] top = stack.peek();
				if ( heights.get(i) > top[1]) {
					stack.push(new int[] {i, heights.get(i)});					
				} else {
					while(heights.get(i) <= top[1]) {
						minLeft[top[0]] = i;//heights[i];
						if(stack.isEmpty())
							break;
						top = stack.peek();
						
						if (heights.get(i) > top[1]) {
							break;
						}						
						else top = stack.pop();
					}
					stack.push(new int[] {i, heights.get(i)});												
				}
				
			}
		}
		System.out.println("minLeft is  " + Arrays.toString(minLeft));		
		
		// check areas of different rectangles
		int maxArea = 0;
		
		for (int i=0; i<heights.size(); i++) {
			int left = minLeft[i]; 
			int right = minRight[i]; 
			
			if (right == -1) {
				right = heights.size();
			}
			
			int area = (right - left - 1) * heights.get(i);
			
			System.out.println(" area for " + heights.get(i) + " is " + area);
			maxArea = Math.max(maxArea, area);
		}		
		System.out.println("max is " + maxArea);
		return maxArea;
	}
	

	public static void main(String[] args) {
		Integer[] heights = {6, 2, 5, 4, 5, 1, 6};
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(heights));
		int maxArea = findLargestRectangleInHistogram(list);
		System.out.println("\nMax area is " + maxArea);
	}

}
