package preparations.dynamic_programming;
import java.util.*;


/*
  Write a function that takes in two strings and returns their longest common
  subsequence.

  
  A subsequence of a string is a set of characters that aren't necessarily
  adjacent in the string but that are in the same order as they appear in the
  string. For instance, the characters <span>["a", "c", "d"]</span> form a
  subsequence of the string <span>"abcd"</span>, and so do the characters
  <span>["b", "d"]</span>. Note that a single character in a string and the
  string itself are both valid subsequences of the string.

  */
  
public class LongestCommonSubSequenceBetweenTwoStrings {

	public static void main(String[] args) {
		String a = "aaattbbbb";
		String b = "xabbc";
		System.out.println(longestCommonSubsequence(a, b));

	}
	
	private static int commonSubsequence(String str1, String str2, int i, int j) {
		
		if (i < 0 || j < 0)
			return 0;
			
		int count1 = 0;
		int count2 = 0;
		
		if (str1.charAt(i) == str2.charAt(j)) {
			count1 = commonSubsequence(str1, str2, i-1, j-1) + 1;
		} else {
			count2 = Math.max(
				commonSubsequence(str1, str2, i-1, j),
				commonSubsequence(str1, str2, i, j-1));
		}
		return Math.max(count1, count2);
	}
	
	
  public static List<Character> longestCommonSubsequence(String str1, String str2) {
		//Recursive
    //commonSubsequence(str1, str2, str1.length()-1, str2.length()-1);
		
		
		int[][] dp = new int[str1.length()+1][str2.length()+1];
    // construct dp array
		for (int i=1; i<=str1.length();i++) {
			for (int j=1; j<=str2.length(); j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}		
		
		

		// backtrack
		List<Character> retList = new ArrayList<Character>();
		int i = dp.length-1;
		int j = dp[0].length -1;
		while(i > 0) {
			
			while(i > 0 && dp[i][j] == dp[i-1][j]){
				i--;
			}
			
			while(j > 0 && dp[i][j] == dp[i][j-1]) {
				j--;
			}
			if (i == 0)
				break;
			retList.add(0, str1.charAt(i-1));
			i--;
		}
				
		
    return retList;
  }
}
