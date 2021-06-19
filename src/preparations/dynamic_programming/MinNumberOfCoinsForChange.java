package preparations.dynamic_programming;

import java.util.*;

public class MinNumberOfCoinsForChange {

	private static int numCoins(int[] denoms, int i, int sum) {

		if (sum == 0)
			return 0;
		if (i < 0 || sum < 0)
			return Integer.MAX_VALUE;
		
		int min = Integer.MAX_VALUE;
		if (sum >= denoms[i]) {
			min = numCoins(denoms, i, sum-denoms[i]);
			if (min != Integer.MAX_VALUE)
				min = min + 1;
		}
		
		min = Math.min(min, numCoins(denoms, i-1, sum));
		
		
		return min;
	}
	
	
  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    /*
		// Iterative solution
		
		int min = numCoins(denoms, denoms.length-1, n);
		if(min == Integer.MAX_VALUE)
			return -1;		
		else return min;
		*/
		
		// DP Solution : First version
		/*
		int sum = n;
		int[][] dp = new int[denoms.length+1][sum+1];
		for (int i=0; i<dp.length; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
			dp[i][0] = 0;
		}
		
		for (int i=1; i<=denoms.length; i++) {
			for (int j=1; j<=sum; j++) {
				dp[i][j] = dp[i-1][j];
				if (j >= denoms[i-1]) {
					if (dp[i][j-denoms[i-1]] != Integer.MAX_VALUE)
						dp[i][j] = Math.min(dp[i][j], dp[i][j-denoms[i-1]] + 1);
				}
			}
		}
		if (dp[denoms.length][sum] == Integer.MAX_VALUE)
			return -1;
		
		return dp[denoms.length][sum];
		*/
		// DP solution : Space efficient
		int sum = n;
		int[] dp = new int[sum+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		
		for (int i=1; i<=denoms.length; i++) {
			for (int j=1; j<=sum; j++) {
				if (j >= denoms[i-1]) {
					if (dp[j-denoms[i-1]] != Integer.MAX_VALUE)
						dp[j] = Math.min(dp[j], dp[j-denoms[i-1]] + 1);
				}
			}
		}
		if (dp[sum] == Integer.MAX_VALUE)
			return -1;
		
		return dp[sum];		
  }
	
	
}
