package preparations.honors_class;

public class NumberThatAppearOnceAmongDuplicates {

	// Time: O(n)   Space: O(1)
	private static int findSingleInstance(int[] arr) {
		int num = 0;
		
		for (int a : arr) {
			num = num ^ a; // any number XORed with same number will give zero
		}
		
		return num;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {4, 2, 0, 99, 2, 99, 4, 3, 0};
		System.out.println("Number that appears only once is " + findSingleInstance(arr));
	}

}
