package misc;

public class AreaOfRectangle {

	
	private static int findArea(int[] heights, int start, int stop) {
		int area = 0;
		int lowestValue = Integer.MAX_VALUE;
		int lowestValuePosition = -1;
		for (int pos = start; pos < stop; pos++) {
			if (heights[pos] < lowestValue) {
				lowestValue = heights[pos];
				lowestValuePosition = pos;
			}
		}

		if (lowestValuePosition != -1) {
			area = (stop - start) * lowestValue;
			//System.out.println(" Area = " + area);
		
			int area1 = findArea(heights, start, lowestValuePosition);
			int area2 = findArea(heights, lowestValuePosition+1, stop);
			
			if (area1 > area) { 
				area = area1;
			}
			if (area2 > area) {
				area = area2;
			}
		}
		return area;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		

		int[] heights = {1, 2, 3, 4, 5};
		
		System.out.println("largest area = " + findArea(heights, 0, heights.length));

	}

}
