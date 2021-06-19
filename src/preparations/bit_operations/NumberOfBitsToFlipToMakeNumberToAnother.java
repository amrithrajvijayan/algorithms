package preparations.bit_operations;

/*
Write a function to determine the number of bits you would need to flip to convert integer A to integer B.
EXAMPLE
Input: 29 (or: 11101), 15 (or: 01111) Output: 2
*/
public class NumberOfBitsToFlipToMakeNumberToAnother {

	public static void main(String[] args) {
		
		int num = 29;
		int target = 15;
		
		int numberWithDifferentBits = num ^ target; // XOR will have 1 only for those bits which are different
		
		//all we need is to count the number of ones in numberWithDifferentBits
		int count = 0;
		while(numberWithDifferentBits > 0) {
			count++;
			numberWithDifferentBits = numberWithDifferentBits & (numberWithDifferentBits - 1); // AND a number with (number-1) will clear least significant bit
		}
		
		System.out.println("Number of bits to be changed = " + count);
	}

}
