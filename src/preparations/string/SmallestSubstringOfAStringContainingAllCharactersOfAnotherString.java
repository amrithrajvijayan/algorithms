package preparations.string;

import java.util.*;

public class SmallestSubstringOfAStringContainingAllCharactersOfAnotherString {
	
	public static void main(String[] args) {
		
		String bigString = "a simple example of a big string";
		String smallString = "xpe";
		
		System.out.println(new SmallestSubstringOfAStringContainingAllCharactersOfAnotherString().smallestSubstringContaining(bigString, smallString));
	}
	
	public static String smallestSubstringContaining(String bigString, String smallString) {

		Map<Character, Integer> targetCharCounts = getCharCounts(smallString);
		List<Integer> substringBounds = getSubstringBounds(bigString, targetCharCounts);

		return getStringFromBounds(bigString, substringBounds);
	}

	public static Map<Character, Integer> getCharCounts(String string) {
		Map<Character, Integer> charCounts = new HashMap<>();
		for (int i = 0; i < string.length(); i++) {
			increaseCharCount(string.charAt(i), charCounts);
		}
		return charCounts;
	}

	public static List<Integer> getSubstringBounds(String string, Map<Character, Integer> targetCharCounts) {
		List<Integer> substringBounds = new ArrayList<Integer>(Arrays.asList(0, Integer.MAX_VALUE));
		Map<Character, Integer> substringCharCounts = new HashMap<Character, Integer>();
		int numUniqueChars = targetCharCounts.size();
		int numUniqueCharsDone = 0;
		int leftIndex = 0;
		int rightIndex = 0;

		while (rightIndex < string.length()) {
			char rightChar = string.charAt(rightIndex);
			if (!targetCharCounts.containsKey(rightChar)) {
				rightIndex++;
				continue;
			}
			increaseCharCount(rightChar, substringCharCounts);
			if (substringCharCounts.get(rightChar).equals(targetCharCounts.get(rightChar))) {
				numUniqueCharsDone++;
			}

			while (numUniqueCharsDone == numUniqueChars && leftIndex <= rightIndex) {
				substringBounds = getCloserBounds(leftIndex, rightIndex, substringBounds.get(0),
						substringBounds.get(1));
				char leftChar = string.charAt(leftIndex);
				if (!targetCharCounts.containsKey(leftChar)) {
					leftIndex++;
					continue;
				}
				if (substringCharCounts.get(leftChar).equals(targetCharCounts.get(leftChar))) {
					numUniqueCharsDone--;
				}
				decreaseCharCount(leftChar, substringCharCounts);
				leftIndex++;
			}
			rightIndex++;
		}
		return substringBounds;
	}

	public static List<Integer> getCloserBounds(int idx1, int idx2, int idx3, int idx4) {
		return idx2 - idx1 < idx4 - idx3 ? new ArrayList<Integer>(Arrays.asList(idx1, idx2))
				: new ArrayList<Integer>(Arrays.asList(idx3, idx4));
	}

	public static String getStringFromBounds(String string, List<Integer> bounds) {
		int start = bounds.get(0);
		int end = bounds.get(1);
		if (end == Integer.MAX_VALUE)
			return "";
		return string.substring(start, end + 1);
	}

	public static void increaseCharCount(char c, Map<Character, Integer> charCounts) {
		if (!charCounts.containsKey(c)) {
			charCounts.put(c, 1);
		} else {
			charCounts.put(c, charCounts.get(c) + 1);
		}
	}

	public static void decreaseCharCount(char c, Map<Character, Integer> charCounts) {
		charCounts.put(c, charCounts.get(c) - 1);
	}

}
