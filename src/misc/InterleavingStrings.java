package misc;

public class InterleavingStrings {
	

/*
Given A, B, C, find whether C is formed by the interleaving of A and B.

Input Format:*

The first argument of input contains a string, A.
The second argument of input contains a string, B.
The third argument of input contains a string, C.

Output Format:

Return an integer, 0 or 1:
    => 0 : False
    => 1 : True

Constraints:

1 <= length(A), length(B), length(C) <= 150

Examples:

Input 1:
    A = "aabcc"
    B = "dbbca"
    C = "aadbbcbcac"

Output 1:
    1
    
Explanation 1:
    "aa" (from A) + "dbbc" (from B) + "bc" (from A) + "a" (from B) + "c" (from A)

Input 2:
    A = "aabcc"
    B = "dbbca"
    C = "aadbbbaccc"

Output 2:
    0

Explanation 2:
    It is not possible to get C by interleaving A and B.

*/	
	
    public int isInterleave(String A, String B, String C) {
    	

        if (A==null || B==null) {
            return 0;
        }
        if (A.length() + B.length() != C.length()) {
            return 0;
        }
        
        boolean[][] dp = new boolean[A.length()+1][B.length()+1];
        dp[0][0] = true;

        for (int i=0;i<=A.length(); i++) {
            for (int j=0; j<=B.length(); j++) {
                

                if (i != 0 && j != 0 && A.charAt(i - 1) == C.charAt(i + j - 1)
                        && B.charAt(j - 1) == C.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
                else if (i != 0 && A.charAt(i - 1) == C.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                }
                else if (j !=0 && B.charAt(j - 1) == C.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j - 1];
                }                

                
            }
        }
        
        
        
        
        
        return (dp[A.length()][B.length()] ? 1 : 0);     
    }

    public static void main(String args[]) {
        String A = "aabcc";
        String B = "dbbca";
        String C = "aadbbcbcac";
        System.out.println(new InterleavingStrings().isInterleave(A,B,C));
    }

}
