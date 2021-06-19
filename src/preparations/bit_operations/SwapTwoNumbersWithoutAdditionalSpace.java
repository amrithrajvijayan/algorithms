package preparations.bit_operations;

public class SwapTwoNumbersWithoutAdditionalSpace {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 5;
		
		// using difference
		a = a - b;
		b = b + a;
		a = b - a;
		System.out.println("a = " + a +", b = " + b);
		
		// using XOR
		a = 10;
		b = 5;
		
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a = " + a +", b = " + b);
		

	}

}
