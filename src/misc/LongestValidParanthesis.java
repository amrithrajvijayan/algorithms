package misc;

public class LongestValidParanthesis {
	
	
	/*
	 * Given a string A containing just the characters ’(‘ and ’)’.
	 * 
	 * Find the length of the longest valid (well-formed) parentheses substring.
	 * 
	 * 
	 * 
	 * Input Format:
	 * 
	 * The only argument given is string A.
	 * 
	 * Output Format:
	 * 
	 * Return the length of the longest valid (well-formed) parentheses substring.
	 * 
	 * Constraints:
	 * 
	 * 1 <= length(A) <= 750000
	 * 
	 * For Example
	 * 
	 * Input 1: A = "(()" Output 1: 2 Explanation 1: The longest valid parentheses
	 * substring is "()", which has length = 2.
	 * 
	 * Input 2: A = ")()())" Output 2: 4 Explanation 2: The longest valid
	 * parentheses substring is "()()", which has length = 4.
	 * 
	 */

	public int longestValidParentheses(String A) {

		int left = 0;
		int right = 0;
		int max = 0;

		for (int i = 0; i < A.length(); i++) {

			if (A.charAt(i) == '(') {
				left++;
			} else {

				right++;
			}

			if (left == right) {
				max = Math.max(max, 2 * left);
			} else if (right >= left) {
				left = 0;
				right = 0;
			}
		}

		left = right = 0;

		for (int i = A.length() - 1; i >= 0; i--) {

			if (A.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}

			if (left == right) {
				max = Math.max(max, 2 * left);
			}else if (left >= right) {
				left = 0;
				right = 0;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		LongestValidParanthesis lvp = new LongestValidParanthesis();
		System.out.println("result = " + lvp.longestValidParentheses("((())"));
	}

}
