package preparations.tree.binary_search_tree;

import java.util.*;

public class DoesTwoArraysRepresentSameBSTs {

	/*
	 
	public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
		if (arrayOne.size() != arrayTwo.size())
			return false;
		else if (arrayOne.size() == 0 && arrayTwo.size() == 0)
			return true;
		else if (arrayOne.get(0) != arrayTwo.get(0))
			return false;

		List<Integer> smallOne = getSmaller(arrayOne, arrayOne.get(0));
		List<Integer> smallTwo = getSmaller(arrayTwo, arrayTwo.get(0));

		List<Integer> greaterOne = getEqualOrGreater(arrayOne, arrayOne.get(0));
		List<Integer> greaterTwo = getEqualOrGreater(arrayTwo, arrayTwo.get(0));

		return sameBsts(smallOne, smallTwo) && sameBsts(greaterOne, greaterTwo);
	}

	private static List<Integer> getSmaller(List<Integer> arr, int value) {
		List<Integer> retList = new ArrayList<>();
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(i) < value)
				retList.add(arr.get(i));
		}
		return retList;
	}

	private static List<Integer> getEqualOrGreater(List<Integer> arr, int value) {
		List<Integer> retList = new ArrayList<>();
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(i) >= value)
				retList.add(arr.get(i));
		}
		return retList;
	}

	
	*/
	
	
	public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
		return areSameBsts(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean areSameBsts(List<Integer> arrayOne, List<Integer> arrayTwo, int rootIndexOne,
			int rootIndexTwo, int minValue, int maxValue) {

		if (rootIndexOne == -1 || rootIndexTwo == -1)
			return (rootIndexOne == rootIndexTwo);

		if (arrayOne.get(rootIndexOne).intValue() != arrayTwo.get(rootIndexTwo).intValue()) {
			return false;
		}
		int leftRootIndexOne = getIndexOfFirstSmaller(arrayOne, rootIndexOne, minValue);
		int leftRootIndexTwo = getIndexOfFirstSmaller(arrayTwo, rootIndexTwo, minValue);

		int rightRootIndexOne = getIndexOfFirstBiggerOrEqual(arrayOne, rootIndexOne, maxValue);
		int rightRootIndexTwo = getIndexOfFirstBiggerOrEqual(arrayTwo, rootIndexTwo, maxValue);

		int currentValue = arrayOne.get(rootIndexOne);
		boolean leftAreSame = areSameBsts(arrayOne, arrayTwo, leftRootIndexOne, leftRootIndexTwo, minValue,
				currentValue);
		boolean rightAreSame = areSameBsts(arrayOne, arrayTwo, rightRootIndexOne, rightRootIndexTwo, currentValue,
				maxValue);

		return leftAreSame && rightAreSame;
	}

	public static int getIndexOfFirstSmaller(List<Integer> array, int startIndex, int minValue) {

		for (int i = startIndex + 1; i < array.size(); i++) {
			if (array.get(i).intValue() < array.get(startIndex).intValue() && array.get(i).intValue() >= minValue)
				return i;
		}

		return -1;
	}

	public static int getIndexOfFirstBiggerOrEqual(List<Integer> array, int startIndex, int maxValue) {
		for (int i = startIndex + 1; i < array.size(); i++) {
			if (array.get(i).intValue() >= array.get(startIndex).intValue() && array.get(i).intValue() < maxValue)
				return i;
		}
		return -1;
	}
}
