package preparations.string;
import java.util.*;
	
/*
Given two words of equal length that are in a dictionary,write a method to transform one word 
into another word by changing only one letter at a time. The new word you get in each step must be in the dictionary.

EXAMPLE
Input: DAMP, LIKE
Output: DAMP-> LAMP-> LIMP-> LIME-> LIKE

*/

public class WordTransformer {
	
	static class WordContainer {
		String word;
		List<String> path;
		public WordContainer(String i) {
			this.word = i;
			this.path = new LinkedList<String>();
			this.path.add(i);
		}
	}
	

	public static void main(String[] args) {

		String a = "DAMP";
		String b = "LIKE";
		String[] dictArray = {"LAMP", "CAMP", "LIMP", "LIME", "MINE", "LIKE"};
		
		Set<String> dictionary = new HashSet<>();
		for (String s : dictArray) {
			dictionary.add(s);
		}
		
		WordContainer words = transform(a, b, dictionary);
		if (words != null)
			for (String s : words.path) {
				System.out.print(s + " -> ");
			}
	}

	private static WordContainer transform(String a, String b, Set<String> dictionary) {
		// using queue since we need a breadth first search
		Queue<WordContainer> queue = new LinkedList<>();
		// add the starting word
		queue.add(new WordContainer(a));
		// for marking visited words to avoid repetition
		Set<String> visited = new HashSet<>();
		while(queue.size() > 0) {
			// get the first word from the queue
			WordContainer s = queue.remove();
			// get all possible valid words with 1 letter change. This is equivalant to breadth first search.
			List<String> validPossibilities = findPossibleStrings(s.word, dictionary, visited);
			for (String vp : validPossibilities) {
				// create a new word container for each word
				WordContainer wc = new WordContainer(vp);
				// copy the path of old container into new one and add current string to the end of the list
				wc.path = new LinkedList<String>(s.path);
				wc.path.add(vp);
				// end word found.
				if (vp.equals(b)) {
					return wc;
				}
				// if not, add newly found words to the queue.
				queue.add(wc);
				// mark word as visited.
				visited.add(vp);
			}
		}
		
		
		return null;
	}
	
	// find all valid letters which are 1 letter change away from source string.
	private static List<String> findPossibleStrings(String s, Set<String> dict, Set<String> visited) {
		List<String> retList = new ArrayList<>();
		// try changing character at each position
		for (int i=0; i<s.length(); i++) {
			// try with every letter
			for (int j='A'; j<='Z';j++) {
				//generate sub string
				String sub = s.substring(0, i) + (char) j + s.substring(i+1, s.length());
				// ignore if visited.
				if (visited.contains(sub))
					continue;
				// check if its a valid string ( present in dictionary )
				if (dict.contains(sub)) {
					// match found, add to list
					retList.add(sub);
				}
			}
		}
		
		return retList;
	}

}
