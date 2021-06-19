package preparations.dynamic_programming;

import java.util.*;

/*

  Write a function that takes in two strings and returns the minimum number of
  edit operations that need to be performed on the first string to obtain the
  second string.

  There are three edit operations: insertion of a character, deletion of a
  character, and substitution of a character for another.
*/

public class MinEditDistanceBetweenTwoStrings {
	
	
	private static int LDRRecursive(String s1, String s2, int i, int j) {
		
		if (i < 0 && j < 0)
			return 0;
		else if (i < 0)
			return j+1;
		else if (j < 0)
			return i+1;
		
		if (s1.charAt(i) == s2.charAt(j)) {
			return LDRRecursive(s1, s2, i-1, j-1);
		} else {
			return Math.min(
					LDRRecursive(s1, s2, i-1, j) // insert
			, Math.min(LDRRecursive(s1, s2, i, j-1), // delete
			LDRRecursive(s1, s2, i-1, j-1))) + 1; // replace
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		String s1 = "hello";
		String s2 = "hala";
		System.out.println(levenshteinDistance(s1, s2));
	}
	
	
	
	
	private static int findMinDistance(String str1, String str2, int i, int j) {

		if (i < 0)
			return j + 1;
		if (j < 0)
			return i + 1;

		int noActionDistance = Integer.MAX_VALUE;
		int addActionDistance = Integer.MAX_VALUE;
		int deleteActionDistance = Integer.MAX_VALUE;
		int replaceActionDistance = Integer.MAX_VALUE;

		if (str1.charAt(i) == str2.charAt(j)) {
			noActionDistance = findMinDistance(str1, str2, i - 1, j - 1);
		} else {
			addActionDistance = findMinDistance(str1, str2, i, j - 1) + 1;
			deleteActionDistance = findMinDistance(str1, str2, i - 1, j) + 1;
			replaceActionDistance = findMinDistance(str1, str2, i - 1, j - 1) + 1;
		}

		return Math.min(Math.min(noActionDistance, addActionDistance),
				Math.min(deleteActionDistance, replaceActionDistance));

	}

	public static int levenshteinDistance(String str1, String str2) {
		// Recursive solution
		// return findMinDistance(str1, str2, str1.length()-1, str2.length()-1);

		// DP solution
		/*
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				dp[0][j] = j;
			}
			dp[i][0] = i;
		}

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
				}
			}
		}
		return dp[str1.length()][str2.length()];
		 */
		// improved space complexity

		int[] dp1 = new int[str2.length() + 1];
		int[] dp2 = new int[str2.length() + 1];

		dp1[0] = 0;
		dp2[0] = 1;

		for (int j = 0; j <= str2.length(); j++) {
			dp1[j] = j;
		}

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp2[j] = dp1[j - 1];
				} else {
					dp2[j] = Math.min(dp1[j] + 1, Math.min(dp2[j - 1] + 1, dp1[j - 1] + 1));
				}
			}
			dp1 = Arrays.copyOfRange(dp2, 0, dp1.length);
			Arrays.fill(dp2, 0);
			dp2[0] = i + 1;
		}
		return dp1[str2.length()];

	}
}
