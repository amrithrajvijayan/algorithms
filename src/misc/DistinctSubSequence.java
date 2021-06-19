package misc;

import java.util.Arrays;

public class DistinctSubSequence {
	
	/*
	Given two sequences A, B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.

	Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, “ACE” is a subsequence of “ABCDE” while “AEC” is not).

	Input Format:

	The first argument of input contains a string, A.
	The second argument of input contains a string, B.

	Output Format:

	Return an integer representing the answer as described in the problem statement.

	Constraints:

	1 <= length(A), length(B) <= 700

	Example :

	Input 1:
	    A = "abc"
	    B = "abc"
	    
	Output 1:
	    1

	Explanation 1:
	    Both the strings are equal.

	Input 2:
	    A = "rabbbit" 
	    B = "rabbit"

	Output 2:
	    3

	Explanation 2:
	    These are the possible removals of characters:
	        => A = "ra_bbit" 
	        => A = "rab_bit" 
	        => A = "rabb_it"
	        
	    Note: "_" marks the removed character.

	*/
	
	
	/*
	private int dp(String A, String B, int i, int j) {
		
		System.out.println("inside dp with i=" + i + " and j=" + j);
		if (i < 0 || j < 0) {
			System.out.println("returning 0");
			return 0;
		}
		System.out.println("      A[i]=" + A.charAt(i) + ", B[j]=" + B.charAt(j));
		
		if (A.charAt(i) == B.charAt(j)) {
			if (i==0 || j==0) {
				System.out.println("returning 1");
				return 1;
			} else {
				System.out.println("returning dp of i-1 and j-1");
				
				return dp(A, B, i-1, j-1);
			}
		} else {
			int c1 = dp(A, B, i, j-1);
			int c2 = dp(A, B, i-1, j);
			System.out.println("count1= " + c1 + " and count2=" + c2);
			System.out.println("returning sum=" + (c1+c2));
			return c1 + c2;
		}

		
	}
	*/
	
	
	
    public int numDistinct(String A, String B) {
    	
    	int[] firstArr = new int[A.length()+1];
    	int[] secondArr = new int[A.length()+1];
    	Arrays.fill(firstArr,  1);
    	Arrays.fill(secondArr,  0);

    	
    	for (int j=0; j<B.length(); j++) {
    		
    		for (int i=1; i <=A.length(); i++ ) {
    			
    			int sum1 = secondArr[i-1];
    			int sum2 = 0;
    			if (A.charAt(i-1) == B.charAt(j)) {
    				sum2 = firstArr[i-1];
    				
    			}
    			secondArr[i] = sum1 + sum2;
    			
    		}
    		firstArr = secondArr;
    		secondArr = new int[A.length() +1 ];
    		
    	}
    	
    	return firstArr[firstArr.length-1];
    }	
	
	public static void main(String[] args) {
		DistinctSubSequence ds = new DistinctSubSequence();
		//System.out.println("number of ways = " + ds.numDistinct("banana", "ban")); 
		System.out.println("number of ways = " + ds.numDistinct("aaaababbababbaabbaaababaaabbbaaabbb", "bbababa"));
		//System.out.println("number of ways = " + ds.numDistinct("rabbbbit", "rabit")); 

		// expected 22113
	}

}
