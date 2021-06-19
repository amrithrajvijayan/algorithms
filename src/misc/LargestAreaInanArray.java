package misc;

import java.util.Arrays;

public class LargestAreaInanArray {
	
	
	
	
	
	public static void main(String[] s) {
		LargestAreaInanArray la = new LargestAreaInanArray();
		
		int[][] input = {
				{1, 0, 1, 0, 0, 1},
				{1, 0, 0, 1, 0, 1},
				{1, 0, 1, 1, 0, 1},
				{1, 0, 1, 1, 1, 1},
				{0, 0, 1, 1, 1, 1},				
				{0, 0, 1, 0, 0, 1}				
		};
		
		la.findLargestArea(input.clone());
	}

	
	
	
	
	
	
	
	
	
	
	private void findLargestArea(int[][] arr) {

		
		for (int k =0; k < arr.length; k++) {
			for (int i=0; i < arr[k].length; i++) {
				if(arr[k][i] == 1 && k>0) {
					arr[k][i] = arr[k][i] + arr[k-1][i];
				}
			}
		}		
		
		
		for (int k =0; k < arr.length; k++) {
			for (int i=0; i < arr[k].length; i++) {
				System.out.print(arr[k][i] + " ");
			}
			System.out.println("");
		}		
	}

}











