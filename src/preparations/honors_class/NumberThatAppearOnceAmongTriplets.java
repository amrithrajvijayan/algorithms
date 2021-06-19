package preparations.honors_class;

public class NumberThatAppearOnceAmongTriplets {

	// Time: O(n).  Space: O(1)
	private static int findSingleInstanceElement(int[] arr) {
		
		int[] counts = new int[32]; // each element to represent the count of number of 1's in 'i' th position
		for (int a : arr) {
			for (int i=0; i<32; ++i) {
				if ((a & ( 1 << i)) != 0) { // shift 1 'i' times and then & with the number to check if that bit is 1 or 0. if 1, increment ith counter in array
					counts[i] = counts[i]+1;
				}
			}
		}
		
		int result = 0;
		for (int i=0; i<32; ++i) {
			result = result | (counts[i]%3 * (1 << i));  // counts[i] % 3 will give outstanding 1s of single number. multiply with 1 shifted i times.
		}
		
		
		return result;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 5, 3, 1, 1, 2, 2, 3, 3, 4, 4, 4};
		System.out.println("Single element is " + findSingleInstanceElement(arr));
	}

}
