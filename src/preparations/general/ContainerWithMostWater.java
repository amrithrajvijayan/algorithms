package preparations.general;

public class ContainerWithMostWater {

/*
	Container With Most Water
	
	Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate 
	(i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
	Find two lines, which together with x-axis forms a container, such that the container contains the most water.
	
	Note: You may not slant the container and n is at least 2.
*/
	
	private static int findMostWater(int[] arr) {
		int mostWater = Integer.MIN_VALUE;
		int start = 0;
		int end = arr.length-1;
		while(start<=end) {
			
			int min = Math.min(arr[start], arr[end]);
			mostWater = Math.max(mostWater, min * (end-start+1));
			if (min == arr[start]) {
				start++;
			} else {
				end--;
			}
		}
		return mostWater;
	}
	
	
	public static void main(String[] args) {
		
		int[] arr= {2,	3,	4,	4,	4,	2,	2};
		System.out.println(findMostWater(arr));

	}

}
