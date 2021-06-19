package preparations.arrays;

import java.util.*;

public class LongestRangeOfContinuousNumbersInArray {
	
	
/*
  Write a function that takes in an array of integers and returns an array of
  length 2 representing the largest range of integers contained in that array.

  The first number in the output array should be the first number in the range,
  while the second number should be the last number in the range.
  

  A range of numbers is defined as a set of numbers that come right after each
  other in the set of real integers. For instance, the output array
  <span>[2, 6]</span> represents the range <span>{2, 3, 4, 5, 6}</span>, which
  is a range of length 5. Note that numbers don't need to be sorted or adjacent
  in the input array in order to form a range.
  
*/	

	public static int[] largestRange(int[] array) {

		Map<Integer, Boolean> values = new HashMap<>();
		for (int i : array) {
			values.put(i, true);
		}
		int[] bestRange = new int[2];
		int longestLength = 0;

		for (int num : array) {

			if (values.get(num) == false) {
				continue;
			}
			values.put(num, false);
			int left = num - 1;
			int right = num + 1;
			int currentLength = 1;
			while (values.containsKey(left)) {
				values.put(left, false);
				left--;
				currentLength++;
			}
			while (values.containsKey(right)) {
				values.put(right, false);
				currentLength++;
				right++;
			}
			if (currentLength > longestLength) {
				longestLength = currentLength;
				bestRange = new int[] { left + 1, right - 1 };
			}

		}

		return bestRange;
	}
}
