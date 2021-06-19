package preparations.arrays;


/*
  An array is said to be monotonic if its elements, from left to right, are
  entirely non-increasing or entirely non-decreasing.
*/

public class CheckIfMonotonicArray {
  public static boolean isMonotonic(int[] array) {
		if (array == null)
			return false;
		if (array.length == 0 || array.length == 1) 
			return true;
		
		
    boolean entirelyIncreasing = true;
		boolean entirelyDecreasing = true;
		
		for (int i=1; i<array.length; i++) {
			if (array[i] < array[i-1]) {
				entirelyIncreasing = false;
			}
			if (array[i] > array[i-1]) {
				entirelyDecreasing = false;
			}
		}
			
			
			
    return entirelyIncreasing || entirelyDecreasing;
  }
}
