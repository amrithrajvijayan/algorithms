package preparations.string;

public class LongestCommonPrefix {

	// Write a function to find the longest common prefix string amongst an array of strings.
	
	private static String longestCommonPrefix(String[] arr) {
		
		String commonPrefix = arr[0];
		
		for (String currentString : arr) {
			
			int minLength = Math.min(commonPrefix.length(), currentString.length());
			int length = 0;
			while(length < minLength) {
				if (commonPrefix.charAt(length) != currentString.charAt(length)) {
					break;
				}
				length++;
			}
			commonPrefix = commonPrefix.substring(0, length);
			
		}
		
		return commonPrefix;
	}
	
	
	public static void main(String[] args) {
		String[] arr = {"This is common", "This is c", "This is", "This is hello", "This code is"};
		System.out.println(longestCommonPrefix(arr));
	}

}
