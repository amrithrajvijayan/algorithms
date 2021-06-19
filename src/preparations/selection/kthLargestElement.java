package preparations.selection;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kthLargestElement { 

	// n log n time complexity
	private static int findKthLargestElementUsingPriorityQueue(int[] arr, int k) {
				
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return a-b;
			}
		});
		for (int i : arr) {
			pq.offer(i);
			
			if (pq.size() > k)
				pq.poll();
		}

		return pq.poll();
	}
	
	private static int findKthLargestElementUsingQuickSelect(int[] arr, int k) {
		return quickSelect(arr, k, 0, arr.length-1);
	}
	
	// O(n) on average... O(n^2) worst case
	private static int quickSelect(int[] arr, int k, int start, int end) {
		// array is zero based
		k = k -1;
		while(start <= end) {
			
			int pivotIndex = start;
			int leftIndex = start+1;
			int rightIndex = end;
			
			while(leftIndex<=rightIndex) {
		    	if (arr[leftIndex] > arr[pivotIndex] && arr[rightIndex] < arr[pivotIndex]) {
		    		swap(arr, leftIndex, rightIndex);
		    	}
		    	if (arr[leftIndex] <= arr[pivotIndex]) {
		    		leftIndex++;
		    	}
		    	if (arr[rightIndex] >= arr[pivotIndex]) {
		    		rightIndex--;
		    	}
			}
			swap(arr, rightIndex, pivotIndex);
			if (rightIndex == k) {
				return arr[rightIndex];
			}
			else if (rightIndex < k) {
				start = rightIndex+1;
			} else {
				end = rightIndex - 1;
			}
		
		}
		
		return -1;
	}
	
	
	private static void swap(int[] array, int index1, int index2) {
		int temp = array[index2];
		array[index2] = array[index1];
		array[index1] = temp;		
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = {6, 2, 8, 3, 5, 1, 18};
		int k = 2;
		
		System.out.println(findKthLargestElementUsingPriorityQueue(arr, k));
		
		//System.out.println(findKthLargestElementUsingQuickSelect(arr, k));
	}

}
