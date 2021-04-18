package preparations.arrays;

public class MaximumSumSizeOfSquareInMatrix {

	public static void main(String[] args) {
		
		int[][] matrix = {
		{	1,	0,	1,	0,	0 },
		{	0,	1,	1,	1,	0},
		{	0,	1,	1,	1,	0},
		{	0,	1,	1,	1,	1},
		{	0,	0,	0,	0,	0},
		};

		int[][] results = new int[matrix.length][matrix[0].length];
		int max = 1;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				
				if (matrix[i][j] == 1) {  // results[i][j] will be (minimum of results[i][j-1], results[i-1][j] and results[i-1][j-1]) + 1
					int left = Integer.MAX_VALUE;
					int top = Integer.MAX_VALUE;
					int topLeft = Integer.MAX_VALUE;
					if (j > 0)
						left = results[i][j - 1];

					if (i > 0)
						top = results[i - 1][j];

					if (i > 0 && j > 0)
						topLeft = results[i - 1][j - 1];

					results[i][j] = Math.min(left, Math.min(top, topLeft));
					if (results[i][j] != Integer.MAX_VALUE) {
						results[i][j] += 1;
						max = Math.max(max, results[i][j]);
					}
				}
			}
		}

		System.out.println("max = " + (max * max));

	}
	

}
