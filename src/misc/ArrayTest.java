package misc;

import java.util.*;

public class ArrayTest {

	
	
	
	
	public int[] mergeSortArrays(int[] input1, int[] input2) {
		
		int firstArrayIndex = 0, secondArrayIndex = 0;
		int[] returnArray = new int[input1.length + input2.length];
		int returnArrayIndex = 0;

		while(returnArrayIndex < returnArray.length) {
			
			if (input1[firstArrayIndex] < input2[secondArrayIndex]) {
				returnArray[returnArrayIndex++] = input1[firstArrayIndex];
				firstArrayIndex++;
			} else if (input1[firstArrayIndex] > input2[secondArrayIndex]){
				returnArray[returnArrayIndex++] = input2[secondArrayIndex];
				secondArrayIndex++;
			} else {
				returnArray[returnArrayIndex++] = input1[firstArrayIndex];
				returnArray[returnArrayIndex++] = input2[secondArrayIndex];
				firstArrayIndex++;
				secondArrayIndex++;
			}
			if (firstArrayIndex == input1.length) {
				for (int i = secondArrayIndex; i < input2.length; i++) {
					returnArray[returnArrayIndex++] = input2[i];
				}
			} else if (secondArrayIndex == input2.length) {
				for (int i = firstArrayIndex; i < input1.length; i++) {
					returnArray[returnArrayIndex++] = input1[i];
				}				
			}
		}
		
		
		return returnArray;
	}
	
	private void findPairsWithSum(int[] input, int sum) {
		System.out.println("Finding pair with sum = " + sum);
		if (input.length == 0) {
			return;
		}
		
		Map<Integer, Boolean> presentMap = new HashMap<>();
		for (int i=0; i< input.length; i++) {
			int currentValue = input[i];
			if (currentValue > sum) {
				continue;
			} else {
				int valueToSearch = (sum - currentValue);
				
				if (presentMap.get(valueToSearch) == null) {
					presentMap.put(currentValue, true);
				} else {
					System.out.println("Found : " + currentValue + " and " + valueToSearch);
					break;
				}
			}
			
		}
		
	}
	
	

	private void printPairs(int[] input, int sum) {
		
		
		
		
	}
	
	public static void main(String args[]) {
		
		int[] input = {0, 2, 3, 5, 6, 8, 9, 10, 11, 13, 15, 17, 20};
		
		ArrayTest at = new ArrayTest();
		at.printPairs(input, 15);
		
		
		// Merge Sort Array
		int[] input1 = {1, 4, 5, 8, 10, 14, 15, 20};
		int[] input2 = {0, 2, 3, 5, 9, 10};
		int[] mergeSorted = at.mergeSortArrays(input1, input2);
		//at.printArray("Merge Sorted Array" , mergeSorted);
		
		
		int[] input3 = {1, 3, 2, 6, 5, 8, 10, 12};
		at.findPairsWithSum(input3, 9);
		
		
		
		/*
		 * 
		 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

		 * 
		 * 
		 */
	}
	
	
	private void printArray(String message, int[] ar) {
		System.out.println(message);
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
	}
	
}
