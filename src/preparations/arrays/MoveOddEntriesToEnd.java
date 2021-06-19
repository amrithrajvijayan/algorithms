package preparations.arrays;

import java.util.Arrays;

// Move odd entries to the end of the array
public class MoveOddEntriesToEnd {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 71, 11, 6, 21, 8, 43, 44 };
		System.out.println(Arrays.toString(moveElements(arr)));
	}

	private static int[] moveElements(int[] arr) {

		int start = 0;
		int end = arr.length - 1;

		while (start < end) {

			if (arr[start] % 2 == 0) {
				start++;
			} else if (arr[end] % 2 == 0) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			} else {
				end--;
			}

		}
		return arr;
	}

}
