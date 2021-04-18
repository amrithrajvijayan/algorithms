package preparations.string;
import java.util.*;

public class LongestNonrepeatingSubstring {

	public static int lengthOfLongestSubstring(String s) {
		if (s==null || s.length() ==0) {
			return 0;
		}
		int maxLength = 0;
		Map<Character, Integer> map = new HashMap<>();
		int start = 0;
		int end = 0;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, i);
				end = i;
			} else {
				int pos = map.get(c);
				if (pos < start) {
					end=i;
				} else {
					maxLength = Math.max(maxLength, end-start+1);
					start = pos+1;
				}
				map.put(c, i);
			}
		}
		maxLength = Math.max(maxLength, end-start+1);
		
		
		
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("babb"));

	}

}
