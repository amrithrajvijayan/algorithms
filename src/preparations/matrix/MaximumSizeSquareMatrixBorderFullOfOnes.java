package preparations.matrix;

public class MaximumSizeSquareMatrixBorderFullOfOnes {

	public static void main(String[] args) {
		int[][] matrix = {
				{1, 0, 0, 1, 0},
				{0, 1, 1, 1, 1},
				{0, 1, 1, 1, 1},
				{1, 1, 1, 0, 1},
				{1, 1, 1, 1, 1}
		};
		System.out.println("Maximum square size with border values 1 is (Brute force) = " + findMaxSquareWithOneValueInBordersBruteForce(matrix));
		System.out.println("Maximum square size with border values 1 is (Efficient) = " + findMaxSquareWithOneValueInBordersEfficient(matrix));
	}
	
	
	static class MatrixCell {
		int leftCount;
		int topCount;
		public MatrixCell(int i, int j) {
			this.leftCount = i;
			this.topCount = j;
		}
		
		public String toString() {
			return "(" + leftCount+","+topCount+")";
		}
	}
	
	// Time : O(n^3) with pre-calculated results
	private static int findMaxSquareWithOneValueInBordersEfficient(int[][] matrix) {

		MatrixCell[][] precalculatedResults = preCalculateCounts(matrix);
		
		for (int i=0; i<precalculatedResults.length; i++) {
			for (int j=0; j<precalculatedResults[0].length; j++) {
				System.out.print(precalculatedResults[i][j] + "\t");
			}
			System.out.println("");
		}
		
		int squareSize = calculateMaxSquareSizeOf1sEfficient(matrix, precalculatedResults);
		
		return squareSize;
	}
	
	// Time : O(n^3) 
	private static int calculateMaxSquareSizeOf1sEfficient(int[][] matrix, MatrixCell[][] calculatedResults) {
		
		int size = 0;
		
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				int probableSize = Math.min(i, j);
				while(probableSize > 0) {
					if (isSquareEfficient(calculatedResults, i, j, probableSize)) {
						size = Math.max(size, probableSize);
					}
					probableSize--;
				}
			}
		}
		return size;
	}
	
	// Checks if this is a square of 1 (border values ) in O(1) time !!
	private static boolean isSquareEfficient(MatrixCell[][] results, int currentX, int currentY, int probableSize) {
		
		MatrixCell currentCell = results[currentX][currentY];
		MatrixCell leftMostCell = results[currentX][currentY-probableSize+1];
		MatrixCell topMostCell = results[currentX-probableSize+1][currentY];
		
		if (currentCell.leftCount < probableSize 
				|| currentCell.topCount < probableSize
				|| leftMostCell.topCount < probableSize
				|| topMostCell.leftCount < probableSize)
			return false;
		
		return true;
	}
	
	
	// Time : O(n^2)
	private static MatrixCell[][] preCalculateCounts(int[][] matrix) {
		MatrixCell[][] results = new MatrixCell[matrix.length][matrix[0].length];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
			
				if (matrix[i][j] == 0)
					results[i][j] = new MatrixCell(0,0);
				else {
					MatrixCell cell = new MatrixCell(1,1);
					if (j > 0)
						cell.leftCount = cell.leftCount + results[i][j-1].leftCount;
					if (i >0)
						cell.topCount = cell.topCount + results[i-1][j].topCount;
					results[i][j] = cell;
				}
				
			}
		}
		
		return results;
	}
	
	
	

	// Time: O(n^4) 
	private static int findMaxSquareWithOneValueInBordersBruteForce(int[][] matrix) {
		
		int retValue = 0;
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				int xPos = i+1;
				int yPos = j+1;
				while(xPos < matrix.length && yPos < matrix[0].length) {
					if (isSquareBruteForce(matrix, i, j, xPos, yPos)) {
						retValue= Math.max(retValue, (xPos-i));
					}
					xPos++;
					yPos++;
				}
			}
		}

		return retValue+1;
	}

	private static boolean isSquareBruteForce(int[][] matrix, int xStart, int yStart, int xEnd, int yEnd) {
		
		for (int i=xStart; i<=xEnd; i++) {
			if (matrix[i][yStart] == 0)
				return false;
			if (matrix[i][yEnd] == 0)
				return false;
		}
		
		for (int i=yStart; i<=yEnd; i++) {
			if (matrix[xStart][i] == 0)
				return false;
			if (matrix[xEnd][i] == 0)
				return false;
		}
		
		return true;
	}

}
