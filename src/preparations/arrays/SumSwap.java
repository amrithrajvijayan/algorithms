package preparations.arrays;
/*
Sum Swap: Given two arrays of integers, find a pair of values (one value from each array) that you
can swap to give the two arrays the same sum.
EXAMPLE
lnput:{4, 1, 2, 1, 1, 2}and{3, 6, 3, 3}
Output: {1, 3}
*/

import java.util.Arrays;
import java.util.*;

public class SumSwap {

	public static void main(String[] args) {
		int[] B = { 4, 1, 2, 1, 1, 2 };
		int[] A = { 3, 6, 3, 3 };

		System.out.println("Elements to swap are " + Arrays.toString(getSwapNumbers(A, B)));
	}

	private static int[] getSwapNumbers(int[] a, int[] b) {
		int[] retNumbers = { 0, 0 };

		int sumA = getArraySum(a);
		int sumB = getArraySum(b);
		int diff = Math.abs(sumA - sumB);

		Set<Integer> set = new HashSet<>();
		for (int i : a) {
			set.add(i);
		}

		for (int i : b) {
			int numberToLookFor = diff - i;
			if (set.contains(numberToLookFor)) {
				retNumbers[0] = i;
				retNumbers[1] = numberToLookFor;
				break;
			}
		}

		return retNumbers;
	}

	private static int getArraySum(int[] a) {
		int sum = 0;
		for (int i : a) {
			sum += i;
		}
		return sum;
	}

}
