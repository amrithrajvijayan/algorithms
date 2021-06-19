package misc;

public class LongestPalindrom {
	
	
	public static String longestPalindrom(String input) {
		String retValue = "";
		for (int i=0; i<input.length(); i++) {
			String expandedString = expand(input, i);
			if (expandedString.length() > retValue.length()) {
				retValue = expandedString;
			}
		}
		
		return retValue;
	}
	
	private static String expand(String input, int index) {
		
		String string = "";
		if (index == 0 || index == input.length()-1) {
			return String.valueOf(input.charAt(index));
		}
		int left = index-1;
		int right = index+1;
		while(left >= 0 && right <=input.length()) {
			if (input.charAt(left) == input.charAt(right)) {
				left--;
				right++;
			} else if (input.charAt(left+1) == input.charAt(right) && (left+1) == index ) {
				right++;
			}
			else {
				left++;
				break;
			}
		}
		string = input.substring(left, right);
		return string;
	}
	
	
	

	public static void main(String[] args) {
		System.out.println("\nFinal answer = " + longestPalindrom("thisisatestforoflongestpalindaaabaaadnirom"));
	}

}
