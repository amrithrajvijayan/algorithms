package preparations.dynamic_programming;

import java.util.Arrays;

//import misc.Test.Entry;

public class LongestCommonSubstring {

	private static String findLongestCommonSubstringRecursive(String a, String b) {
		String ret = longestCommonSubstringRecursive(a, b, a.length() - 1, b.length() - 1, "");
		StringBuffer sb = new StringBuffer(ret);
		sb.reverse();
		return sb.toString();
	}

	private static String longestCommonSubstringRecursive(String a, String b, int ai, int bj, String substring) {

		if (ai < 0 || bj < 0)
			return substring;
		String retString = "";

		if (a.charAt(ai) == b.charAt(bj)) {
			String s1 = longestCommonSubstringRecursive(a, b, ai - 1, bj - 1, substring + a.charAt(ai));
			if (s1.length() > retString.length())
				retString = s1;
		} else {

			String s1 = longestCommonSubstringRecursive(a, b, ai, bj - 1, substring);
			if (s1.length() > retString.length())
				retString = s1;

			s1 = longestCommonSubstringRecursive(a, b, ai - 1, bj, substring);
			if (s1.length() > retString.length())
				retString = s1;
		}
		return retString;
	}

	public static class Entry {
		int count = 0;
		String chars = "";
	}

	public static String findLongestCommonSubstringDp(String a, String b) {

		Entry[] dp = new Entry[b.length() + 1];
		Arrays.fill(dp, new Entry());

		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {

				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					Entry entry = new Entry();
					entry.count = dp[j - 1].count + 1;
					entry.chars = dp[j - 1].chars + a.charAt(i - 1);
					dp[j] = entry;
				} else {
					Entry entry = new Entry();
					Entry entryToCopy = null;
					if (dp[j].count > dp[j - 1].count) {
						entryToCopy = dp[j];
					} else {
						entryToCopy = dp[j - 1];
					}
					entry.count = entryToCopy.count;
					entry.chars = entryToCopy.chars;
					dp[j] = entry;
				}

			}
		}
		return dp[b.length()].chars;
	}

	public static void main(String[] args) {

		String a = "abcdefaakalalkh";
		String b = "mmnnommndefaaononnnn";
		// System.out.println(findLongestCommonSubstringRecursive(a,b)); // defaa 5
		System.out.println(findLongestCommonSubstringDp(a, b));
	}

}
