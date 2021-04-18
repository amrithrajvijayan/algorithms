package preparations.dynamic_programming;

public class KnapSack_0_1 {

	/*
	Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
	Also given an integer C which represents knapsack capacity.
	Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

	NOTE:
	    You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).


	Problem Constraints

	1 <= N <= 103

	1 <= C <= 103

	1 <= A[i], B[i] <= 103



	Input Format

	First argument is an integer array A of size N denoting the values on N items.
	Second argument is an integer array B of size N denoting the weights on N items.
	Third argument is an integer C denoting the knapsack capacity.

	Output Format
	Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

	Example Input
	Input 1:

	 values =   [60, 100, 120]
	 weights = [10,   20,   30]
	 C = 50

	Input 2:

	 A = [10, 20, 30, 40]
	 B = [12, 13, 15, 19]
	 C = 10



	Example Output

	Output 1:

	 220

	Output 2:

	 0

*/	
	private static int knapSack(int[] weights, int[] values, int index, int capacity) {
		// Recursive approach
		/*
		if (j==0)
			return 0;
		else if (i <0) {
			return 0;
		}
		
		int sum1= knapSack(weights, values, i-1, j);
		int sum2 = 0;
		if(j>=weights[i])
			sum2 = knapSack(weights, values, i-1, j-weights[i]) + values[i];
		
		return Math.max(sum1, sum2);*/
		
		int[] dp = new int[capacity+1];
		
		for (int i=0; i<values.length; i++) {
			for (int j=capacity; j>=0; j--) {
				if (j>=weights[i]) {
					dp[j] = Math.max(
							dp[j],
							values[i] + dp[j-weights[i]]);
				}
			}
		}
		return dp[capacity];
		
	}
	
	
	public static void main(String[] args) {
		 int[] values = {60, 100, 120};
	     int[] weights = {10, 20, 30};
	     int capacity = 50;
	     System.out.println(knapSack(weights, values, weights.length-1, capacity));
	}

}
