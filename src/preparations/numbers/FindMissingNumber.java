package preparations.numbers;

public class FindMissingNumber {

	public static void main(String[] args) {
		int[] arr = {0, 1, 2};
		int localSum = 0;
		
		int xorResult = 0;
		for (int a : arr) {
			xorResult = xorResult ^ a;
			localSum = localSum + a;
		}
		int length = arr.length;
		int expectedResult = length * (length + 1)/2; // n * (n+1)/2 
		
		System.out.println("Missing number is " + (expectedResult-localSum));
		
		//alternate solution
		//System.out.println("Missing number using XOR is " + (expectedResult ^ localSum));
	}

}
