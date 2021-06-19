package misc;

public class WordCharacterReplace {

    static String appendAndDelete(String s, String t, int k) {

        if (s.equals(t)) {
            return "Yes";
        } else if (s.length() + t.length() <=k) {
        	return "Yes";
        }
        
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i=0; i<=s.length(); i++) {
            dp[i][0] = i;
        } 
        for (int j=0; j<=t.length(); j++) {
            dp[0][j] = j;
        }

        for (int i=1; i<=s.length(); i++) {
            for (int j=1; j<=t.length(); j++) {
                if (s.charAt(i-1) == t.charAt(j-1) && i == j) {
                    if (dp[i-1][j-1] == 0) {
                        dp[i][j]  = 0;
                    } else
                        dp[i][j] = dp[i-1][j-1] + 2;
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }
        
        
        
        
        
        

        int totalCount = dp[s.length()][t.length()];
        System.out.println("totalCount=" + totalCount);
        if (totalCount == k) {
            return "Yes";
        } else if (totalCount < k){
            if ((k - totalCount) % 2 == 0)
                return "Yes";
            else if (s.length()+t.length() <= totalCount) {
                return "Yes";
            }
        }

        return "No";
    }	
	
	
	public static void main(String[] args) {
		System.out.println(appendAndDelete("aaa","a", 5));

	}

}
