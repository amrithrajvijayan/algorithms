package preparations.sorting;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] input = {4, 1, 0, 3, 30, 23, 6, 2};
		bubbleSort(input);
		System.out.println(Arrays.toString(input));
	}

	static void bubbleSort(int[] arr) {
		int n = arr.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					// swap elements
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}

			}
		}
	}
}
