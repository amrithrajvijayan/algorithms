package preparations.dynamic_programming;

/*
A string is said to be a child of a another string if it can be formed by deleting 0 or more characters
 from the other string. Letters cannot be rearranged. Given two strings of equal length, what's the longest string
  that can be constructed such that it is a child of both?

Example


These strings have two children with maximum length 3, ABC and ABD. They can be formed by 
eliminating either the D or C from both strings. Return . 
*/
public class CommonChildStringLength {
    static int longestLengthDP(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) 
        return 0;
        
        /*int[][] dp = new int[s1.length()+1][s2.length()+1];
        
        for (int i=1; i<=s1.length(); i++) {
            for (int j=1; j<=s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        
        return dp[s1.length()][s2.length()];*/
        
        int[] first = new int[s2.length()+1];
        int[] second = new int[s2.length()+1];
        
        for (int i=1; i<=s1.length(); i++) {
            for (int j=1; j<=s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    second[j] = first[j-1] + 1;
                } else {
                    second[j] = Math.max(first[j], second[j-1]);
                }
            }
            for (int k=0; k<=s1.length(); k++) {
                first[k] = second[k];
                second[k] = 0;
            }
        }
        
        
        return first[s2.length()];
    }
    
    static int longestLengthIterative(String s1, String s2, int i, int j) {
        
        if (i < 0 || j < 0)
            return 0;
        
        int length1 = 0;
        int length2 = 0;
        
        if (s1.charAt(i) == s2.charAt(j)) {
            length1 = longestLengthIterative(s1, s2, i-1, j-1) + 1;
        } else {
            length1 = longestLengthIterative(s1, s2, i, j-1);
            length2 = longestLengthIterative(s1, s2, i-1, j);
        }
        
        return Math.max(length1, length2);
    }

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {

        //return longestLengthIterative(s1, s2, s1.length()-1, s2.length()-1);
        return longestLengthDP(s1, s2);
    }

	public static void main(String[] args) {

	}

}
