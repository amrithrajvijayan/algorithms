package preparations.dynamic_programming;

public class LongestCommonSubsequence {
	/*
	LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. 
	A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. 
	For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. 
	So a string of length n has 2^n different possible subsequences.
	*/
	
	/*
	private static int lcs(String a, String b, int i, int j) {
	    if (i < 0 || j < 0) 
	    	return 0;
	    int count1 = 0;
	    int count2 = 0
	    if (a.charAt(i) == b.charAt(j) ) {
	    	return lcs(a, b, i-1, j-1) + 1;
	    } else {
	      return Math.max(lcs(a, b, i-1, j), lcs(a, b, i, j-1));	
	    }
	}*/
	
	private static int lcs(String a, String b, int i, int j) {
		//Recursive
		/*
		if (i<0 || j<0) {
			return 0;
		}
		int count1 = 0;
		int count2 = 0;
		if (a.charAt(i) == b.charAt(j)) {
			return lcs(a,b, i-1, j-1) + 1;
		} else {
			count1 = lcs(a,b, i-1, j);			
			count2 = lcs(a,b, i, j-1);			
			return Math.max(count1,  count2);
		}*/
		
		// DP solution
		int[][] dp = new int[a.length()+1][b.length()+1];
		
		
		for (i=1; i<=a.length(); i++) {
			for (j=1; j<=b.length(); j++) {
				if (a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[a.length()][b.length()];
		
	}
	
	
	public static void main(String[] args) {
		String a = "aaattbbbb";
		String b = "xabbc";
		System.out.println(lcs(a, b, a.length()-1, b.length()-1));

	}

}
