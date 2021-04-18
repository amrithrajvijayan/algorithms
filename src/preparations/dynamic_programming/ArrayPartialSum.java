package preparations.dynamic_programming;

public class ArrayPartialSum {
	
	public static void main(String[] args) {
		
		int[] arr = {13, 6, 19, 2, 4};
		int sum = 8;
		
		//System.out.println(canAddUpToSumRecursively(arr, arr.length-1, sum));
		System.out.println(canAddUpToSumDp(arr, sum));
	}
	
	private static boolean canAddUpToSumDp(int[] arr, int sum) {
		
		boolean[][] dp = new boolean[arr.length+1][sum+1];
		for (int i=0; i<=arr.length; i++)
			dp[i][0] = true;
		
		for (int i=1; i<=arr.length; i++) {
			for (int j=1;j<=sum; j++) {
				dp[i][j] = dp[i-1][j];
				if (j >= arr[i-1]) {
					dp[i][j] = dp[i][j] || dp[i][j-arr[i-1]];
				}
			}
		}
		
		for (int i=0; i<dp.length; i++){
			System.out.println("");
			for (int j=0; j<dp[0].length; j++) {
				System.out.print(dp[i][j] + "\t");
			}
		}
		System.out.println("\n");
		
		return dp[arr.length][sum];
	}
	
	
	private static boolean canAddUpToSumRecursively(int[] arr, int i, int sum) {
		if (sum ==0)
			return true;
		if (i <0 )
			return false;
		if (sum < 0)
			return false;
		
		boolean localValue =canAddUpToSumRecursively(arr, i-1, sum);
		if (sum >= arr[i])
			localValue = localValue || canAddUpToSumRecursively(arr, i-1, sum-arr[i]);
		return localValue;
		
	}

}
