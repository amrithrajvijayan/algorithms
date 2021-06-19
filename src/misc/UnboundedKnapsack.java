package misc;

public class UnboundedKnapsack {

    static int unboundedKnapsack(int n, int[] arr) {
    	//return n- sum(n, n, arr.length-1, arr);
    	return (n - dp(n, arr));
    }
    private static void p(String s) {
    	//System.out.println(s);
    }
    
    private static int dp(int sum, int[] arr) {
    	
    	int[][] dp = new int[sum+1][arr.length+1];
    	for (int i=0; i<=sum; i++) {
    		dp[i][0] = i;
    	}
    	
    	for (int i=0; i<=arr.length; i++) {
    		dp[0][i] = 0;
    	}
    	
    	
    	for (int i=1; i<=sum; i++) {
    		for (int j=1; j<=arr.length; j++) {
    			

    	    	int sum1 = Integer.MAX_VALUE, 
    	    	sum2 = Integer.MAX_VALUE;
    	    	int sum3 = Integer.MAX_VALUE;
    	    	
    	    	sum1 = dp[i][j-1];
    	    	
    	    	if (j >= 1 && (arr[j-1] <= i )) {
        	    	p("arr[j-1]=" + arr[j-1]);
        	    	p("i-arr[j-1=" + (i-arr[j-1]));
    	    		sum2 = dp[i-arr[j-1]][j-1];
    	    		sum3 = dp[i-arr[j-1]][j];
    	    	}
    	    	
    	    	
    	    	int intermediateSum = Math.min(sum1,  sum2);
    			dp[i][j] = Math.min(intermediateSum, sum3);
    		}
    		
    	}
    	
    	return dp[sum][arr.length];
    }
    
    
    
    
    
    
    private static int sum(int limit, int n, int i, int[] arr) {
    	p("\nsum called with n=" + n +", i="+ i +" element is " + arr[i]);
    	if (n < 0) {
    		return n;
    	}
    	if (i == 0) {
    		p("returning first elem "+ (n - arr[i]) + " from 1");
    		if (n >= arr[i]) {
    			return n - arr[i];
    		} else return n;
    	}
    	
    	if (n > limit || n < 0) {
    		p("returning 0 from 2");
    		return n;
    	}
    	
    	int sum1 = Integer.MAX_VALUE, sum2 = Integer.MAX_VALUE;
    	int sum3 = Integer.MAX_VALUE;
    	
    	sum1 = sum(limit, n, i-1, arr);
    	p("sum1="+ sum1);
    	if (n - arr[i] >= 0) {
    		sum2 = sum(limit, n-arr[i], i-1, arr);
    		p("sum2 = " + sum2);
    	}
    	if (n >= arr[i])
    		sum3 = sum(limit, n-arr[i], i, arr);
    	
    	
    	int intermediateSum = Math.min(sum1,  sum2);
    	p("returning math.Min=" + Math.min(intermediateSum, sum3));
    	return Math.min(intermediateSum, sum3);
    }
        
	
	
	public static void main(String[] args) {
		
		int[] values = {3, 4, 4, 4, 8};
		int targetSum = 5;
		System.out.println("Final answer " + unboundedKnapsack(targetSum, values));
	}

}
