package misc;

public class SpiralMatrix {
	
	
	
	
	private void printSpiral(int[][] matrix) {
		
		int leftEnd = 0, rightEnd = matrix[0].length - 1;
		int topEnd = 0, bottomEnd = matrix.length - 1;
		int i = leftEnd, j = topEnd;
		
		int counter = 0;
		int direction = 0;
		while(counter < (matrix.length * matrix[0].length) ) {
			
			counter++;
			System.out.println(matrix[i][j] + "      direction=" + direction + ", i=" + i + ", j=" + j + " " + leftEnd+ " " + rightEnd + " " + bottomEnd + " " + topEnd);
			if (direction == 0) {
				if (j == rightEnd) {
					direction = 1;
					rightEnd--;
					i++;
					
				} else {
					j++;
				}
			} else if (direction == 1) {
				if (i == bottomEnd) {
					bottomEnd--;
					direction = 2;
					j--;
				} else {
					i++;
				}
				
			} else if (direction == 2) {
				if (j == (leftEnd) ) {
					leftEnd++;
					direction = 3;
					i--;
				} else {
					j--;
				}
				
			} else if (direction == 3) {
				
				if (i == (topEnd+1)) {
					topEnd++;
					direction = 0;
					j++;
				} else {
					i--;
				}
				
			}
			
			
			
			
		}
		
		
	}
	
	
	public static void main(String args[]) {
		SpiralMatrix sm = new SpiralMatrix();
		
		int[][] matrix = {
				{ 1,    2 ,   3 ,  4,  5},
				{18,   19 ,  20 , 21,  6},
				{17,   28 ,  29 , 22,  7},
				{16,   27 ,  30 , 23,  8},
				{15,   26 ,  25 , 24,  9},
				{14,   13 ,  12 , 11, 10},
		};
		
		sm.printSpiral(matrix);
		
		
	}

}
