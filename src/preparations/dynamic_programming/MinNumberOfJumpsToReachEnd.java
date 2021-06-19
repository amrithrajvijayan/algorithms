package preparations.dynamic_programming;

import java.util.Arrays;

/*
  You're given a non-empty array of positive integers where each integer represents the
  maximum number of steps you can take forward in the array. For example, if the
  element at index 1 is 3, you can go from index
  1 to index 2, 3, or 4.

  */
public class MinNumberOfJumpsToReachEnd {
	
	
	private static int minNumberOfJumpsIterative(int[] arr) {
		
		int[] resultsArray = new int[arr.length];
		Arrays.fill(resultsArray, Integer.MAX_VALUE);
		resultsArray[0] = 0;
		
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<i; j++) {
				if (j + arr[j] >= i) {
					resultsArray[i] = Math.min(resultsArray[i], resultsArray[j] + 1);
				}
			}
		}
		return resultsArray[resultsArray.length-1];
	}
	
	
	

	public static void main(String[] args) {
		
		int[] arr = {2, 1, 3, 5, 2, 2, 1, 1, 5};
		
		
		System.out.println("No of jumps = " + minNumberOfJumpsIterative(arr));
		System.out.println("No of jumps = " + minNumberOfJumps(arr));
	}

	public static int minNumberOfJumps(int[] array) {

		if (array.length == 1)
			return 0;

		int maxReach = array[0];
		int steps = array[0];
		int jumps = 0;

		for (int i = 1; i < array.length - 1; i++) {

			maxReach = Math.max(maxReach, i + array[i]);
			steps--;
			if (steps == 0) {
				jumps++;
				steps = maxReach - i;
			}

		}

		return jumps + 1;
	}
}
