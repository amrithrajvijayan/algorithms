package preparations.string;

/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in 
T in linear time complexity.
Note that when the count of a character C in T is N, then the count of C in minimum 
window in S should be at least N.

Example :

S = "ADOBECODEBANC"
T = "ABC"
*/
import java.util.*;

public class WindowString {

	private static boolean mapContains(Map<Character, Integer> map1, Map<Character, Integer> map2) {

		for (Character c : map1.keySet()) {

			if (!map2.containsKey(c))
				return false;
			if (map2.get(c) < map1.get(c))
				return false;
		}

		return true;
	}

	private static void updateMap(Map<Character, Integer> stringMap, Character c, boolean increment) {
		int count = stringMap.getOrDefault(c, 0);

		if (increment)
			count++;
		else
			count--;

		stringMap.put(c, count);
		return;
	}

	private static String findWindow(String string, String substring) {

		Map<Character, Integer> substringMap = new HashMap<>();
		for (int i = 0; i < substring.length(); i++) {
			char c = substring.charAt(i);
			updateMap(substringMap, c, true);
		}

		int start = 0;
		int end = 0;
		Map<Character, Integer> stringMap = new HashMap<>();
		boolean equalsFound = false;
		int windowStart = 0;
		int windowEnd = string.length();
		while (start < string.length()) {
			if (!equalsFound) {
				char c = string.charAt(end);
				updateMap(stringMap, c, true);
			}
			if (mapContains(substringMap, stringMap)) {
				equalsFound = true;
				char cc = string.charAt(start);
				updateMap(stringMap, cc, false);
				start++;
			} else {
				if (equalsFound) {
					if ((windowEnd - windowStart) > (end - start + 1)) {
						windowStart = start - 1;
						windowEnd = end + 1;
						equalsFound = false;
						end++;
					}
				} else {
					end++;
				}
				if (end >= string.length()) {
					break;
				}
			}
		}
		return string.substring(windowStart, windowEnd);
	}

	public static void main(String[] args) {
		String S = "ADOBECODEBANC";
		String T = "ABC";
		System.out.println(findWindow(S, T));
	}

}
