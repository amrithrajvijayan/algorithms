package preparations.string;

public class KadanesAlgorithmMaxSumSubarray {
	public static int kadanesAlgorithm(int[] array) {

		int finalMaxSum = array[0];
		int previousSum = array[0];
		for (int i = 1; i < array.length; i++) {
			int num = array[i];
			previousSum = Math.max(num, num + previousSum);
			finalMaxSum = Math.max(finalMaxSum, previousSum);
		}

		return finalMaxSum;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, -2, 3, 4, -2 };
		System.out.println("sum is " + kadanesAlgorithm(arr));

		int maxSum = arr[0];
		int preSum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if ((preSum + arr[i]) > arr[i])
				preSum = preSum + arr[i];
			else
				preSum = arr[i];
			maxSum = Math.max(maxSum, preSum);
		}

		System.out.println("maxSum is " + maxSum);

	}
}
