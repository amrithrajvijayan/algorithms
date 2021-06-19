package misc;

public class PartitionProblem {
	
	
	public static boolean canPartitionEqually(int[] inputs) {
		int totalSum = 0;
		for (int i : inputs) {
			totalSum = totalSum + i;
		}
		if (totalSum % 2 == 1) {
			return false;
		}
		
		return canPartition(inputs, totalSum/2, inputs.length-1);
		
	}
	
	private static boolean canPartition(int[] inputs, int halfSum, int index) {
		
		if(halfSum == 0) {
			return true;
		} else if (halfSum < 0) {
			return false;
			
		} else if (index < 0) {
			return false;
		}
		
		boolean sum1 = canPartition(inputs, halfSum-inputs[index], index-1);
		boolean sum2 = inputs[index] == halfSum;
		boolean sum3 = canPartition(inputs, halfSum, index-1);

		return sum1 || sum2 || sum3;
	}
	
	/*
	
	for (int i=0; i<inputs.length; i++) {
		for (int j=1; j<=halfSum; j++) {
		
			dp[i][j] = dp[i-1][j-inputs[i-1]] || dp[0][j] || dp[i-1][j]
		
		}
	
	}
	
	*/
	
	
	public static void main(String[] args) {
		
		int[] input = {3, 1, 1, 2,2, 1};
		//int[] input = {3, 1, 6};
		System.out.println(canPartitionEqually(input));
		
	}

}
