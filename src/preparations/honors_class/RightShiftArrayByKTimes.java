package preparations.honors_class;

import java.util.*;

public class RightShiftArrayByKTimes {

	private static int[] rotate(int[] arr, int k) {

		k = k % arr.length;

		reverse(arr, 0, arr.length - 1);
		reverse(arr, 0, k - 1);
		reverse(arr, k, arr.length - 1);
		return arr;
	}

	private static void reverse(int[] arr, int start, int end) {
		int s = start;
		int e = end;
		while (s < e) {
			int temp = arr[s];
			arr[s] = arr[e];
			arr[e] = temp;
			s++;
			e--;
		}

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int k = 12;
		System.out.println("Rotated " + Arrays.toString(rotate(arr, k)));
	}

}
