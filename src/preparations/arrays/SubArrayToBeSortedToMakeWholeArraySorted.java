package preparations.arrays;


/*
  Write a function that takes in an array of at least two integers and that
  returns an array of the starting and ending indices of the smallest subarray
  in the input array that needs to be sorted in place in order for the entire
  input array to be sorted (in ascending order).
*/

public class SubArrayToBeSortedToMakeWholeArraySorted {
  private static boolean isOutOfOrder(int[] array, int i) {
		if (i == array.length-1) {
			return (array[i-1] > array[i]);
		}	
		return (array[i-1] > array[i] || array[i] > array[i+1]);
 }	
	
  public static int[] subarraySort(int[] array) {
		
			int startPoint = Integer.MAX_VALUE;
			int endPoint = Integer.MIN_VALUE;
			int minValueInSubArray = Integer.MAX_VALUE;
			int maxValueInSubArray = Integer.MIN_VALUE;

			for (int i = 1; i< array.length; i++) {
				if (isOutOfOrder(array, i)) {
					startPoint = Math.min(startPoint, i);
					endPoint = Math.max(endPoint, i);
				}
			}

			if (startPoint == Integer.MAX_VALUE) {
				return new int [] {-1, -1};
			} else if (endPoint == startPoint) {
				return new int[] {0, array.length-1};
			}
		
			for (int i=startPoint; i<=endPoint; i++) {
					maxValueInSubArray = Math.max(maxValueInSubArray, array[i]);
					minValueInSubArray = Math.min(minValueInSubArray, array[i]);
			}
			endPoint = endPoint - 1;

			int leftPointer = startPoint-1;
			while(leftPointer >= 0 && minValueInSubArray < array[leftPointer]) {
				leftPointer--;
			}
			leftPointer++;

			int rightPointer = endPoint+1;
			while(rightPointer < array.length && maxValueInSubArray > array[rightPointer]) {
				rightPointer++;
			}
			rightPointer--;


    	return new int[] {leftPointer, rightPointer};
  }
}
