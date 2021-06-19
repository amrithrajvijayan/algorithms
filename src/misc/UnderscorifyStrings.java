package misc;

import java.util.*;

public class UnderscorifyStrings {

	public static String underscorifySubstring(String str, String substring) {


		List<Integer> list = new ArrayList<>();
		Map<Integer, Boolean> map = new HashMap<>();
		for (int i=0; i<str.length(); i++) {
			int pos = str.indexOf(substring, i);
			if (pos == -1) {
				break;
			} else if (!map.containsKey(pos)) {
				list.add(pos);
				map.put(pos, true);
			}
		}
		
		int rangeStart = -1;
		int cumulativeDistance = 0;
		for (int i=0; i<list.size(); i++) {
			int currentStart = list.get(i);
			int currentEnd = (list.get(i)+substring.length());
			
			int nextStart = -1;
			if (i < list.size()-1) {
				nextStart = list.get(i+1);
			}
			if (currentEnd  >= nextStart) {
				if (rangeStart == -1)
					rangeStart = currentStart;
				if (nextStart == -1) {
					str = insertSeparator(str, cumulativeDistance, rangeStart, (currentStart+substring.length()));
				}
			} else {
				if (rangeStart == -1)
					str = insertSeparator(str, cumulativeDistance, currentStart, currentEnd);
				else 
					str = insertSeparator(str, cumulativeDistance, rangeStart, currentEnd);
				
				cumulativeDistance= cumulativeDistance + 2;
				
				rangeStart = -1;
			}
		}
		return str;
	}
	
	private static String insertSeparator(String input, int distnace, int start, int end) {
		input = input.substring(0, start+distnace) + "_" + input.substring(start+distnace, input.length());
		input = input.substring(0, end+1+distnace) + "_" + input.substring(end+1+distnace, input.length());
		
		return input;
	}

	public static void main(String[] args) {
		System.out.println(underscorifySubstring("testthis is a testtest to see if testestest it works","test"));

	}

}
