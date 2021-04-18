package preparations.dynamic_programming;

import java.util.Arrays;

public class MinJumps {

	/*
		Given an array of integers where each element represents the max number of steps that can be made 
		forward from that element. Write a function to return the minimum number of jumps to reach the end 
		of the array (starting from the first element). If an element is 0, then cannot move through that element.

			Example:

			Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
			Output: 3 (1-> 3 -> 8 ->9)

			First element is 1, so can only go to 3. Second element is 3, so can make at most 3 steps eg to 5 or 8 or 9.
			*/
	
	private static int minimumStepsRecursive(int[] arr, int index) {
		if (index == arr.length-1) {
			return 0;
		} else if (index >= arr.length) {
			return Integer.MAX_VALUE;
		}
		int minLength = Integer.MAX_VALUE;
		for (int i = index+1; i<=(index + arr[index]); i++) {
			int localMin = minimumStepsRecursive(arr, i);
			if (localMin != Integer.MAX_VALUE)
				minLength = Math.min(minLength,  localMin + 1);
		}
		return minLength;
	}

	
	
	
	
	private static int minimumStepsDP(int[] arr) {
		int[] dp = new int[arr.length];
		if (arr.length == 1) {
			return 0;
		} else if (arr[0] == 0) {
			return -1;
		}
		Arrays.fill(dp,  Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<i; j++) {
				if (j + arr[j] >= i) {
					if (dp[j] != Integer.MAX_VALUE)
						dp[i] = Math.min(dp[i], dp[j] + 1);
				}
			}
		}
		
		
		return dp[arr.length-1];
	}
	
	
	
	
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 1, 2, 2, 2, 1, 1};
		// System.out.println(minimumStepsRecursive(arr, 0));
		System.out.println(minimumStepsDP(arr));
	}

}
