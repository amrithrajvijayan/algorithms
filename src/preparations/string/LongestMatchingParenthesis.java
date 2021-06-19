package preparations.string;

/*
 *  Find the max count of number of matching and closing braces appearing consecutively
 */


public class LongestMatchingParenthesis {

	public static int longestBalancedSubstring(String string) {
		if (string == null || string.length() == 0)
			return -1;
		int maxLength = -1;
		int currentLength = -1;

		int openCount = 0;
		int closeCount = 0;

		char[] stringArr = string.toCharArray();
		
		// Left to right
		for (int i = 0; i < stringArr.length; i++) {
			char c = stringArr[i];
			if (c == '(') {
				openCount++;
			} else if (c == ')') {
				closeCount++;
			}
			if (openCount == closeCount) {
				currentLength = closeCount * 2;
			} else if (closeCount > openCount) {
				openCount = 0;
				closeCount = 0;
			}
			if (currentLength > maxLength) {
				maxLength = currentLength;
			}

		}

		// Right to left
		closeCount = 0;
		openCount = 0;
		currentLength = 0;
		for (int i = stringArr.length - 1; i >= 0; i--) {
			char c = stringArr[i];
			if (c == '(') {
				openCount++;
			} else if (c == ')') {
				closeCount++;
			}
			if (openCount == closeCount) {
				currentLength = openCount * 2;
			} else if (closeCount < openCount) {
				openCount = 0;
				closeCount = 0;
			}
			if (currentLength > maxLength) {
				maxLength = currentLength;
			}

		}

		// Write your code here.
		return maxLength;
	}

	public static void main(String[] args) {
		String input = "())()(()())";

		int len = longestBalancedSubstring(input);
		System.out.println("Longest length = " + len);
	}

}
