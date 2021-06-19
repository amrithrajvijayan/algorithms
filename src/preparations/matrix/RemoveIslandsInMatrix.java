package preparations.matrix;
import java.util.*;

/*
  You're given a two-dimensional array (a matrix) of potentially unequal height
  and width containing only <span>0</span>s and <span>1</span>s. The matrix
  represents a two-toned image, where each <span>1</span> represents black and
  each <span>0</span> represents white. An island is defined as any number of
  <span>1</span>s that are horizontally or vertically adjacent (but not
  diagonally adjacent) and that don't touch the border of the image. In other
  words, a group of horizontally or vertically adjacent <span>1</span>s isn't an
  island if any of those <span>1</span>s are in the first row, last row, first
  column, or last column of the input matrix.
*/

public class RemoveIslandsInMatrix {
	private void processMatrix(int[][] matrix, int i, int j) {
		if (matrix[i][j] == 0)
			return;
		else {
			List<int[]> marked = new ArrayList<>();
			boolean isSuccessful = markIslands(matrix, i, j, marked);
			if (!isSuccessful) {
				for (int[] location: marked) {
					matrix[location[0]][location[1]] = 1;
				}
			}
		}
	}
	
	private List<int[]> getNeighbors(int[][] matrix, int i, int j) {
		List<int[]> retList = new ArrayList<>();
		
		if (i > 0 && matrix[i-1][j] == 1) {
			retList.add(new int[] {i-1, j});
		}
		if (j > 0 && matrix[i][j-1] == 1) {
			retList.add(new int[] {i, j-1});
		}
		if (i < matrix.length-1 && matrix[i+1][j] == 1) {
			retList.add(new int[] {i+1, j});
		}
		if (j < matrix[0].length-1 && matrix[i][j+1] == 1) {
			retList.add(new int[] {i, j+1});
		}
		
		return retList;
	}
	
	
 	private boolean markIslands(int[][] matrix, int i, int j, List<int[]> marked) {
		
		if (i == 0 || j == 0 || i == matrix.length-1 || j == matrix[0].length-1)
			return false;
		
		List<int[]> neighbors = getNeighbors(matrix, i, j);
		matrix[i][j] = 0;
		marked.add(new int[] {i, j});
		boolean allNeighborsSafe = true;
		for (int[] neighbor : neighbors) {
			allNeighborsSafe = allNeighborsSafe && markIslands(matrix, neighbor[0], neighbor[1], marked);	
		}
		if (!allNeighborsSafe) {
			//matrix[i][j] = 1;
			return false;
		}
		return true;
	}
	
	

  public int[][] removeIslands(int[][] matrix) {
  	for (int i=1; i<matrix.length-1; i++) {
			for (int j=1; j<matrix[0].length-1; j++) {
				processMatrix(matrix, i, j);
			}
		}
		
    return matrix;
  }
}
