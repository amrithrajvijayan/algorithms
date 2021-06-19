package preparations.arrays;

import java.util.Arrays;

public class SmallestDifferenceBetweenTwoArrayElements {

	
	private static int findSmallestDifference(int[] arrA, int[] arrB) {
		
		int diff = Integer.MAX_VALUE;
		
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		
		int indexA = 0;
		int indexB = 0;
		
		while(indexA < arrA.length && indexB < arrB.length) {
			
			int newDiff = Math.abs(arrA[indexA] - arrB[indexB]);
			diff = Math.min(diff,  newDiff);
			
			if (arrA[indexA] < arrB[indexB]) {
				indexA++;
			} else if (arrA[indexA] > arrB[indexB]) {
				indexB++;
			} else {
				break;
			}
		}
		
		
		return diff;
	}
	
	
	public static void main(String[] args) {
		int[] arrA = {1, 2, 11, 15};
		int[] arrB = {4, 17, 19, 23, 127, 235};

		System.out.println("Smallest difference = " + findSmallestDifference(arrA, arrB));
	}

}
