package misc;

import java.util.*;

public class LongestIncreasingSequence {
	
	
	public static List<Integer> longestIncreasingSubsequenceMine(int[] array){
		int[] sequences = new int[array.length];
		int[] indexes = new int[array.length+1];
		Arrays.fill(indexes,  Integer.MIN_VALUE);
		int length = 0;
		for (int i=0; i<array.length; i++) {
			int num = array[i];
			int newLength = binarySearchMine(1, length, indexes, array, num);
			indexes[newLength] = i;
			sequences[i] = indexes[newLength-1];
			length = Math.max(length, newLength);
			
		}
		return buildSequenceMine(array, sequences, indexes[length]);
	}
	

	private static List<Integer> buildSequenceMine(int[] array, int[] sequences, int index) {
		List<Integer> retList = new ArrayList<>();
		while(index != Integer.MIN_VALUE) {
			retList.add(0, array[index]);
			index = sequences[index];
		}
		return retList;
	}	
	
	private static int binarySearchMine (int start, int end, int[] indexes, int[] array, int num) {
		if (start > end) return start;
		int middle = (start+end)/2;
		if (array[indexes[middle]] > num) {
			end = middle - 1;
		} else {
			start = middle+1;
		}
		return binarySearchMine(start, end, indexes, array, num);
	}
	
/*
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

		return buildSequenceMine(array, sequences, indices[length]);
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
*/
	public static int lis(final List<Integer> A) {

		int[] results = new int[A.size() + 1];
		Arrays.fill(results, 1);
		int maxTillNow = 1;
		for (int i = 1; i < A.size(); i++) {
			int maxCount = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (A.get(j) < A.get(i)) {
					maxCount = Math.max(maxCount, results[j]);
				}
			}
			results[i] = maxCount + 1;
			maxTillNow = Math.max(maxTillNow, results[i]);
		}

		return maxTillNow;

	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list = Arrays.asList(14, 24, 18, 46, 55, 53, 82, 18, 101, 20, 78, 35, 68, 9, 16, 93, 101, 85, 81, 28, 78);

		//System.out.println(lis(list));
		//int[] arr = {14, 24, 18, 46, 55, 53, 82, 18, 101, 20, 78, 35, 68, 9, 16, 93, 101, 85, 81, 28, 78};
		int[] arr = {3, 5, 1, 6, 2};
		System.out.println(longestIncreasingSubsequenceMine(arr));

	}

}
