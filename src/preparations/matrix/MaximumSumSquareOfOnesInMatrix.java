package preparations.matrix;

public class MaximumSumSquareOfOnesInMatrix {
	
	
	private static int findMax(int[][] matrix) {
		
		int max = Integer.MIN_VALUE;
		int[][] results = new int[matrix.length][matrix.length];
		
		
		for (int i =0; i< matrix.length; i++) {
			for (int j=0; j <matrix.length; j++) {
				
				if (matrix[i][j] == 1) {
					int left = Integer.MAX_VALUE;
					int top = Integer.MAX_VALUE;
					int topLeft = Integer.MAX_VALUE;
					
					if (i>0)
						top = results[i-1][j];
					
					if (j>0)
						left = results[i][j-1];
					
					if (i> 0 && j > 0) 
						topLeft = results[i-1][j-1];
					
					// the size of max matrix ending at current i,j will be the minimum of left/right/topRight + 1
					results[i][j] = Math.min(left, Math.min(top, topLeft));
					if (results[i][j] != Integer.MAX_VALUE) {
						results[i][j] = results[i][j]+1;
						max = Math.max(max,  results[i][j]);
					}
				}
			}
		}
		
		if (max == Integer.MIN_VALUE) {
			return 0;
		}
		else return max * max;
	}
	

	public static void main(String[] args) {
		
		int[][] matrix = {
		{	1,	0,	1,	0,	0 },
		{	0,	1,	1,	1,	0},
		{	0,	1,	1,	1,	0},
		{	0,	1,	1,	1,	1},
		{	0,	0,	0,	0,	0},
		};
		
		System.out.println("Maximum = " + findMax(matrix));
		

	}
	

}
