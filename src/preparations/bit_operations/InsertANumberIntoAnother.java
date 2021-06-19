package preparations.bit_operations;

/*
You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to insert M into N 
such that M starts at bit j and ends at bit i. You can assume that the bits j through i have 
enough space to fit all of M. That is, if M= 10011, you can assume that there are at least 5 bits between j and i. 
You would not, for example, have j = 3and i= 2, because M could not fully fit between bit 3 and bit 2.
  EXAMPLE
Input: N 10000000000, M 10011, i = 2, j 6 Output: N 10001001100

*/

public class InsertANumberIntoAnother {

	public static void main(String[] args) {
		
		int n = 32;//10000
		int m = 4; //00100
		int i = 1;
		int j = 3;
		// expected answer is 110000 (40)
		// Steps
		//1 : clear the bits i through j using a bit mask
		//2 : and the number with bit mask
		//3 : or the number with second number

		int leftMask = ~0;//all digits are 1 now
		// prepare left side of the mask
		leftMask = leftMask << (j+1);
		// right side of the mask
		int rightMask =  (1 << i) - 1;
		// create actual mask
		int mask = leftMask | rightMask;
		// clear the needed bits from n
		int n_cleared = n & mask;
		// shift m to correct position
		int m_shifted = m << i;
		
		// OR of n_cleared and m_shifted is the answer
		System.out.println(n_cleared | m_shifted);
	}

}
