package misc;

import java.util.ArrayList;

public class PascalsTriangle {
	
	
	private static void generatePascals(int n) {
		
		int[] arr = new int[n+1];
		arr[0] = 1;
		arr[1] = 1;
				
		for (int i = 2; i <= n; i++) {
			
			arr[i] = 1;
			
			for (int j=i-1; j>0; j--) {
				arr[j] = arr[j] + arr[j-1];
			}			
			
		}
		
	}
	
	

	public static void main(String[] args) {
		int n = 15;
		generatePascals(n);

	}

}
