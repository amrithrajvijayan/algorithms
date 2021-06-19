package preparations.arrays;

import java.util.*;

public class SortKSortedArray {
	public int[] sortKSortedArray(int[] array, int k) {
		if (k == 0)
			return array;

		int[] retArray = new int[array.length];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (int i = 0; i <= k && i < array.length; i++) {
			pq.offer(array[i]);
		}

		int index = 0;
		for (int i = k + 1; i < array.length; i++) {
			int t = pq.poll();
			retArray[index] = t;
			index++;
			pq.offer(array[i]);
		}

		while (!pq.isEmpty()) {
			retArray[index] = pq.poll();
			index++;
		}

		return retArray;
	}
}
