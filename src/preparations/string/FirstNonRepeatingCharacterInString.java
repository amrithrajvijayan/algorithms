package preparations.string;
import java.util.*;


public class FirstNonRepeatingCharacterInString {

  public int firstNonRepeatingCharacter(String string) {
		
    Map<Character, Integer[]> map = new HashMap<>();
		char[] chars = string.toCharArray();
		for (int i=0; i<chars.length; i++) {
			Character c = chars[i];
			Integer[] countInfo = map.getOrDefault(c, new Integer[]{0,i});
			countInfo[0] = countInfo[0] + 1;
			map.put(c, countInfo);
		}		
		

		for (int i=0; i<chars.length; i++) {
			if (map.get(chars[i])[0] == 1)
				return map.get(chars[i])[1];
		}
		

		return -1;
  }
}
