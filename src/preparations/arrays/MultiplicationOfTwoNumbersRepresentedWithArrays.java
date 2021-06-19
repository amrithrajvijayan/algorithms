package preparations.arrays;

import java.util.Arrays;

public class MultiplicationOfTwoNumbersRepresentedWithArrays {
	

	public static void main(String[] args) {
		int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};
        
        System.out.println("Multiplication Result = " + Arrays.toString(multiply(a, b)));
	}
	
	
	private static int[] multiply(int[] a, int[] b) {
		
	
		int[] results = new int[a.length + b.length];
		
		int resultArrayEnd = results.length-1;
		
		for (int i=a.length-1; i>=0; i--) {
			int currentUpdationPosition = resultArrayEnd;
			for (int j=b.length-1; j>=0; j--) {
				
				int multiplicationResult =  results[currentUpdationPosition] + a[i] * b[j];
				int carry = multiplicationResult/10;
				multiplicationResult = multiplicationResult % 10;
				results[currentUpdationPosition] = multiplicationResult;
				if (carry > 0)  // add carry to the previous array cell. Do not use a global carry variable
					results[currentUpdationPosition-1] = results[currentUpdationPosition-1] + carry;

				currentUpdationPosition--;
			}
			resultArrayEnd--;
		}
		return results;
	}
	

}
