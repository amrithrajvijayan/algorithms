package preparations.sorting;

import java.util.*;

public class RadixSort {

	public ArrayList<Integer> radixSort(ArrayList<Integer> array) {

		if (array.size() == 0) {
			return array;
		}

		int maxNumber = Collections.max(array);

		int digit = 0;
		// Perform counting sort for each digits of the numbers starting from 0.
		while ((maxNumber) / Math.pow(10, digit) > 0) {
			countingSort(array, digit);
			digit = digit + 1;
		}

		return array;
	}

	public void countingSort(ArrayList<Integer> array, int digit) {

		int[] sortedArray = new int[array.size()];
		int[] countArray = new int[10];

		int digitColumn = (int) Math.pow(10, digit);
		// record the count of numbers at digit position.
		for (int num : array) {
			int countIndex = (num / digitColumn) % 10;
			countArray[countIndex] += 1;
		}
		// prefill with sum of nearby numbers
		for (int index = 1; index < 10; index++) {
			countArray[index] = countArray[index] + countArray[index - 1];
		}
		// For each number, get the digit at the 'digit' position, find its count in
		// counts array.
		// reduce counts array by one. go to the corresponding position in sortedArray
		// and place the element there
		for (int index = array.size() - 1; index > -1; index--) {
			int countIndex = (array.get(index) / digitColumn) % 10;
			countArray[countIndex] -= 1;
			int sortedIndex = countArray[countIndex];
			sortedArray[sortedIndex] = array.get(index);
		}
		// copy sorted array contents to original array.
		for (int index = 0; index < array.size(); index++) {
			array.set(index, sortedArray[index]);
		}

	}

}
