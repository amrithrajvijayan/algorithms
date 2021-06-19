package misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CoinChange2 {

	/*
	You are given coins of different denominations and a total amount of money amount. Write a function to compute 
	the fewest number of coins that you need to make up that amount. 
	If that amount of money cannot be made up by any combination of the coins, return -1.

			Example 1: coins = [1, 2, 5], amount = 11 return 3 (11 = 5 + 5 + 1)

			Example 2: coins = [2], amount = 3 return -1.

			Note: You may assume that you have an infinite number of each kind of coin.
			*/
	
	
	private static int getMin(int[] coins, int sum) {
		/*
		if (sum ==0) {
			return 0;
		} else if (sum <0) {
			return Integer.MAX_VALUE;
		}
		
		
		int minCount = Integer.MAX_VALUE;
		for (int coin : coins) {
			
			int ret = getMin(coins, sum - coin);
			if (ret != Integer.MAX_VALUE)
				minCount = Math.min(minCount, ret+1);
			
		}
		return minCount;*/
		int[] dp = new int[sum+1];
		for (int i=1; i<=sum; i++) {
			
			dp[i] = Integer.MAX_VALUE;
			int res = Integer.MAX_VALUE;
			for (int c : coins) {
				
				if (i>=c) 
					res = dp[i-c];
				if (res != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], res+1);
				}
				
			}
			
		}
		return dp[sum];
		
	}
	
	
	private static int computeNumberOfCoins(int[] coins, int sum) {
		/*int count = minNumberOfCoins(coins, sum, coins.length-1, 0, 0, new ArrayList<Integer>());
		System.out.println("count = " + count);
		System.out.println(maxList);
		return count;*/
		return (getMin(coins, sum));
	}
	static int maxCount = Integer.MAX_VALUE;
	static List<Integer> maxList = null;
	
	private static int minNumberOfCoins(int[] coins, int sum, int position, int partialSum, int count, List<Integer> list) {
		if (partialSum == sum) {
			if (count < maxCount) {
				maxList = list;
				maxCount = count;
			}
			return count;
		} else if (partialSum > sum || position < 0) {
			return Integer.MAX_VALUE;
		}
		
		int tempSum = 0;
		int minCount = Integer.MAX_VALUE;
		int multiplier = 0;
		while(tempSum<sum) {
			List<Integer> newList = new ArrayList<>();
			newList.addAll(list);
			tempSum = partialSum + coins[position] * multiplier;
			for (int k=0; k<multiplier; k++) {
				newList.add(coins[position]);
			}
			minCount = Math.min(minCount, minNumberOfCoins(coins, sum, position-1, tempSum, count + multiplier, newList));
			multiplier++;
		}
		
		return minCount;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		int[] coins = {1, 2,5};
		int sum = 11;
		System.out.println(computeNumberOfCoins(coins, sum));

	}

}
