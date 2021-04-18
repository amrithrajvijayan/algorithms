package preparations.dynamic_programming;
import java.util.*;

public class SubarraySum {

	
	private static int maxSumSubarrayDp(int[] arr , int index) {

		int sum = 0;
		for (int i=1; i<arr.length; i++) {
			
			if (arr[i] + arr[i-1] < arr[i-1]) {
				arr[i] = 0;
				sum = Math.max(sum ,arr[i-1]);
			} else {
				arr[i] = arr[i] + arr[i-1];
				sum = Math.max(sum, arr[i]);
			}
		}
		
		return sum;
	}
	
	public static int maxSumSubarrayIterative(int[] arr, int index, int[] result) {
		
		if (index < 0)
			return 0;
		
		int s1 = maxSumSubarrayIterative(arr, index-1, result);
		int s2 = arr[index];
		
		if (s1 > result[0]) {
			result[0] = s1;
		}
		
		if (s1 + s2 < s1)
			return 0;
		
		else return s2 + s1;
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {1, 2, -4, 3, 6, 8, -5, 3};
		      
		//int[] result = new int[1];
		//maxSumSubarrayIterative(arr, arr.length-1, result);
		//System.out.println(result[0]);
		
		int maxSum = Integer.MIN_VALUE;
		int localSum = 0;
		for (int i=0; i<arr.length; i++) {
			if (localSum + arr[i] >= localSum) {
				localSum = localSum + arr[i];
				maxSum = Math.max(maxSum, localSum);
			} else {
				localSum = 0;
			}
		}
		
		System.out.println("max sum is " + maxSum);
		
	}
}
