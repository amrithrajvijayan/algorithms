package preparations.dynamic_programming;

/*
<p>
  You're given two positive integers representing the width and height of a
  grid-shaped, rectangular graph. Write a function that returns the number of
  ways to reach the bottom right corner of the graph when starting at the top
  left corner. Each move you take must either go down or right. In other words,
  you can never move up or left in the graph.
</p>
  <p>
  For example, given the graph illustrated below, with
  <span>width = 2</span> and <span>height = 3</span>, there are three ways to
  reach the bottom right corner when starting at the top left corner:
</p>
  */

public class NumberOfWaysToTraverseGraph {

	private int numberOfWays(int i, int j) {
		
		if (i == 1 && j == 1)
			return 1;
		
		int sum = 0;
		
		if (i > 1)
			sum = sum + numberOfWays(i-1, j);
		if (j > 1)
			sum = sum + numberOfWays(i, j-1);
		
		return sum;
	}
	
	
  public int numberOfWaysToTraverseGraph(int width, int height) {
    //return numberOfWays(width, height);
		/*int[][] dp = new int[width][height];
		dp[0][0] = 1;
		
		for(int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {
				if (i >0)
					dp[i][j] = dp[i][j] + dp[i-1][j];
				if (j > 0)
					dp[i][j] = dp[i][j] + dp[i][j-1];
			}
		}
		return dp[width-1][height-1];*/

		int[] dp = new int[height];
		dp[0] = 1;
		
		for(int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {
				if (j > 0)
					dp[j] = dp[j] + dp[j-1];
			}
		}
		return dp[height-1];
	
	}
	
}
