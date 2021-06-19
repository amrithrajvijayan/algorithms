package preparations.dynamic_programming;

import java.util.*;

public class MinimumStringSplitsBasedOnDictionary {
	private static int findMinNumberOfSpaces(String pi, Set<String> numberSet) {
		
		int[] dp = new int[pi.length()];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for (int i=0; i<pi.length(); i++) {
			for (int j=0; j<=i; j++) {
				String subString = pi.substring(j, i+1);
				if (numberSet.contains(subString)) {
					if (j==0)
						dp[i] = 0;
					else if (dp[j-1] != Integer.MAX_VALUE)
						dp[i] = Math.min(dp[j-1]+1, dp[i]);
				}
			}
		}
		
		if (dp[pi.length()-1] == Integer.MAX_VALUE)
			return -1;
		
		return dp[pi.length()-1];
	}
	
	
  public static int numbersInPi(String pi, String[] numbers) {
		
		Set<String> set = new HashSet<>();
		for (String num : numbers) {
			set.add(num);
		}
		
    return findMinNumberOfSpaces(pi, set);
  }
}
