package misc;

public class StockSale {

	/*
	Say you have an array for which the ith element is the price of a given stock on day i.

	If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

	Example 1:

	Input: [7, 1, 5, 3, 6, 4] Output: 5

	max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)

	Example 2:

	Input: [7, 6, 4, 3, 1] Output: 0

	In this case, no transaction is done, i.e. max profit = 0.
	*/
	
	private static int findMaxProfit(int[] input) {
		
		if (input == null || input.length == 0) 
			return 0;
		
		//int[] profits = new int[input.length+1];
		//int[] holding = new int[input.length+1];
		//profits[0] = 0;
		int preProfit = 0;
		int currentProfit = 0;
		int preHolding = Integer.MAX_VALUE;
		int currentHolding = 0;
		
		//holding[0] = Integer.MAX_VALUE;
		for (int i=1; i<=input.length;i++) {
			//holding[i] = Math.min(holding[i-1], input[i-1]);
			//profits[i] = Math.max(profits[i-1], input[i-1] - holding[i-1]);
			currentHolding = Math.min(preHolding, input[i-1]);
			currentProfit = Math.max(preProfit, input[i-1] - currentHolding);
			preProfit = currentProfit;
			preHolding = currentHolding;
		}
		
		
		
		//return profits[input.length];
		return currentProfit;
		
	}
	
	
	public static void main(String[] args) {

		int[] input = {7, 1, 5, 3, 6, 4};
		System.out.println("max is " + findMaxProfit(input));
		
	}

}
