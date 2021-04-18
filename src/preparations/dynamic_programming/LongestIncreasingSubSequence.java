package preparations.dynamic_programming;

import java.util.ArrayList;
import java.util.*;

public class LongestIncreasingSubSequence {

	// Recursive LIS
	private static int recursiveLis(int[] arr, int index) {
		if (index < 0) {
			return 1;
		} 
		int count =  1;
		for (int j=0; j<index; j++) {
			int c = recursiveLis(arr, j);
			if (arr[j] < arr[index]) {
				count = Math.max(count, c+1);
			}
		}
		return count;
	}
	
	// DP LIS  O(n^2)
	private static int dpLis(int[] arr) {
		
		int[] dp = new int[arr.length+1];
		Arrays.fill(dp,  1);
		dp[0] = 0;
		int max = 0;
		for (int i=1; i<=arr.length; i++) {
			for (int j=1; j<i; j++) {
				if (arr[j-1] < arr[i-1])
					dp[i] = Math.max(dp[i], dp[j] + 1);
					max = Math.max(max,  dp[i]);
			}
		}
		return max;
	}
	
	/*
	indexes[] : At each position, the index of the element which is the last element of sequence with length = index
	sequence[]: 
		*/
	private static Integer[] efficientDp(int[] arr) {
		
		int[] indexs = new int[arr.length+1];
		int[] sequence = new int[arr.length+1];
		Arrays.fill(sequence,  -1);
		Arrays.fill(indexs,  -1);
		int length=0;
		for (int i=0; i<arr.length; i++) {
			int num = arr[i];
			int newLength = binarySearch(num, arr, indexs, 1, length);
			indexs[newLength] = i;
			sequence[i] = indexs[newLength-1];
			length = Math.max(length,  newLength);
		}
		
		return backtrack(arr, indexs, sequence, indexs[length]);
	}
	
	private static Integer[] backtrack(int[] arr, int[] indexs, int[] sequence, int index) {
		List<Integer> list = new ArrayList<>();
		
		while(index >=0) {
			list.add(arr[index]);
			index = sequence[index];
		}
		Collections.reverse(list);
		Integer[] retArray = new Integer[list.size()];
		retArray = list.toArray(retArray);
		return retArray;
	}
	
	
	
	
	
	private static int binarySearch(int  value, int[] arr, int[] indexs, int i, int j) {
		if (i>j) {
			return i;
		}
		int mid = (i+j)/2;
		if (arr[indexs[i]] < value) {
			return binarySearch(value, arr, indexs, mid+1, j);
		} else {
			return binarySearch(value, arr, indexs, i, mid-1);			
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		int[] arr = {8, 10, 2, 7, 20, 10, 22, 1, 50};
		//int[] arr = {2, 3, 1};
		//System.out.println(recursiveLis(arr, arr.length-1));
		//System.out.println(dpLis(arr));
		
		//System.out.println(Arrays.toString(efficientDp(arr)));
		System.out.println(("\nMaxCount = " + rewrittenDP(arr)));
		
	}
	
	
	private static int rewrittenDP(int[] inputs) {
		int maxCount = 0;
		
		int[] dp = new int[inputs.length+1];
		Arrays.fill(dp, 1);
		dp[0] = 0;
		int[] path = new int[inputs.length+1];
		Arrays.fill(path, -1);
		int maxCountLoc = -1;
		
		for (int i=2; i<=inputs.length; i++) {
			for (int j=1; j<i; j++) {
				if (inputs[j-1] < inputs[i-1]) {
					if (dp[i] < dp[j] + 1) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
						if (maxCount < dp[i]) {
							maxCount = Math.max(maxCount, dp[i]);
							maxCountLoc = i;
						}
						path[i] = j;
					}
				}
			}
			
		}
		//System.out.println(Arrays.toString(path));
		ArrayList<Integer> lst = new ArrayList<Integer>();
		while(maxCountLoc > 0) {
			//System.out.print(inputs[maxCountLoc-1] + " ");
			lst.add(inputs[maxCountLoc-1]);
			maxCountLoc = path[maxCountLoc];
		}
		Collections.reverse(lst);
		System.out.println(Arrays.toString(lst.toArray()));
		return maxCount;
	}
	
	
	

}
