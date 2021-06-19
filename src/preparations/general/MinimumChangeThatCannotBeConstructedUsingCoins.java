package preparations.general;

import java.util.Arrays;
/*
  Given an array of positive integers representing the values of coins in your
  possession, write a function that returns the minimum amount of change (the
  minimum sum of money) that you <b>cannot</b> create. The given coins can have
  any positive integer value and aren't necessarily unique (i.e., you can have
  multiple coins of the same value).
*/

public class MinimumChangeThatCannotBeConstructedUsingCoins {
	public int nonConstructibleChange(int[] coins) {

		Arrays.sort(coins);

		int sumTillNow = 0;
		for (int coin : coins) {
			if (coin > sumTillNow + 1)
				break;

			sumTillNow = sumTillNow + coin;
		}
		return sumTillNow + 1;
	}

}
