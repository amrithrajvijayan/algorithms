package preparations.string;

import java.util.*;

public class UnderscorifySubstringInMasterString {
	public static String underscorifySubstring(String str, String substring) {
		// Extract all the indexes and stores it in a list.
		// capture both startIndex and endIndex
		List<Integer[]> locations = new ArrayList<>();
		int startIndex = 0;
		while (startIndex < str.length()) {
			int nextIndex = str.indexOf(substring, startIndex);
			if (nextIndex != -1) {
				locations.add(new Integer[] { nextIndex, nextIndex + substring.length() });
				startIndex = nextIndex + 1;
			} else {
				break;
			}
		}
		// merge the contents in the list based on their endIndex and next startIndex
		List<Integer[]> newLocations = new ArrayList<>();
		if (locations.size() > 0) {
			newLocations.add(locations.get(0));
			Integer[] previous = newLocations.get(0);

			for (int i = 1; i < locations.size(); i++) {
				Integer[] current = locations.get(i);
				if (current[0] <= previous[1]) {
					previous[1] = current[1];
				} else {
					newLocations.add(current);
					previous = current;
				}
			}
		}

		// underscorify
		int locationsIndex = 0;
		int stringIndex = 0;
		boolean inBetweenUnderscores = false;
		List<String> finalChars = new ArrayList<>();
		int i = 0;

		while (stringIndex < str.length() && locationsIndex < newLocations.size()) {

			if (stringIndex == newLocations.get(locationsIndex)[i]) {
				finalChars.add("_");
				inBetweenUnderscores = !inBetweenUnderscores;
				if (!inBetweenUnderscores) {
					locationsIndex++;
				}
				i = i == 1 ? 0 : 1;
			}
			finalChars.add(String.valueOf(str.charAt(stringIndex)));
			stringIndex += 1;
		}

		if (locationsIndex < newLocations.size()) {
			finalChars.add("_");
		} else if (stringIndex < str.length()) {
			finalChars.add(str.substring(stringIndex));
		}

		return String.join("", finalChars);
	}
}
