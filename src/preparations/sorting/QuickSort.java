package preparations.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void quickSort(int[] arr, int start, int end) {
		
		if (start>=end) 
			return;
		
	    int pivotIndex = start;
	    int leftIndex = start+1;
	    int rightIndex = end;
	    
	    while(rightIndex >=leftIndex) {
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
		
		quickSort(arr, rightIndex+1, end);
		quickSort(arr, start, rightIndex-1);
		
	}
	
	private static void swap(int[] array, int index1, int index2) {
		int temp = array[index2];
		array[index2] = array[index1];
		array[index1] = temp;		
	}
	
	
	
	public static void main(String[] args) {
		
		int[] arr = {6, 2, 8, 3, 5, 1, 8};

		quickSort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));

	}

}
