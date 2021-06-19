package misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.*;

public class ArraySumTwoNumbersToTarget {

	public static int[] findNumbers(int[] input, int target) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<input.length; i++) {
			map.put(input[i], i);
		}
		int[] retValue = {-1, -1};
		for (int i=0; i<input.length; i++) {
			if (map.containsKey(target-input[i])) {
				if (target-i != input[i]) {
					retValue[0] = i;
					retValue[1] = map.get(target-input[i]);
					break;
				}
			}
		}
		return retValue;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {2, 7, 11, 15}; 
		int target = 9;
		System.out.println(Arrays.toString(findNumbers(arr, target)));
	}

}
