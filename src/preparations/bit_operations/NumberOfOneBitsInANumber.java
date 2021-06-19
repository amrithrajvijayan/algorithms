package preparations.bit_operations;

public class NumberOfOneBitsInANumber {

	public static void main(String[] args) {
		int i = 10; //  110
		System.out.println("Number of ones are " + findNumberOfOnes(i));
		
		// Alternate method.. doing & with n-1 will remove the last 1 in the number
		int count = 0;
		while(i > 0) {
			count++;
			i = i & (i -1 );
		}
		System.out.println("count = " + count);
	}
	
	
	private static int findNumberOfOnes(int i) {
		int count = 0;
		
		while(i >0) {
			count = count + (i & 1);
			i = i >>> 1;
		}
		
		return count;
	}

}
