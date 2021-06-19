package preparations.sorting;

// Kth smallest element in linear time on average

public class QuickSelect {
  public static int quickselect(int[] array, int k) {
    int position = k-1;
    return quickselect(array, 0, array.length -1, position);
  }
	
	public static int quickselect(int[] array, int startIndex, int endIndex, int position) {
		
		while(true) {
			int pivotIndex = startIndex;
			int leftIndex = startIndex+1;
			int rightIndex = endIndex;
			
				while(leftIndex <= rightIndex) {

					if (array[leftIndex] > array[pivotIndex] && array[rightIndex] < array[pivotIndex]) {
						swap(leftIndex, rightIndex, array);
					}
					if (array[leftIndex] <= array[pivotIndex]) {
						leftIndex++;
					}
					if (array[rightIndex] >= array[pivotIndex]) {
						rightIndex--;
					}
				}
				swap(pivotIndex, rightIndex, array);
				if (rightIndex == position) {
					return array[rightIndex];
				} else if (rightIndex < position) {
					startIndex = rightIndex + 1;
				} else {
					endIndex = rightIndex - 1;
				}
			}
		}
		
		public static void swap(int i, int j, int[] array) {
			int temp = array[j];
			array[j] = array[i];
			array[i] = temp;
		}
		
}
