package preparations.dynamic_programming;

public class NthUglyNumber {

	/*
	Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
	1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
	shows the first 11 ugly numbers. By convention, 1 is included.
	Write a program to find and print the 150′th ugly number.
	*/
	
	
	private static boolean isUgly(int i) {
		while(i%2 == 0) {
			i = i/2;
		}
		while(i%3 == 0) {
			i = i/3;
		}
		while(i%5 == 0) {
			i = i/5;
		}
		if (i==1) return true;
		else return false;
	}
	
	private static int findUglyNumberRecursive(int n) {
		
		int count = 1;
		int i = 1;
		while (count < n) {
			i++;
			if (isUgly(i)) {
				count++;
			}
		}
		return i;
	}
	
	private static int findUglyNumberDP(int i) {
		
		int[] dp = new int[i];
		dp[0] = 1;
		
		int nextMultipleOf2= Integer.MAX_VALUE;
		int nextMultipleOf3 = Integer.MAX_VALUE;
		int nextMultipleOf5 = Integer.MAX_VALUE;
		int i2=0;
		int i3=0;
		int i5=0;
		int count = 1;
		
		while(count <i) {
			
			nextMultipleOf2 = dp[i2] * 2;
			nextMultipleOf3 = dp[i3] * 3;
			nextMultipleOf5 = dp[i5] * 5;
			
			int nextValue = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
			dp[count]= nextValue;
			
			if (nextValue == nextMultipleOf2) {
				i2=i2+1;
				nextMultipleOf2 = dp[i2] * 2; 
			} 
			if (nextValue == nextMultipleOf3) {
				i3=i3+1;
				nextMultipleOf3 = dp[i3] * 3; 
			} 
			if (nextValue == nextMultipleOf5) {
				i5=i5+1;
				nextMultipleOf5 = dp[i5] * 5; 
			}
			count++;
		}
		
		
		
		return dp[i-1];
		
	}
	
	
	
	public static void main(String[] args) {
		int n = 150;
		//System.out.println(n +"th ugly number is " + findUglyNumberRecursive(n));
		System.out.println(n +"th ugly number is " + findUglyNumberDP(n));
	}

}
