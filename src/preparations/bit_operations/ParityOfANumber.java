package preparations.bit_operations;

public class ParityOfANumber {

	public static void main(String[] args) {
		// parity -> If total number of ones is even, its 0, if its odd, then 1

		int i = 9;
		
		int parity = 0;
		while ( i > 0) {
			if ((i & 1) == 1) {
				if (parity == 0)
					parity = 1;
				else parity = 0;
			}
			i = i >>> 1;
		}
		
		System.out.println("parity is " + parity);
	}

}
