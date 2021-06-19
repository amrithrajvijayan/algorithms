package preparations.dynamic_programming;

public class NumberOfWaysToMakeChangeForTargetAmount {
	
	
	
	public static void main(String[] args){
		
		int n = 10;
		int[] denoms = {5, 1};
		
		System.out.println(numberOfWaysToMakeChange(n, denoms));
	}
	
	
	private static int findNumWaysRecursive(int[] denoms, int i, int j) {
		if (j < 0) {
			return 0;
		}
		if (i < 0)
			return 0;
		if (j == 0)
			return 1;

		return findNumWaysRecursive(denoms, i - 1, j) + findNumWaysRecursive(denoms, i, j - denoms[i]);
	}

	public static int numberOfWaysToMakeChange(int n, int[] denoms) {
		// return findNumWaysRecursive(denoms, denoms.length-1, n);

		int[] dp = new int[n + 1];
		dp[0] = 1;

		for (int i = 1; i <= denoms.length; i++) {
			for (int j = 0; j <= n; j++) {
				if (j >= denoms[i - 1]) {
					dp[j] = dp[j] + dp[j - denoms[i - 1]];
				}
			}
		}
		return dp[n];
	}
}
