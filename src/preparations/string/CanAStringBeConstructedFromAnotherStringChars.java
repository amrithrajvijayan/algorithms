package preparations.string;
import java.util.*;

/*
<p>
  You're given a string of available characters and a string representing a
  document that you need to generate. Write a function that determines if you
  can generate the document using the available characters. If you can generate
  the document, your function should return <span>true</span>; otherwise, it
  should return <span>false</span>.
</p>
  <p>
  You're only able to generate the document if the frequency of unique
  characters in the characters string is greater than or equal to the frequency
  of unique characters in the document string. For example, if you're given
  <span>characters = "abcabc"</span> and <span>document = "aabbccc"</span> you
  <b>cannot</b> generate the document because you're missing one <span>c</span>.
</p>

<p>
  The document that you need to create may contain any characters, including
  special characters, capital letters, numbers, and spaces.
</p>
*/

public class CanAStringBeConstructedFromAnotherStringChars {
	public boolean generateDocument(String characters, String document) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < characters.length(); i++) {
			Character c = characters.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for (int i = 0; i < document.length(); i++) {
			Character c = document.charAt(i);
			if (!map.containsKey(c) || map.get(c) == 0)
				return false;
			map.put(c, map.get(c) - 1);
		}

		return true;
	}
}
