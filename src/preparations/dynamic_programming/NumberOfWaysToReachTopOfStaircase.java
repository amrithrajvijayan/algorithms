package preparations.dynamic_programming;

/*
A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
steps at a time. Implement a method to count how many possible ways the child can run up the
stairs.
*/

public class NumberOfWaysToReachTopOfStaircase {

	private static int findNumberOfWaysIterative(int n, int steps, int height) {

		if (height == 0)
			return 1;
		if (height < 0)
			return 0;

		int numOfWays = 0;

		for (int i = 1; i <= steps; i++) {

			numOfWays = numOfWays + findNumberOfWaysIterative(n, steps, height - i);
		}

		return numOfWays;
	}

	public static void main(String[] args) {

		int n = 5;
		int steps = 2;
		// System.out.println(findNumberOfWaysIterative(n, steps, n));
		// System.out.println(findNumberOfWaysDP(n, steps));
		for (int i = 1; i < 10; i++)
			System.out.println("i=" + i + " ways=" + findNumberOfWaysDPMostEfficient(i, steps));
	}

	private static int findNumberOfWaysDP(int n, int steps) {

		int[] dp = new int[n + 1];

		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= steps; j++) {
				if (i >= j)
					dp[i] = dp[i] + dp[i - j];
			}
		}

		return dp[n];
	}

	private static int findNumberOfWaysDPMostEfficient(int n, int steps) {

		int[] dp = new int[n];

		dp[0] = 1;
		int sumTillNow = 0;

		for (int i = 1; i < n; i++) {

			if (i > steps) {
				sumTillNow = sumTillNow - dp[i - steps - 1];
			}

			sumTillNow = sumTillNow + dp[i - 1];
			dp[i] = sumTillNow;

		}

		return dp[n - 1];
	}

}
