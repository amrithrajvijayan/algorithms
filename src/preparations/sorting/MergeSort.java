package preparations.sorting;
import java.util.*;

public class MergeSort {

	
	public static int[] mergeSort(int[] arr) {
		if (arr.length ==1 )
			return arr;
		
		int mid = (arr.length )/2;
		
		int[] firstHalf = Arrays.copyOfRange(arr, 0, mid);
		int[] secondHalf = Arrays.copyOfRange(arr, mid, arr.length);
		
		return merge(mergeSort(firstHalf), mergeSort(secondHalf));
	}
	
	private static int[] merge(int[] first, int[] second) {
		int[] mergedArray = new int[first.length+second.length];
		int i=0;
		int j=0;
		int k = 0;
		while(i < first.length && j < second.length) {
			if (first[i] <= second[j]) {
				mergedArray[k] = first[i];
				i++;
				k++;
			} else if (first[i] > second[j]) {
				mergedArray[k] = second[j];
				j++;
				k++;
			}
		}

		if (i<first.length) {
			while(i <first.length) {
				mergedArray[k] = first[i];
				i++;
				k++;
			}
		}

		if (j<second.length) {
			while(j <second.length) {
				mergedArray[k] = second[j];
				j++;
				k++;
			}
		}

		
		return mergedArray;
	}
	

	
	
	public static void main(String[] args) {
		int[] arr = {6, 2, 8, 3, 5, 1, 8};

		arr = mergeSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}

}
