package preparations.arrays;
/*
Given an array filled with letters and numbers, find the longest subarray with
an equal number of letters and numbers
*/

import java.util.*;

public class LongestSubArrayWithSameNumberOfCharactersAndNumbers {

	private static boolean isChar(char c) {
		if (Character.isDigit(c)) 
			return false;
		else 
			return true;
	}
	
	
	private static char[] findLongestSubarray(char[] input) {
		
		int[] charSum = new int[input.length+1];
		int[] numSum = new int[input.length+1];
		// record the character sum till now and number sum till now in two separate arrays
		for (int i=1; i<=input.length; i++) {
			if (isChar(input[i-1])) {
				charSum[i] = charSum[i-1] + 1;
				numSum[i] = numSum[i-1];
			} else {
				charSum[i] = charSum[i-1];
				numSum[i] = numSum[i-1] + 1;
			}
		}
		// calculate the differences between respective indexes
		int[] diff = new int[input.length];
		for (int i=1; i<=input.length; i++) {
			diff[i-1] = charSum[i] - numSum[i];
		}
		// at any point in the diff array, if the diff is same as any older diff already found, the sub array from older diff index +1 till current index
		// will be a equal count sub array. Find out the maximum range of such an equal count sub array
		
		Map<Integer, Integer> map = new HashMap<>();
		int startIndex = 0;
		int endIndex = 0;
		for (int i=0; i<diff.length; i++) {
			int currentDiff = diff[i];
			
			if (!map.containsKey(currentDiff)) {
				map.put(currentDiff, i);
			} else {
				// the current diff was already reported earlier.. check the index at which it was reported.
				// if the range is greater than already reported largest range, update the largest range to 
				// the newly found range
				if (( i - map.get(currentDiff)) > (endIndex-startIndex)) {
					startIndex = map.get(currentDiff);
					endIndex= i;
				}
				
			}
		}
		// Doing startIndex+1 since the actual range start from startIndex+1
		// Doing endIndex+1 since copyOfRange doesn't include the index passed as second parameter
		return Arrays.copyOfRange(input, startIndex+1, endIndex+1);
	}
	
	
	
	
	
	public static void main(String[] args) {
		char[] input = {'a', 'a', 'a', 'a', '1', '1', 'a', '1', '1', 'a', 'a', '1', 'a', 'a', '1', 'a','a', 'a', 'a', 'a'};
		System.out.println(Arrays.toString(findLongestSubarray(input)));
	}

}
