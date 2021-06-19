package preparations.trie;

import java.util.*;

public class Trie {

	Map<Character, Map> root;

	public Trie() {
		root = new HashMap<>();
	}

	public void insert(String str) {

		char[] chars = str.toCharArray();
		Map<Character, Map> currentMap = root;
		int index = 0;
		while (index < chars.length) {
			char c = chars[index];
			if (currentMap.containsKey(c)) {
				currentMap = currentMap.get(c);
			} else {
				currentMap.put(c, new HashMap<Character, Map>());
				currentMap = currentMap.get(c);
			}
			index++;
		}
		currentMap.put('*', null);
		return;
	}

	public boolean containsString(String str) {
		char[] chars = str.toCharArray();
		Map<Character, Map> currentMap = root;
		int index = 0;
		while (index < chars.length) {
			char c = chars[index];
			if (currentMap.containsKey(c)) {
				currentMap = currentMap.get(c);
				index++;
			} else
				return false;
		}
		if (currentMap.containsKey('*'))
			return true;

		return false;
	}

}
