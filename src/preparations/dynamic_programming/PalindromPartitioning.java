package preparations.dynamic_programming;

import java.util.Arrays;

public class PalindromPartitioning {

	/*
	Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a 
	palindrome. For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”. 
	Determine the fewest cuts needed for palindrome partitioning of a given string. For example, minimum 
	3 cuts are needed for “ababbbabbababa”. The three cuts are “a|babbbab|b|ababa”. If a string is palindrome, 
	then minimum 0 cuts are needed. If a string of length n containing all different characters, then
	minimum n-1 cuts are needed.	
	*/
	
	public static boolean isPalindrom(String str, int i, int j) {
		if (i == j)
			return true;
		String substring = str.substring(i, j + 1);
		StringBuilder sb1 = new StringBuilder(substring);
		StringBuilder sb2 = new StringBuilder(substring);
		sb2.reverse();
		return (sb1.toString().equals(sb2.toString()) ? true : false);
	}

	// O(n^3)
	public static int numberOfCutsDP(String str) {

		int[] dp = new int[str.length()];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 1; i < str.length(); i++) {
			int localCuts = Integer.MAX_VALUE;
			for (int j = 0; j <= i; j++) {
				if (isPalindrom(str, j, i)) {
					localCuts = Math.min(localCuts, (j == 0 ? 0 : dp[j - 1]));
				}
			}
			if (localCuts == Integer.MAX_VALUE) {
				localCuts = dp[i - 1];
			}
			dp[i] = localCuts + 1;
		}
		return dp[str.length() - 1] - 1;
	}

	// O(n^2)
	public static int numberOfCutsDPEfficient(String str) {

		boolean[][] results = new boolean[str.length()][str.length()];
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				if (i == j) {
					results[i][j] = true;
				} else {
					results[i][j] = false;
				}
			}
		}

		for (int length = 2; length < str.length() + 1; length++) {
			for (int i = 0; i < str.length() - length + 1; i++) {
				int j = i + length - 1;
				if (length == 2) {
					results[i][j] = (str.charAt(i) == str.charAt(j));
				} else {
					results[i][j] = (str.charAt(i) == str.charAt(j)) && results[i + 1][j - 1];
				}
			}
		}

		int[] dp = new int[str.length()];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 1; i < str.length(); i++) {
			int localCuts = Integer.MAX_VALUE;
			for (int j = 0; j <= i; j++) {
				if (results[j][i]) {
					localCuts = Math.min(localCuts, (j == 0 ? 0 : dp[j - 1]));
				}
			}
			if (localCuts == Integer.MAX_VALUE) {
				localCuts = dp[i - 1];
			}
			dp[i] = localCuts + 1;
		}
		return dp[str.length() - 1] - 1;
	}

	public static void main(String[] args) {
		String str = "abatee";
		// System.out.println(numberOfCuts(str, str.length()-1));
		// System.out.println(numberOfCutsDP(str));
		System.out.println(numberOfCutsDPEfficient(str));

	}

}
