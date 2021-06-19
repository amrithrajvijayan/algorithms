package misc;

public class DynamicDistinctSubsequence {

	/*
	 * Given two sequences A, B, count number of unique ways in sequence A, to form
	 * a subsequence that is identical to the sequence B.
	 * 
	 * Subsequence : A subsequence of a string is a new string which is formed from
	 * the original string by deleting some (can be none) of the characters without
	 * disturbing the relative positions of the remaining characters. (ie, “ACE” is
	 * a subsequence of “ABCDE” while “AEC” is not).
	 * 
	 * Input Format:
	 * 
	 * The first argument of input contains a string, A. The second argument of
	 * input contains a string, B.
	 * 
	 * Output Format:
	 * 
	 * Return an integer representing the answer as described in the problem
	 * statement.
	 * 
	 * Constraints:
	 * 
	 * 1 <= length(A), length(B) <= 700
	 * 
	 * Example :
	 * 
	 * Input 1: A = "abc" B = "abc"
	 * 
	 * Output 1: 1
	 * 
	 * Explanation 1: Both the strings are equal.
	 * 
	 * Input 2: A = "rabbbit" B = "rabbit"
	 * 
	 * Output 2: 3
	 * 
	 * Explanation 2: These are the possible removals of characters: => A =
	 * "ra_bbit" => A = "rab_bit" => A = "rabb_it"
	 * 
	 * Note: "_" marks the removed character.
	 * 
	 */

	public int numDistinct(String A, String B) {
		int[][] matrix = new int[A.length()][B.length()];
		return findDistincts(A, B, A.length()-1, B.length()-1, matrix);
	}
	
	private int findDistincts(String A, String B, int i, int j, int[][] matrix) {
		if (A.equals(B)) {
			return 1;
		}
		if (i == -1 && j == -1) {
			return 1;
		}
		
		if (i == -1 || j == -1) {
			return 0;
		}
		if (matrix[i][j] >0) {
			return matrix[i][j];
		}
		
		int count = 0;
		

		if (A.charAt(i) != B.charAt(j)) {
			count = findDistincts(A, B, i-1, j, matrix);
		} else {

			String A1 = A.substring(0, i) + A.substring(i+1, A.length());
			count = count + findDistincts(A1, B, i-1, j, matrix);
			count = count + findDistincts(A, B, i-1, j-1, matrix);
		}
		matrix[i][j] = count;
		
		
		
		return count;
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		System.out.println(new DynamicDistinctSubsequence().numDistinct("aaaababbababbaabbaaababaaabbbaaabbb", "bbababa"));

	}

}
