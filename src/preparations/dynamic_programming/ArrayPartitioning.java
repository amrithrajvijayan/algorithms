package preparations.dynamic_programming;

public class ArrayPartitioning {
/*	
	Partition problem is to determine whether a given set can be partitioned into two subsets such that 
	the sum of elements in both subsets is same.	
	
	arr[] = {1, 5, 11, 5}
	Output: true 
	The array can be partitioned as {1, 5, 5} and {11}
	
	arr[] = {1, 5, 3}
	Output: false 
	The array cannot be partitioned into equal sum sets.	
*/

	private static boolean canPartitionDP(int[] arr) {
		
		int sum = 0;
		for (int i : arr) {
			sum = sum + i;
		}
		
		if (sum%2 == 1) {
			return false;
		}
		
		boolean[] dp = new boolean[sum/2+1];
		dp[0] = true;
		
		
		
		for (int i=1;i<=arr.length; i++) {
			for (int j=sum/2; j>=0; j--) {
				if (j >= arr[i-1]) {
					dp[j] = dp[j] || dp[j-arr[i-1]];
				}
			}
		}
			
		return dp[sum/2];
	}
	
	
	
	private static boolean partialSumRecursively(int[] arr, int index, int sum) {
		
		if (sum ==0 ) {
			return true;
		} else if (index <0) {
			return false;
		} else if (sum < 0) {
			return false;
		}
		
		boolean b1 = partialSumRecursively(arr, index-1, sum);
		boolean b2 = partialSumRecursively(arr, index-1, sum-arr[index]);
		
		return b1 || b2;
	}
	
	
	private static boolean canPartitionRecursively(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum = sum + i;
		}
		
		if (sum%2 == 1) {
			return false;
		}
		return partialSumRecursively(arr, arr.length-1, sum/2);
	}
	
	
	public static void main(String[] args) {
		int arr[] = {3, 6, 3};
		 //int arr[] = {1, 5, 11, 5};
		//System.out.println(canPartitionRecursively(arr));
		//System.out.println(canPartitionDP(arr));
		
		//System.out.println(rewriteCanPartitionRecursively(arr));
		System.out.println(rewriteCanPartitionUsingDP(arr));
	}
	
	
	private static boolean rewriteCanPartitionRecursively(int[] arr) {
		
		int sum = 0;
		for (int i : arr) {
			sum = sum + i;
		}
	    if (sum %2 != 0) 
	    	return false;
	    
	    sum = sum / 2;
	    
		return rewriteRecursive(arr, arr.length-1, sum);
	}
	
	private static boolean rewriteRecursive(int[] arr, int index, int sum) {
	
		if (sum == 0)
			return true;
		if (sum < 0)
			return false;
		if (index < 0)
			return false;
		
		return rewriteRecursive(arr, index-1, sum) || rewriteRecursive(arr, index-1, sum-arr[index]);
		
	}
	
	
	private static boolean rewriteCanPartitionUsingDP(int[] arr) {
		
		int sum = 0;
		for (int i : arr) {
			sum = sum + i;
		}
	    if (sum %2 != 0) 
	    	return false;
	    
	    // i -> index, j->sum
		// dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]]
		
		boolean dp[] = new boolean[sum+1];
		dp[0] = true;
		
		for (int i=1; i<=arr.length; i++) {
			for (int j=sum; j>=0; j--) {
				if (j >=arr[i-1])
					dp[j] = dp[j] || dp[j-arr[i-1]];
			}
		}
				
		return dp[sum];		
	}
	

}
