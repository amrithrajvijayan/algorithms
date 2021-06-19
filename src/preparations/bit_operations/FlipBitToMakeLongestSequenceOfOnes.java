package preparations.bit_operations;

/*
You have an integer and you can flip exactly one bit from a O to a 1. 
Write code to find the length of the longest sequence of 1 s you could create.
EXAMPLE
Input: 1775 (or: 11011101111) Output: 8
*/

public class FlipBitToMakeLongestSequenceOfOnes {

	public static void main(String[] args) {
		
		int i = 1775;
		int longest = 0;
		
		
		int currentCount = 0;
		int previousCount = 0;

		while(i > 0) {
			if ((i & 1) == 1) { // check the right most bit.. if its 1, increase currentCount
				currentCount++;
			} else {
				if (previousCount == 0)  { // first zero met.. change currentCount value to previousCount;
					previousCount = currentCount;
					currentCount = 0;
				} else { // this is second consecutive zero, this is not helpful anymore
					previousCount = 0;
					currentCount = 0;
				}
			}
			longest = Math.max(longest, (previousCount + currentCount + 1));// at any time, previousCount+currentCount+1 will be the longest
			// right shift i
			i  = i >> 1;
			
		}
		
		
		
		System.out.println(longest);
	}

}
