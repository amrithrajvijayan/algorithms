package preparations.dynamic_programming;

import java.util.Arrays;

/*
Given a N * 2 array A where (A[i][0], A[i][1]) represents the ith pair.
In every pair, the first number is always smaller than the second number.
A pair (c, d) can follow another pair (a, b) if b < c , similarly in this way a chain of pairs can be formed.
Find the length of the longest chain subsequence which can be formed from a given set of pairs.


Problem Constraints
1 <= N <= 103
1 <= A[i][0] < A[i][1] <= 104

Input Format
First and only argument is an 2D integer array A of size N * 2 representing the N pairs.

Output Format
Return a single integer denoting the length of longest chain subsequence of pairs possible under given constraint.

Example Input
Input 1:
 A = [  [5, 24]
        [39, 60]
        [15, 28]
        [27, 40]
        [50, 90]
     ]

Input 2:
A = [   [10, 20]
        [1, 2]
     ]

Example Output
Output 1:
 3
Output 2:
 1

Example Explanation
Explanation 1:
 Longest chain that can be formed is of length 3, and the chain is [ [5, 24], [27, 40], [50, 90] ]
Explanation 2:
 Longest chain that can be formed is of length 1, and the chain is [ [1, 2] ] or [ [10, 20] ]

*/


public class ChainOfPairs {

	
	private static int chainOfPairsDp(int[][] arr) {
		int[] dp = new int[arr.length+1];
		Arrays.fill(dp, 1);
		int max = 0;
		for (int i=2; i<=arr.length; i++) {
			int maxLength = 0;
			for (int j=1; j<i; j++) {
				
				if (arr[j-1][1] < arr[i-1][0]) {
					maxLength = Math.max(maxLength, dp[j]);
				}
				
			}
			dp[i] = maxLength + 1;
			max = Math.max(max, dp[i]);
		}
		
		
		return max;
	}
	
	
	public static void main(String[] args) {

		int[][] arr = {
			  {98, 894},
			  {397, 942},
			  {70, 519},
			  {258, 456},
			  {286, 449},
			  {516, 626},
			  {370, 873},
			  {214, 224},
			  {74, 629},
			  {265, 886},
			  {708, 815},
			  {394, 770},
			  {56, 252}
		};
	
		System.out.println(chainOfPairsDp(arr));
	}
}
