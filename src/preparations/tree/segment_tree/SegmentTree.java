package preparations.tree.segment_tree;

import java.util.*;

public class SegmentTree {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		boolean isMinValueRequired = true;

		System.out.println("original Array  = " + Arrays.toString(arr));

		int[] segTreeMinValues = new int[7];
		Arrays.fill(segTreeMinValues, Integer.MAX_VALUE);
		// This constructs minimum value for array range
		constructTree(arr, segTreeMinValues, 0, arr.length - 1, 0, isMinValueRequired);

		System.out.println("\nSegment Tree  (min values) = " + Arrays.toString(segTreeMinValues));

		int[] segTreeSum = new int[7];
		Arrays.fill(segTreeSum, Integer.MAX_VALUE);
		isMinValueRequired = false;

		// This constructs minimum value for array range
		constructTree(arr, segTreeSum, 0, arr.length - 1, 0, isMinValueRequired);

		System.out.println("\nSegment Tree (Partial Sum) = " + Arrays.toString(segTreeSum));
		System.out.println("Range min query = " + rangeMinQuery(segTreeSum, 1, 2, 0, arr.length-1, 0));
	}	
	
	// A Segment Tree is a data structure that allows answering range queries over
	// an array effectively
	static void constructTree(int input[], int segTree[], int low, int high, int pos, boolean isMinValueRequired) {

		if (low == high) {
			segTree[pos] = input[low];
			return;
		}
		int mid = (low + high) / 2;
		constructTree(input, segTree, low, mid, 2 * pos + 1, isMinValueRequired);
		constructTree(input, segTree, mid + 1, high, 2 * pos + 2, isMinValueRequired);

		if (isMinValueRequired) {
			segTree[pos] = Math.min(segTree[2 * pos + 1], segTree[2 * pos + 2]);
		} else {
			segTree[pos] = segTree[2 * pos + 1] + segTree[2 * pos + 2];
		}

	}

	static int rangeMinQuery(int[] segTree, int queryLow, int queryHigh, int low, int high, int pos) {

		if (queryLow < low && queryHigh >= high) { // Total overlap
			return segTree[pos];
		}
		if (queryLow > high || queryHigh < low) { // no overlap
			return Integer.MAX_VALUE;
		}
		int mid = (low + high) / 2;
//		return Math.min(rangeMinQuery(segTree, queryLow, queryHigh, low, mid, 2 * pos + 1),
//				rangeMinQuery(segTree, queryLow, queryHigh, mid + 1, high, 2 * pos + 2));

		return (rangeMinQuery(segTree, queryLow, queryHigh, low, mid, 2 * pos + 1) + 
				rangeMinQuery(segTree, queryLow, queryHigh, mid + 1, high, 2 * pos + 2));
	}


}
