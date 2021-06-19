package misc;

import java.util.Arrays;

public class RodCutting {
	
	
	private static int rodCut(int[] price, int length) {
		
		/*
		if (length ==0) {
			return 0;
		}
		
		int maxProfit = Integer.MIN_VALUE;
		
		for (int i=1; i<=length; i++) {
			
			int profit = price[i-1] + rodCut(price, length-i);
			if (profit > maxProfit) {
				maxProfit = profit;
			}
			
		}

	
		
		return maxProfit;*/
		
		int[] dp = new int[length+1];
		Arrays.fill(dp, 0);
		for (int i=1; i<=length; i++) {

			for (int j=1; j<=i; j++) {
				dp[i] = Math.max(dp[i], price[j-1] + dp[i-j]);	
			}
			
		}
		
		return dp[length];
		
	}
	
	
	
	public static void main(String[] args)
	{
		// length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int price [] = { 1, 5, 8, 9, 10, 17, 17, 20 };

		// rod length
		int n = 4;

		System.out.println("Profit is " + rodCut(price, n));
	}

}
