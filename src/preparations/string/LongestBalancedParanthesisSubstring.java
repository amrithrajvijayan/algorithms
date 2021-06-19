package preparations.string;

public class LongestBalancedParanthesisSubstring {
  public int longestBalancedSubstring(String string) {
    
		if (string == null || string.length() <=1)
			return 0;
		
		char[] chars = string.toCharArray();
		int maxCount = 0;
		int openCount = 0;
		int closeCount = 0;
		
		for (int i=0; i<chars.length; i++) {
			if (chars[i] == '(')
				openCount++;
			else if (chars[i] == ')')
				closeCount++;
			
			if (openCount == closeCount) {
				maxCount = Math.max(maxCount, openCount*2);
			} else if (closeCount > openCount) {
				closeCount = 0;
				openCount = 0;
			}
		}
		
		openCount = 0;
		closeCount = 0;
		for (int i=chars.length-1; i>=0; i--) {
			if (chars[i] == '(')
				openCount++;
			else if (chars[i] == ')')
				closeCount++;
			
			if (openCount == closeCount) {
				maxCount = Math.max(maxCount, openCount*2);
			} else if (openCount > closeCount) {
				closeCount = 0;
				openCount = 0;
			}
		}		
		
    return maxCount;
  }
}
