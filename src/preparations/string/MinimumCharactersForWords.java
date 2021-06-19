package preparations.string;
/*

Write a function that takes in an array of words and returns the smallest
array of characters needed to form all of the words. The characters don't need
to be in any particular order.


For example, the characters ["y", "r", "o", "u"] are needed to
form the words ["your", "you", "or", "yo"].


Note: the input words won't contain any spaces; however, they might contain
punctuation and/or special characters.

*/

import java.util.*;

public class MinimumCharactersForWords {

	public String[] minimumCharactersForWords(String[] words) {
		Map<Character, Integer> uniqueChars = constructUniqueCharactersMap(words);
		return convertMapToArray(uniqueChars);
	}

	private String[] convertMapToArray(Map<Character, Integer> map) {
		List<String> stringList = new ArrayList<>();

		for (Character key : map.keySet()) {
			Integer count = map.get(key);
			for (int i = 1; i <= count; i++)
				stringList.add(key.toString());
		}
		String[] charString = stringList.toArray(new String[0]);
		return charString;
	}

	private Map<Character, Integer> constructUniqueCharactersMap(String[] words) {
		Map<Character, Integer> uniqueStringCharacters = new HashMap<>();
		for (String str : words) {
			Map<Character, Integer> frequencyMap = getFrequencyMap(str);
			updateUniqueCharMap(uniqueStringCharacters, frequencyMap);
		}
		return uniqueStringCharacters;
	}

	private void updateUniqueCharMap(Map<Character, Integer> uniqueMap, Map<Character, Integer> frequencyMap) {
		for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
			uniqueMap.put(entry.getKey(), Math.max(entry.getValue(), uniqueMap.getOrDefault(entry.getKey(), 0)));
		}
	}

	private Map<Character, Integer> getFrequencyMap(String str) {
		Map<Character, Integer> freqMap = new HashMap<>();
		char[] chars = str.toCharArray();
		for (char c : chars) {
			freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
		}
		return freqMap;
	}

	public static void main(String[] args) {
		String[] arr = {"hello", "hi", "how", "are", "you"};
		System.out.println(Arrays.toString(new MinimumCharactersForWords().minimumCharactersForWords(arr)));
	}

}
