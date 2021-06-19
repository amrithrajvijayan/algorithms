package misc;

public class EditDistance {

	/*
	 * Given two strings A and B, find the minimum number of steps required to
	 * convert A to B. (each operation is counted as 1 step.)
	 * 
	 * You have the following 3 operations permitted on a word:
	 * 
	 * Insert a character Delete a character Replace a character
	 * 
	 * 
	 * Input Format:
	 * 
	 * The first argument of input contains a string, A. The second argument of
	 * input contains a string, B.
	 * 
	 * Output Format:
	 * 
	 * Return an integer, representing the minimum number of steps required.
	 * 
	 * Constraints:
	 * 
	 * 1 <= length(A), length(B) <= 450
	 * 
	 * Examples:
	 * 
	 * Input 1: A = "abad" B = "abac"
	 * 
	 * Output 1: 1
	 * 
	 * Explanation 1: Operation 1: Replace d with c.
	 * 
	 * Input 2: A = "Anshuman" B = "Antihuman"
	 * 
	 * Output 2: 2
	 * 
	 * Explanation 2: => Operation 1: Replace s with t. => Operation 2: Insert i.
	 * 
	 * 
	 */   

	public int minDistance(String A, String B) {
		
		// Base Cases
		if (A==null && B ==null) {
			return 0;
		} else if (A.length() ==0) {
			return (B != null ? B.length() : 0);
		} else if (B.length() ==0) {
			return (A != null ? A.length() : 0);
		}
		
		
		int[][] results = new int[A.length() + 1][B.length() + 1];
		
		for (int i= 0; i<=A.length(); i++) {
			results[i][0] = i;
		}
		
		for (int i= 0; i<=B.length(); i++) {
			results[0][i] = i;
		}
		
		for (int i=1; i<=A.length(); i++) {
			
			for (int j=1; j<=B.length(); j++) {
				
				//System.out.println("\ni=" + i+ " j=" + j);
				if (A.charAt(i-1) == B.charAt(j-1)) {
					results[i][j] = results[i-1][j-1];
				} else {
					
					int intermediate = Math.min(results[i-1][j], results[i-1][j-1]);
					//if (j > i) {
						intermediate = Math.min(results[i][j-1], intermediate);
					//}
					results[i][j] = intermediate + 1;
					
				}
				//System.out.println("results[i][j]=" + results[i][j]);
				
			}
			
		}
		
		return results[A.length()][B.length()];
	}

	public static void main(String[] args) {
		String A = "aaa";
		String B = "aa";
		System.out.println("distance=" + new EditDistance().minDistance(A, B));
	}

}
