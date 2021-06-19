package preparations.arrays;

public class FirstDuplicateValue {

	public static int firstDuplicateValue(int[] array) {

		for (int val : array) {
			int absVal = Math.abs(val);
			if (array[absVal - 1] < 0)
				return absVal;

			array[absVal - 1] = array[absVal - 1] * -1;
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {8, 2, 4, 2, 9, 1, 3, 5, 6, 7};
		System.out.println("First Duplicate value is " + firstDuplicateValue(arr));
	}

}
