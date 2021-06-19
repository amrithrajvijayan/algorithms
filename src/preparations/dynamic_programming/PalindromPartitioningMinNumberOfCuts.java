package preparations.dynamic_programming;

import java.util.*;

/*
Given a non-empty string, write a function that returns the minimum number of
  cuts needed to perform on the string such that each remaining substring is a
  palindrome.
*/


public class PalindromPartitioningMinNumberOfCuts {
	public static int palindromePartitioningMinCuts(String str) {

		boolean[][] palindroms = new boolean[str.length()][str.length()];

		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				if (i == j)
					palindroms[i][j] = true;
				else
					palindroms[i][j] = false;
			}
		}
		// pre calculate palindrom matrix to improve time complexity ( avoid calling
		// isPalindrom for each substring)
		for (int i = str.length() - 2; i >= 0; i--) {
			for (int j = str.length() - 1; j >= 0; j--) {
				if (j > i) {
					if (j - i == 1) {
						palindroms[i][j] = (str.charAt(i) == str.charAt(j));
					} else {
						palindroms[i][j] = (str.charAt(i) == str.charAt(j) && palindroms[i + 1][j - 1]);
					}
				}
			}
		}

		int[] cuts = new int[str.length()];

		Arrays.fill(cuts, Integer.MAX_VALUE);
		cuts[0] = 0;

		for (int i = 1; i < str.length(); i++) {
			for (int j = i - 1; j >= 0; j--) {
				// if(isPalindrom(str.substring(j, i+1))) {
				if (palindroms[j][i]) {

					if (j > 0) {
						cuts[i] = Math.min(cuts[i], cuts[j - 1] + 1);
					} else
						cuts[i] = 0;
				}
			}
			cuts[i] = Math.min(cuts[i], cuts[i - 1] + 1);
		}
		return cuts[str.length() - 1];
	}

	private static boolean isPalindrom(String str) {
		int i = 0;
		int j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

}
