package preparations.random_number;

import java.util.Arrays;
import java.util.Random;

public class RandomSubsetOfArray {
	
	
	private static int[] generateRandomSubArray(int[] arr, int k) {
		int[] retArray = new int[k];
		Random rand = new Random();
		int seed = arr.length;
		
		for (int i=1; i<=k; i++) {
			int n = rand.nextInt(seed);
			retArray[i-1] = arr[n];
			int temp = arr[n];
			arr[n] = arr[seed-1];
			arr[seed-1] = temp;
			seed--;
		}
		
		return retArray;
	}

	public static void main(String[] args) {

		int arr[] = {32, 5, 70, 2, 45, 87, 3, 9, 4, 84, 23, 33, 16};
		int k = 4;
		System.out.println("Random subset is " + Arrays.toString(generateRandomSubArray(arr, k)));
	}

}
