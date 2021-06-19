package preparations.string;
import java.util.*;

public class LongestSubstringWithoutDuplicateCharacters {
  public static String longestSubstringWithoutDuplication(String str) {
    
		Map<Character, Integer> seen = new HashMap<>();
		int startIndex = 0;
		int[] longest = new int[] {0, 1};
		for (int i=0; i<str.length(); i++) {
			
			if (seen.containsKey(str.charAt(i))) {
				startIndex = Math.max(startIndex, seen.get(str.charAt(i)) + 1);
			}
			
			if (longest[1] - longest[0] < (i - startIndex + 1))
				longest = new int[] {startIndex, i + 1};
			
			seen.put(str.charAt(i), i);
		}
		
		
    return str.substring(longest[0], longest[1]);
  }
}
