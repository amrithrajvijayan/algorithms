package preparations.dynamic_programming;

import java.util.*;

/*
  Given a non-empty array of integers, write a function that returns the longest
  strictly-increasing subsequence in the array.

  A subsequence of an array is a set of numbers that aren't necessarily adjacent
  in the array but that are in the same order as they appear in the array. For
  instance, the numbers <span>[1, 3, 4]</span> form a subsequence of the array
  <span>[1, 2, 3, 4]</span>, and so do the numbers <span>[2, 4]</span>. Note
  that a single number in an array and the array itself are both valid
  subsequences of the array.
*/

public class LongestIncreasingSubSequence {
	public static List<Integer> longestIncreasingSubsequence(int[] array) {
		int[] sequences = new int[array.length];
		int[] indices = new int[array.length + 1];
		Arrays.fill(indices, Integer.MIN_VALUE);

		int length = 0;
		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			int newLength = binarySearch(1, length, indices, array, num);
			sequences[i] = indices[newLength - 1];
			indices[newLength] = i;
			length = Math.max(length, newLength);
		}

		return buildSequence(array, sequences, indices[length]);
	}

	public static int binarySearch(int startIndex, int endIndex, int[] indices, int[] array, int num) {
		if (startIndex > endIndex) {
			return startIndex;
		}
		int middleIndex = (startIndex + endIndex) / 2;
		if (array[indices[middleIndex]] < num) {
			startIndex = middleIndex + 1;
		} else {
			endIndex = middleIndex - 1;
		}
		return binarySearch(startIndex, endIndex, indices, array, num);
	}

	public static List<Integer> buildSequence(int[] array, int[] sequences, int currentIndex) {
		List<Integer> sequence = new ArrayList<Integer>();
		while (currentIndex != Integer.MIN_VALUE) {
			sequence.add(0, array[currentIndex]);
			currentIndex = sequences[currentIndex];
		}
		return sequence;
	}

}
