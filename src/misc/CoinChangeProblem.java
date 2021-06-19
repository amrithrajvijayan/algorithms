package misc;

import java.util.Arrays;
import java.util.List;

public class CoinChangeProblem {
	

    public static long getWays(int n, List<Long> c) {
    // Write your code here
        return dp(n, 0L, 0, c);
    	//return count(c, c.size(), n);
    }
    
    static long count( List<Long> S, int m, long n ) 
    { 
        // If n is 0 then there is 1 solution  
        // (do not include any coin) 
        if (n == 0) 
            return 1; 
          
        // If n is less than 0 then no  
        // solution exists 
        if (n < 0) 
            return 0; 
      
        // If there are no coins and n  
        // is greater than 0, then no 
        // solution exist 
        if (m <=0 && n >= 1) 
            return 0; 
      
        // count is sum of solutions (i)  
        // including S[m-1] (ii) excluding S[m-1] 
        return count( S, m - 1, n ) + 
               count( S, m, n-S.get(m-1) ); 
    } 
    

    private static long dp(int n, Long currentSum, int index, List<Long> c) {

        if (currentSum == n) {
            return 1;
        } else if (currentSum > n ) { //|| index >= c.size()) {
            return 0;
        }
        
        long localCount = 0;
        for (int i=index; i<c.size(); i++) {
            Long elem = c.get(i);

            localCount = localCount + dp( n, currentSum, i+1, c);

            long tempSum = 0;
            int multiplier = 1;
            while(tempSum <= n) {
                tempSum = currentSum + elem * multiplier;
                localCount = localCount + dp( n, tempSum, i+1, c);
                multiplier++;
            }


        }
        return localCount;        
    }
    
    
    public static void main(String[] args) {
    	Long[] arr = {1L,2L,3L};
    	System.out.println(getWays(4, Arrays.asList(arr)));
    }

}	


