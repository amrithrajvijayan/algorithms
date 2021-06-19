package preparations.matrix;

import java.util.Arrays;

public class MaxSumSubMatrix {

	private static int findMax(int[][] matrix) {

		int maxSum = Integer.MIN_VALUE;
		// i from 0 to matrix length
		for (int i = 0; i < matrix.length; i++) {
			int[] results = new int[matrix[0].length];

			// j from i to zero, backwards
			for (int j = i; j >= 0; j--) {
				int[] sumsArray = new int[matrix[0].length];
				// calculate the sum of columns ( sum of i to j is stored in kth index of
				// results array )
				for (int k = 0; k < matrix[0].length; k++) {
					results[k] = results[k] + matrix[j][k];
				}
				// find maximum sum range within sum Array.
				for (int k = 0; k < matrix[0].length; k++) {
					if (k == 0)
						sumsArray[k] = results[k];
					else {

						int currentSum = results[k];
						int previousSum = sumsArray[k - 1];
						int probableSum = previousSum + results[k];

						if (probableSum > currentSum && probableSum > previousSum) {
							sumsArray[k] = probableSum;
						} else {
							sumsArray[k] = currentSum;
						}
					}

					maxSum = Math.max(maxSum, sumsArray[k]);
				}
			}
		}

		return maxSum;
	}
	
	
	public static void main(String[] args) {
		int[][] matrix = { 
				{  1, -2,  0,  1, 1 }, 
				{ -1,  1,  2,  0, 1 }, 
				{  2,  0,  4, -2, 1 }, 
				{  0, -2, -1,  0, 1 }, };
		
		System.out.println("Maximum is " + findMax(matrix));
			
	}

}
