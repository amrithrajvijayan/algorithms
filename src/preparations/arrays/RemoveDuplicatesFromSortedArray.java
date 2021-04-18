package preparations.arrays;
import java.util.*;

/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
For example, Given input array nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It
 doesn't matter what you leave beyond the new length.

*/

public class RemoveDuplicatesFromSortedArray {
	
	private static int removeDuplicates(int[] arr) { 
		
		int current = 1;
		int pre = 0;
		while(current < arr.length) {
			
			if (arr[current] != arr[pre]) {
				arr[pre+1] = arr[current];
				pre++;
				current++;
			} else {
				current++;
			}
			
		}
		
		return pre;
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 3, 3, 4, 5, 5, 6, 7, 7, 7, 7, 7, 8, 8 , 8};
		int i = removeDuplicates(arr);
		Arrays.stream(arr).limit(i+1).forEach(x -> System.out.print(x + " "));
	}

}
