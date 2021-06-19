package preparations.string;

import java.util.BitSet;

public class CheckIfStringHasRepeatingCharacters {

	// Time: O(n). Space: O(1)
	private static boolean checkRepeatingCharacter(String input) {
		
		BitSet bitSet = new BitSet(128); // for ASCII... if for ExtendedASCII, use 256
		
		for (char c : input.toCharArray()) {
			int loc = c;
			if (bitSet.get(loc)) {
				return true;
			}else {
				bitSet.set(loc);
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		
		String input = "hello WORLD";
		System.out.println("Repeating character found = " + checkRepeatingCharacter(input));
	}

}
