package preparations.arrays;

import java.util.Arrays;
import java.util.Stack;

// O(m*n) time and space
public class MaximumAreaOfRectangleFullOfOnes {

	
	private static int findMaxiumRectangleAreaInMatrix(int[][] matrix) {
		int maxArea = 0;
		
		int[][] heights = new int[matrix.length][matrix[0].length];
		// find out tower heights at each row.
		for (int i=1; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				
				if (matrix[i][j] == 0)
					heights[i][j] = 0;
				else {
					heights[i][j]  = heights[i-1][j] + 1;
				}
				
			}
		}
		// get area of tower at each row and record the max.
		for (int i=0; i<heights.length; i++) {
			int maxAreaPerRow = findLargestRectangleInHistogram(heights[i]);
			maxArea = Math.max(maxArea, maxAreaPerRow);
		}
		
		
		
		return maxArea;
	}
	
	
	public static void main(String[] args) {
		
		int[][] matrix = {
				{1, 0, 0, 0, 1, 1, 1},	
				{1, 0, 0, 0, 0, 0, 1},	
				{1, 0, 1, 1, 1, 0, 1},	
				{1, 0, 1, 1, 1, 0, 1},	
				{1, 0, 1, 1, 1, 1, 1},	
				{1, 0, 0, 0, 1, 0, 1}					
		};
		
		int maxArea = findMaxiumRectangleAreaInMatrix(matrix);
		System.out.println("max area is " + maxArea);

	}
	
	private static int findLargestRectangleInHistogram(int[] heights) {
		
		//System.out.println("heights are " + Arrays.toString(heights));
		
		// construct min left array and min right array for all the elements
		int[] minLeft = new int[heights.length];
		int[] minRight = new int[heights.length];
		Arrays.fill(minLeft, -1);
		Arrays.fill(minRight, -1);
		
		// Populate minRight array.
		Stack<int[]> stack = new Stack<>();
		for (int i=0; i<heights.length; i++) {
			if (stack.isEmpty())
				stack.push(new int[] {i, heights[i]});
			else {
				int[] top = stack.peek();
				if (top[1] <= heights[i]) {
					stack.push(new int[] {i, heights[i]});					
				} else {
					while(top[1] > heights[i]) {
						minRight[top[0]] = i;//heights[i];
						if(stack.isEmpty())
							break;
						top = stack.peek();
						
						if (top[1] < heights[i]) {
							break;
						}						
						else top = stack.pop();
					}
					stack.push(new int[] {i, heights[i]});												
				}
				
			}
		}
		//System.out.println("minRight is " + Arrays.toString(minRight));
		
		// Populate minLeft array.
		stack = new Stack<>();
		for (int i=heights.length-1; i>=0; i--) {
			if (stack.isEmpty())
				stack.push(new int[] {i, heights[i]});
			else {
				int[] top = stack.peek();
				if ( heights[i] > top[1]) {
					stack.push(new int[] {i, heights[i]});					
				} else {
					while(heights[i] <= top[1]) {
						minLeft[top[0]] = i;//heights[i];
						if(stack.isEmpty())
							break;
						top = stack.peek();
						
						if (heights[i] > top[1]) {
							break;
						}						
						else top = stack.pop();
					}
					stack.push(new int[] {i, heights[i]});												
				}
				
			}
		}
		//System.out.println("minLeft is  " + Arrays.toString(minLeft));		
		
		// check areas of different rectangles
		int maxArea = 0;
		
		for (int i=0; i<heights.length; i++) {
			int area = (minRight[i] - minLeft[i] - 1) * heights[i];
			//System.out.println(" area for " + heights[i] + " is " + area);
			maxArea = Math.max(maxArea, area);
		}		
		return maxArea;
	}	

}
