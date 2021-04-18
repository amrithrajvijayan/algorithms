package preparations.arrays;

import java.util.Arrays;

public class RemoveAllInstancesOfAValue {

	public static void main(String[] args) {
		int[] arr = {3 ,6, 8, 3, 0, 4, 2, 9, 4, 3, 5};
		int val = 3;
		removeAllInstances(arr, val);

		System.out.println("Final array \n" + Arrays.toString(arr));
		
	}
	
	
	private static void removeAllInstances(int[] arr, int val) {
		
		int first = 0;
		int second = 0;
		
		while(second<arr.length) {
			
			while(arr[second] == val)
				second++;
			
			if (first != second) {
				arr[first] = arr[second];
			}
			
			first++;
			second++;
		}
		
		for (int i=first; i<arr.length; i++)
			arr[i] = 0;
		
		
		
	}

}
