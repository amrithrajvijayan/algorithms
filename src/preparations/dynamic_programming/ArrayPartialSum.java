package preparations.dynamic_programming;

import java.util.*;

public class ArrayPartialSum {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 13, 6, 19, 2, 4};
		int sum = 13;

		System.out.println("Recursive " + canAddUpToSumRecursively(arr, arr.length-1, sum));
		System.out.println("DP " + canAddUpToSumDp(arr, sum));
	}
	
	private static ReturnData canAddUpToSumDp(int[] arr, int sum) {
		
		ReturnData[][] dp = new ReturnData[arr.length+1][sum+1];
		
		for (int i=0; i<=arr.length; i++)
			dp[i][0] = new ReturnData(true, -1); // base condition
		
		for (int i=1; i<=arr.length; i++) {
			for (int j=1;j<=sum; j++) {
				dp[i][j] = new ReturnData(dp[i-1][j]); // copy from row above. Current number may not be part of the final array making up sum
				
				if (j >= arr[i-1] && (dp[i-1][j-arr[i-1]] != null)) {
					boolean s = dp[i-1][j-arr[i-1]].found;
					if (s) {
						dp[i][j] = new ReturnData(s, dp[i-1][j-arr[i-1]].numbers);
						dp[i][j].numbers.add(arr[i-1]); // add current number to the list of numbers which makes up the sum
					}
				}
			}
		}		
		
		/*
		boolean[][] dp = new boolean[arr.length+1][sum+1];
		for (int i=0; i<=arr.length; i++)
			dp[i][0] = true;
		
		for (int i=1; i<=arr.length; i++) {
			for (int j=1;j<=sum; j++) {
				dp[i][j] = dp[i-1][j];
				if (j >= arr[i-1]) {
					dp[i][j] = dp[i][j] || dp[i-1][j-arr[i-1]];
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
		*/
		return dp[arr.length][sum];
	}
	
	
	private static  ReturnData canAddUpToSumRecursively(int[] arr, int i, int sum) {
		if (sum ==0)
			return new ReturnData(true, -1);
		
		if (i <0 )
			return new ReturnData(false, -1);
		
		if (sum < 0)
			return new ReturnData(false, -1);

		ReturnData rd = new ReturnData(false, -1);
		
		ReturnData localValue1 =canAddUpToSumRecursively(arr, i-1, sum);
		ReturnData localValue2 = new ReturnData(false, -1);
		
		if (localValue1.found) {
			rd.numbers = localValue1.numbers;
		}
		
		if (sum >= arr[i]) {
			localValue2 = canAddUpToSumRecursively(arr, i-1, sum-arr[i]);
			if (localValue2.found) {
				rd.numbers = localValue2.numbers;
				rd.numbers.add(arr[i]);
			}
		}
		
		rd.found = localValue1.found || localValue2.found;
		
		return rd;
		
	}
	
	
	static class ReturnData {
		boolean found;
		List<Integer> numbers = new ArrayList<>();
		
		public ReturnData(boolean s, Integer n) {
			this.found = s;
			if (n >=0) {
				numbers = new ArrayList<>();
				numbers.add(n);
			}
		}
		
		public ReturnData(ReturnData r) { 
			if (r != null) {
				this.found = r.found;
				this.numbers = new ArrayList<>(r.numbers);
			} else {
				this.found = false;
				this.numbers = new ArrayList<>();
			}
		}
		
		public ReturnData(boolean s, List<Integer> l) { 
				this.found = s;
				this.numbers = new ArrayList<>(l);
		}
		
		public String toString() {
			return "\n\tPossible ? = " + found + " \n\tPath=" + numbers.toString();
		}
	}

}
