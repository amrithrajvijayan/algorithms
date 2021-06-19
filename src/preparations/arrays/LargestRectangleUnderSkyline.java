package preparations.arrays;

import java.util.*;

/*
<p>
  Write a function that takes in an array of positive integers representing the
  heights of adjacent buildings and returns the area of the largest rectangle
  that can be created by any number of adjacent buildings, including just one
  building. Note that all buildings have the same width of <span>1</span> unit.
</p>
  
  <p>
  For example, given <span>buildings = [2, 1, 2]</span>, the area of the largest
  rectangle that can be created is <span>3</span>, using all three buildings.
  Since the minimum height of the three buildings is <span>1</span>, you can
  create a rectangle that has a height of <span>1</span> and a width of
  <span>3</span> (the number of buildings). You could also create rectangles of
  area <span>2</span> by using only the first building or the last building, but
  these clearly wouldn't be the largest rectangles. Similarly, you could create
  rectangles of area <span>2</span> by using the first and second building or
  the second and third building.
</p>
  
  <p>
  To clarify, the width of a created rectangle is the number of buildings used
  to create the rectangle, and its height is the height of the smallest building
  used to create it.
</p>
  
  <p>
  Note that if no rectangles can be created, your function should return
  <span>0</span>.
</p>
  
  <pre><span class="CodeEditor-promptParameter">buildings</span> = [1, 3, 3, 2, 4, 1, 5, 3, 2]
</pre>
  
  <pre>9


*/


public class LargestRectangleUnderSkyline {

	private int findLargestRectangleInHistogram(ArrayList<Integer> heights) {
				
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
		
		// check areas of different rectangles
		int maxArea = 0;
		
		for (int i=0; i<heights.size(); i++) {
			int left = minLeft[i]; 
			int right = minRight[i]; 
			
			if (right == -1) {
				right = heights.size();
			}
			
			int area = (right - left - 1) * heights.get(i);
			
			maxArea = Math.max(maxArea, area);
		}		
		return maxArea;
	}
	
  public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
    // Write your code here.
    return findLargestRectangleInHistogram(buildings);
  }
}
