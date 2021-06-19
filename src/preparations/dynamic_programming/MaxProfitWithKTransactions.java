package preparations.dynamic_programming;

public class MaxProfitWithKTransactions {

	
	public static void main(String[] args) {
		int[] prices = {1, 3, 10, 3, 5, 10};
		int k = 2;
		
		System.out.println("Test Max Profit = " + maxProfitWithKTransactionsRepeat(prices, k));
		System.out.println("Max Profit = " + maxProfitWithKTransactions(prices, k));
	}
	
	public static int maxProfitWithKTransactionsRepeat(int[] prices, int k) {
		if (k==0)
			return 0;
	
		int[][] dp = new int[k+1][prices.length];
		
		for (int i=1; i<=k; i++) {
			int maxTillNow = Integer.MIN_VALUE;
			for (int j=1; j<prices.length; j++) {
				maxTillNow = Math.max(maxTillNow, dp[i-1][j-1] - prices[j-1]);
				dp[i][j] = Math.max(dp[i][j-1], maxTillNow + prices[j]);
			}	
		}
		
		return dp[k][prices.length-1];
	}
	
	
	public static int maxProfitWithKTransactions(int[] prices, int k) {
		if (prices.length == 0)
			return 0;

		int[][] dp = new int[k + 1][prices.length];

		for (int i = 1; i <= k; i++) {
			int maxTillNow = Integer.MIN_VALUE;
			for (int j = 1; j < prices.length; j++) {
				maxTillNow = Math.max(maxTillNow, dp[i - 1][j - 1] - prices[j - 1]);
				dp[i][j] = Math.max(dp[i][j - 1], maxTillNow + prices[j]);
			}
		}

		return dp[k][prices.length - 1];
	}
}
