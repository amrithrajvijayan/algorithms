package preparations.dynamic_programming;

public class RodCutting {
	/*
	 * Given a rod of length n inches and an array of prices that contains prices of
	 * all pieces of size smaller than n. Determine the maximum value obtainable by
	 * cutting up the rod and selling the pieces. For example, if length of the rod
	 * is 8 and the values of different pieces are given as following, then the
	 * maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
	 * 
	 * length | 1 2 3 4  5   6   7   8 -------------------------------------------- 
	 * price   | 1 5 8 9 10 17 17 20
	 * 
	 * And if the prices are as following, then the maximum obtainable value is 24
	 * (by cutting in eight pieces of length 1)
	 * 
	 * length | 1 2 3 4 5 6 7 8 -------------------------------------------- price |
	 * 3 5 8 9 10 17 17 20
	 */

	private static int maxValue(int[] prices, int index, int length) {

		/*
		// Recursive solution
		if (index <= 0) {
			return 0;
		} else if (length <= 0) {
			return 0;
		}

		int sum1 = maxValue(prices, index - 1, length);
		int sum2 = 0;
		if (length >= index)
			sum2 = maxValue(prices, index, length - index) + prices[index - 1];

		return Math.max(sum1, sum2);
		*/
		
		// DP Solution

		int[] dp = new int[length + 1];

		for (int i = 1; i <= prices.length; i++) {
			for (int j = 0; j <= length; j++) {
				if (j >= i)
					dp[j] = Math.max(dp[j], dp[j - i] + prices[i - 1]);
			}

		}

		return dp[length];

	}

	public static void main(String[] args) {
		int[] prices = { 3, 5, 8, 9, 10, 17, 17, 20 };
		int n = 8;
		System.out.println(maxValue(prices, prices.length, n));
	}

}
