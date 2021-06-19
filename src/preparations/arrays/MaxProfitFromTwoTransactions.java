package preparations.arrays;

import java.util.*;

//  Maximum profit which could be obtained from two stock transactions.  O(n) time and space
public class MaxProfitFromTwoTransactions {

	private static int maxProfitFromTwoTransactions(int[] arr) {
		
		int minSoFar = arr[0];
		int maxForwardSum = Integer.MIN_VALUE;
		int[] forwardProfits = new int[arr.length];
		for (int i=1; i<arr.length-1; i++) {
			maxForwardSum = Math.max(maxForwardSum, arr[i]-minSoFar);
			minSoFar = Math.min(minSoFar, arr[i]);
			forwardProfits[i] = maxForwardSum;
		}		
		
		int[] backwardProfits = new int[arr.length];
		int maxSoFar = arr[arr.length-1];
		int maxBackwardProfit = Integer.MIN_VALUE;
		for (int i=arr.length-2; i>=0; i--) {
			maxBackwardProfit = Math.max(maxBackwardProfit, maxSoFar-arr[i]);
			maxSoFar = Math.max(maxSoFar, arr[i]);
			backwardProfits[i] = maxBackwardProfit;
		}
		
		int maxProfit = 0;
		for (int i=1; i<arr.length; i++) {
			maxProfit = Math.max(maxProfit, (forwardProfits[i-1] + backwardProfits[i])); // because stock has to be bought after its sold once
		}
		
		
		return maxProfit;
	}
	
	public static void main(String[] args) {
		int[] arr = {10,	3,	6,	8,	8,	2,	8,	1};
		
		
		
		System.out.println("max is " + maxProfitFromTwoTransactions(arr));
	}

}
