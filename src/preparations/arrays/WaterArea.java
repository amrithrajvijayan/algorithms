package preparations.arrays;

/*
  You're given an array of non-negative integers where each non-zero integer
  represents the height of a pillar of width <span>1</span>. Imagine water being
  poured over all of the pillars; write a function that returns the surface area
  of the water trapped between the pillars viewed from the front. Note that
  spilled water should be ignored.
*/

public class WaterArea {
	public static int waterArea(int[] heights) {
		int[] arr1 = new int[heights.length];
		int[] arr2 = new int[heights.length];
		if (heights.length <= 1) {
			return 0;
		}
		// Left to right max
		arr1[0] = heights[0];
		for (int i = 1; i < heights.length; i++) {
			arr1[i] = Math.max(arr1[i - 1], heights[i]);
		}
		// Right to left max
		arr2[heights.length - 1] = heights[heights.length - 1];
		for (int i = heights.length - 2; i >= 0; i--) {
			arr2[i] = Math.max(arr2[i + 1], heights[i]);
		}
		// Min of above two arrays
		for (int i = 0; i < heights.length - 1; i++) {
			arr1[i] = Math.min(arr1[i], arr2[i]);
		}
		// Reduce the height of original pillers and add up the sum
		int sum = 0;
		for (int i = 0; i < heights.length - 1; i++) {
			arr2[i] = arr1[i] - heights[i];
			sum = sum + arr2[i];
		}

		return sum;
	}
}
