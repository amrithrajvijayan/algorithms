package preparations.matrix;

/*

  You're given a two-dimensional array (a matrix) of potentially unequal height
  and width that's filled with integers. You're also given a positive integer
  size. Write a function that returns the maximum sum that can be
  generated from a submatrix with dimensions size * size.

*/

public class MaximumSumSubMatrixGivenSubMatrixLength {

	private int[][] getSumsMatrix(int[][] matrix) {
		int[][] sums = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0 && j == 0) {
					sums[i][j] = matrix[i][j];
				} else if (i == 0) {
					sums[i][j] = sums[i][j - 1] + matrix[i][j];
				} else if (j == 0) {
					sums[i][j] = sums[i - 1][j] + matrix[i][j];
				} else {
					sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i][j];
				}
			}
		}
		return sums;
	}

	public int maximumSumSubmatrix(int[][] matrix, int size) {

		if (matrix.length < size || matrix[0].length < size) {
			return -1;
		}

		int[][] sums = getSumsMatrix(matrix);
		int maxSum = Integer.MIN_VALUE;

		for (int i = size - 1; i < matrix.length; i++) {
			for (int j = size - 1; j < matrix[0].length; j++) {
				int localSum = 0;

				if (i == size - 1 && j == size - 1) {
					localSum = sums[i][j];
				} else if (i == size - 1) {
					localSum = sums[i][j] - sums[i][j - size];
				} else if (j == size - 1) {
					localSum = sums[i][j] - sums[i - size][j];
				} else {
					localSum = sums[i][j] - sums[i - size][j] - sums[i][j - size] + sums[i - size][j - size];
				}
				maxSum = Math.max(maxSum, localSum);

			}
		}

		return maxSum;
	}
}
