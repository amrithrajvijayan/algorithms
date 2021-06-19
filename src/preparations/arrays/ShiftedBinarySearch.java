package preparations.arrays;

/*
<p>
  Write a function that takes in a sorted array of distinct integers as well as a target
  integer. The caveat is that the integers in the array have been shifted by
  some amount; in other words, they've been moved to the left or to the right by
  one or more positions. For example, <span>[1, 2, 3, 4]</span> might have
  turned into <span>[3, 4, 1, 2]</span>.
</p>

<p>
  The function should use a variation of the Binary Search algorithm to
  determine if the target integer is contained in the array and should return
  its index if it is, otherwise <span>-1</span>.
</p>
  
  
  <p>
  If you're unfamiliar with Binary Search, we recommend watching the Conceptual
  Overview section of the Binary Search question's video explanation before
  starting to code.
</p>
  
  */
public class ShiftedBinarySearch {
	public static int shiftedBinarySearch(int[] array, int target) {

		int left = 0;
		int right = array.length - 1;

		while (left <= right) {
			int middle = (left + right) / 2;
			if (array[middle] == target) {
				return middle;
			}
			if (array[left] == target || array[right] == target) {
				return (array[left] == target ? left : right);
			}
			if (array[left] <= array[middle]) {
				if (target < array[middle] && target >= array[left]) {
					right = middle - 1;
				} else {
					left = middle + 1;
				}
			} else {
				if (target > array[middle] && target <= array[right]) {
					left = middle + 1;
				} else {
					right = middle - 1;
				}
			}

		}

		return -1;
	}
}
