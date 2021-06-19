package preparations.honors_class;

public class MaximumProductOfAllEntriesExceptOneWithoutDivision {

	// Time : O(n). Space: O(1). But uses division
	private static int findMaxProductWithDivision(int[] arr) {
		int maxProduct = 0;

		long product = 1;
		for (int a : arr) {
			product = product * a;
		}
		for (int a : arr) {
			maxProduct = (int) Math.max(maxProduct, product / a);
		}

		return maxProduct;
	}

	// Time : O(n). Space: O(n). Doesn't use division
	private static int findMaxProductWithOutDivision(int[] arr) {

		long[] leftToRightProduct = new long[arr.length];
		long[] rightToLeftProduct = new long[arr.length];

		leftToRightProduct[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			leftToRightProduct[i] = leftToRightProduct[i - 1] * arr[i];
		}

		rightToLeftProduct[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			rightToLeftProduct[i] = rightToLeftProduct[i + 1] * arr[i];
		}
		int product = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			product = (int) Math.max(product, (leftToRightProduct[i - 1] * rightToLeftProduct[i + 1]));
		}

		return product;

	}

	// Time : O(n). Space: O(1)
	private static int findMaxProductWithOutDivisionMostEfficient(int[] arr) {

		int numberOfNegatives = 0; // for keeping count of number of negative numbers
		int leastNegativeIndex = -1; // least negative value, maximum absolute value.
		int maxNegativeIndex = -1; // max negative value, min absolute value
		int minNonNegativeValueIndex = 0;
		int numberOfNonNegatives = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				numberOfNegatives++;
				if (leastNegativeIndex == -1 || arr[i] < arr[leastNegativeIndex]) {
					leastNegativeIndex = i; // update leastNegativeIndex to the minimum negative number
				}
				if (maxNegativeIndex == -1 || arr[i] > arr[maxNegativeIndex]) {
					maxNegativeIndex = i; // for maximum negative number
				}
			} else if (arr[i] < arr[minNonNegativeValueIndex]) {
				numberOfNonNegatives++;
				minNonNegativeValueIndex = i; // for minimum non negative number
			}
		}

		int idToSkip = -1;

		if (numberOfNegatives == 0) { // if there are no negative numbers, the id to skip is the minimum positive
										// number in the array.
			idToSkip = minNonNegativeValueIndex;
		} else {
			if (numberOfNonNegatives == 0) { // what if there are no positive numbers at all in the array
				if (numberOfNegatives % 2 == 0) { // if the number of negatives is even, then the result is anyway going
													// to be negative after skipping one negative number
					idToSkip = leastNegativeIndex; // so we need to remove the least negative value ( max absolute value
													// )
				} else { // if the number of negatives is odd, removing one element will make the final
							// product a positive number. in order to maximize that value, we should remove
							// the
					idToSkip = maxNegativeIndex;// negative number with maximum absolute value ( which is the maximum
												// negative index )
				}
			} else { // if the number of non negatives is more than zero
				if (numberOfNegatives % 2 == 0) { // if the number of negatives is odd, the ignore them.. they will
													// cancel out
					idToSkip = minNonNegativeValueIndex;// so the id to skip would be min non negative index.
				} else {// if number of negatives is odd.. should skip the negative number which has
						// maximum value ( min absolute value ) in order to make the product maximum
					idToSkip = leastNegativeIndex;
				}
			}
		}

		int product = 1;
		for (int i = 0; i < arr.length; i++) {
			if (i != idToSkip)
				product *= arr[i];
		}
		return product;
	}

	public static void main(String[] args) {
		int[] A = { 3, 2, -1, 4, -1, 6 };
		System.out.println("Approach 1 : " + findMaxProductWithDivision(A));
		System.out.println("Approach 2 : " + findMaxProductWithOutDivision(A));
		System.out.println("Approach 3 : " + findMaxProductWithOutDivisionMostEfficient(A));
	}

}
