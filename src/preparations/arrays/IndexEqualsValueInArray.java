package preparations.arrays;


/*
  Write a function that takes in a sorted array of distinct integers and returns
  the first index in the array that is equal to the value at that index. In
  other words, your function should return the minimum index where
  <span>index == array[index]</span>.
*/

public class IndexEqualsValueInArray {
  public int indexEqualsValue(int[] array) {
    
		int leftIndex = 0;
		int rightIndex = array.length - 1;
		
		
		while(leftIndex <= rightIndex) {
			
			int middleIndex = (leftIndex + rightIndex) / 2;
			int middleValue = array[middleIndex];
			
			if (middleValue < middleIndex) {
				leftIndex = middleIndex + 1;
			} else if ((middleValue == middleIndex) && (middleIndex == 0)) {
				return middleIndex;
			} else if (middleValue == middleIndex && array[middleIndex -1] < (middleIndex-1)) {
				return middleIndex;
			} else {
				rightIndex = middleIndex -1 ;
			}
			
		}
		
		
		
		
		return -1;
		
  }
}
