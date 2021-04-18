package preparations.arrays;
import java.util.Arrays;

public class MaxSumSubMatrix {

	public static void main(String[] args) {
		int[][] matrix = { 
				{ 1, -2, 0, 1, 1 }, 
				{ -1, 1, 2, 0, 1 }, 
				{ 2, 0, 4, -2, 1 }, 
				{ 0, -2, -1, 0, 1 }, };

			
		int maxValue = Integer.MIN_VALUE;
		
		for (int i = 0; i < matrix.length; i++) {
			int[] columnSumsArray = new int[matrix[0].length];
			int[] partialSumsArray = new int[matrix[0].length];

			for (int j = i; j < matrix.length; j++) {
				
				for (int k = 0; k < matrix[0].length; k++) {
					columnSumsArray[k] = columnSumsArray[k] + matrix[j][k];
					if (k == 0)
						partialSumsArray[k] = columnSumsArray[k];
					else {
						int probableCurrentValue = partialSumsArray[k - 1] + columnSumsArray[k];
						
						if ( probableCurrentValue > partialSumsArray[k - 1] && probableCurrentValue > columnSumsArray[k]) {
							partialSumsArray[k] = probableCurrentValue;
						} else {
							partialSumsArray[k] = columnSumsArray[k];
						}
						maxValue = Math.max(maxValue, partialSumsArray[k]);
					}
				}
			}
		}
		System.out.println("Max sum is " + maxValue);
	}

}
