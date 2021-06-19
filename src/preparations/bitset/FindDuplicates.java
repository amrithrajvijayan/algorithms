package preparations.bitset;
import java.util.*;

/*
Find Duplicates: You have an array with all the numbers from 1 to N, where N is at most 32,000. The
array may have duplicate entries and you do not know what N is. With only 4 kilobytes of memory
available, how would you print all duplicate elements in the array?
		*/

/*
We have 4 kilobytes of memory which means we can address up to 8 * 4 * 210 bits. Note that 32 * 210
bits is greater than 32000. We can create a bit vector with 32000 bits, where each bit represents one integer.
Using this bit vector, we can then iterate through the array, flagging each element v by setting bit v to 1.
When we come across a duplicate element, we print it.
*/
public class FindDuplicates {
	
	
	public void checkDuplicates(int[] array) {
		
		BitSet bitSet = new BitSet(32000);
		
		for (int num : array) {
			int num0 = num - 1; // bitSet is zero indexed
			if (bitSet.get(num0)) {
				System.out.println(num);
			} else {
				bitSet.set(num0);
			}
		}
		
	}
	
	
	

}
