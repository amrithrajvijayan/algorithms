package preparations.bit_operations;

public class SumWithoutAddition {

	public static void main(String[] args) {
		int a = 10;
		int b = 15;
		System.out.println("Sum is " + sum(a, b));
	}
	
	
	private static int sum(int a, int b) {
		
		while(b != 0) {
			
			int sum = a ^ b;
			int carry = (a & b) << 1; 
			a = sum;
			b = carry;
		}
		
		return a;
	}
	/*
	1. Add 759 + 674, but"forget" to carry. I then get 323.
	2. Add 759 + 674 but only do the carrying, rather than the addition of each digit. I then get 1110.
	3. Add the result of the first two operations (recursively, using the same process described in step 1 and 2):
	1110 + 323 = 1433.
	Now, how would we do this in binary?
	1. If I add two binary numbers together, but forget to carry, the ith bit in the sum will be 0 only if a and b
	have the same ith bit (both 0 or both 1). This is essentially an XOR.
	2. If I add two numbers together but only carry, I will have a 1 in the ith bit of the sum only if bits i - 1 of
	a and b are both ls. This is an AND, shifted.
	3. Now, recurse until there's nothing to carry.
	*/
	

}
