package preparations.dynamic_programming;

import java.util.*;

public class MaxSumIncreasingSubsequenceArray {
  public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
    
		if (array == null || array.length == 0)
			return null;
		
		int[] sum = new int[array.length];
		int[] path = new int[array.length];
		for (int i=0; i< array.length; i++) {
			sum[i] = array[i];
		}
		Arrays.fill(path, -1);
		
		int maxSum = sum[0];
		int maxSumLocation = 0;
		for (int i=1; i<array.length; i++) {
			for (int j=0; j<i; j++) {
				if (array[j] < array[i]) {
					if (sum[j] + array[i] > sum[i]) {
						sum[i] = sum[j] + array[i];
						path[i] = j;
					}
				}
			}
			if (maxSum < sum[i]) {
				maxSum = Math.max(maxSum, sum[i]);	
				maxSumLocation = i;
			}
		}		
		
		List<Integer> elemList = new ArrayList<>();
		while(maxSumLocation >= 0) {
			elemList.add(array[maxSumLocation]);
			maxSumLocation = path[maxSumLocation];
		}
		Collections.reverse(elemList);
		
		List<Integer> maxNumList = new ArrayList<>();
		maxNumList.add(maxSum);
		
		
    return new ArrayList<List<Integer>>() {
      {
        add(maxNumList); 
        add(elemList);
      }
    };
  }
}
