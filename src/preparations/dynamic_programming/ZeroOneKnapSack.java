package preparations.dynamic_programming;

import java.util.*;

/*
  You're given an array of arrays where each subarray holds two integer values
  and represents an item; the first integer is the item's value, and the second
  integer is the item's weight. You're also given an integer representing the
  maximum capacity of a knapsack that you have.
  

  Your goal is to fit items in your knapsack without having the sum of their
  weights exceed the knapsack's capacity, all the while maximizing their
  combined value. Note that you only have one of each item at your disposal.

  
  Write a function that returns the maximized combined value of the items that
  you should pick as well as an array of the indices of each item picked.

  
*/

public class ZeroOneKnapSack {

	private static List<List<Integer>> knapsackProblemAgain(int[][] input, int capacity) {

		/*
		 * int[][] dp = new int[input.length+1][capacity+1];
		 * 
		 * for (int i=1; i<=input.length; i++) { for (int j=1; j<=capacity; j++) {
		 * dp[i][j] = dp[i-1][j]; if (j >= input[i-1][1]) { dp[i][j] =
		 * Math.max(dp[i][j], dp[i-1][j-input[i-1][1]] + input[i-1][0]); } } }
		 */
		int[] dp = new int[capacity + 1];

		for (int i = 1; i <= input.length; i++) {
			for (int j = capacity; j >= 1; j--) {
				dp[j] = dp[j];
				if (j >= input[i - 1][1]) {
					dp[j] = Math.max(dp[j], dp[j - input[i - 1][1]] + input[i - 1][0]);
				}
			}
		}

		return null;
	}

	private static int kpAgainRecursive(int[][] input, int i, int c) {

		if (c <= 0 || i < 0)
			return 0;

		int w1 = kpAgainRecursive(input, i - 1, c);
		int w2 = 0;

		if (c >= input[i][1])
			w2 = kpAgainRecursive(input, i - 1, c - input[i][1]) + input[i][0];

		return Math.max(w1, w2);

	}

	public static void main(String[] args) {
		int[][] input = { { 10, 2 }, { 5, 3 }, { 15, 5 }, { 7, 7 }, { 6, 1 }, { 18, 4 }, { 3, 1 } };

		int capacity = 10;
		System.out.println("Maximum value is " + knapsackProblem(input, capacity));
		// System.out.println("Maximum value is " + knapsackProblemAgain(input,
		// capacity));
	}

	public static int maxValue(int[][] items, int i, int c) {

		if (c <= 0 || i < 0)
			return 0;

		int sum1 = maxValue(items, i - 1, c);
		int sum2 = 0;
		if (items[i][1] <= c)
			sum2 = maxValue(items, i - 1, c - items[i][1]) + items[i][0];

		return Math.max(sum1, sum2);
	}

	public static class DpEntry {
		int value;
		List<Integer> list = new ArrayList<>();

		public DpEntry(int v) {
			this.value = v;
		}
	}

	public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {

		int[][] dp = new int[items.length + 1][capacity + 1];

		for (int i = 1; i <= items.length; i++) {
			for (int j = 1; j <= capacity; j++) {
				dp[i][j] = dp[i - 1][j];
				if (items[i - 1][1] <= j) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - items[i - 1][1]] + items[i - 1][0]);
				}
			}
		}

		List<Integer> totalValue = Arrays.asList(dp[items.length][capacity]);
		List<Integer> finalItems = getKnapsackItems(dp, items, dp[items.length][capacity]);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(totalValue);
		result.add(finalItems);
		return result;
	}

	public static List<Integer> getKnapsackItems(int[][] dp, int[][] items, int weight) {

		List<Integer> sequence = new ArrayList<Integer>();

		int i = dp.length - 1;
		int c = dp[0].length - 1;
		while (i > 0) {

			if (dp[i][c] == dp[i - 1][c]) {
				i--;
			} else {
				sequence.add(0, i - 1);
				c = c - items[i - 1][1];
				i--;
			}
			if (c == 0)
				break;
		}

		return sequence;
	}

}
