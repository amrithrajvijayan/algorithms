package preparations.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class CheckWordsInDictionary {
	
	private static String[] filterStrings(String[] dict, String[] searchStrings) {
		
		Trie trie = new Trie();
		
		for (String d : dict) {
			trie.insert(d);
		}
		
		List<String> retList = new ArrayList<String>();
		for (String s : searchStrings) {
			if (trie.containsString(s)) 
				retList.add(s);
		}
		
		return retList.toArray(new String[0]);
	}
	

	public static void main(String[] args) {
		String[] dict = {"hello", "amazing", "world", "target", "hi", "how", "you", "test", "book", "january", "jar"};
		String[] searchStrings = {"target", "moon", "world", "earth", "yo"};
		
		System.out.println("valid strings are = " + Arrays.toString(filterStrings(dict, searchStrings)));
	}

}
