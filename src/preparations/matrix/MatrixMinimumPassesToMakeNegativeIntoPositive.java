package preparations.matrix;
import java.util.*;

/*

Write a function that takes in an integer matrix of potentially unequal height
and width and returns the minimum number of passes required to convert all
negative integers in the matrix to positive integers.



A negative integer in the matrix can only be converted to a positive integer
if one or more of its adjacent elements is positive. An adjacent element is an
element that is to the left, to the right, above, or below the current element
in the matrix. Converting a negative to a positive simply involves multiplying
it by <span>-1</span>.


Note that the <span>0</span> value is neither positive nor negative, meaning
that a <span>0</span> can't convert an adjacent negative to a positive.




A single pass through the matrix involves converting all the negative integers
that <i>can</i> be converted at a particular point in time. For example,
consider the following input matrix:
*/


public class MatrixMinimumPassesToMakeNegativeIntoPositive {

	
	
	class MatrixElement {
		int x;
		int y;
		public MatrixElement(int i, int j) {
			this.x = i;
			this.y = j;
		}
	}

  public int minimumPassesOfMatrix(int[][] matrix) {
    Queue<MatrixElement> initialPositiveElements = getPositiveElementsQueue(matrix);
		int passes = findNumberOfPasses(initialPositiveElements, matrix);
		if (checkForNegatives(matrix)) {
			return -1;
		}
    return passes;
  }
	
	private boolean checkForNegatives(int[][] matrix) {
		for (int i=0; i<matrix.length; i++) 
			for (int j=0; j<matrix[0].length; j++)
				if (matrix[i][j] < 0)
					return true;
		return false;
	}
	
	
	
	private int findNumberOfPasses(Queue<MatrixElement> queue, int[][] matrix) {
		int passes = 0;
		
		while(queue.size() > 0) {
			int size = queue.size();
			passes++;
			
			for (int i=1; i<=size; i++) {
				MatrixElement me = queue.remove();
				
				//Find neighbors
				List<MatrixElement> neighbors = findNegativeNeighbors(me, matrix);
				for (MatrixElement m : neighbors) {
					queue.add(m);
					matrix[m.x][m.y] = matrix[m.x][m.y] * -1;
				}
				
			}
		}
		
		
		return passes-1;
	}
	
	private List<MatrixElement> findNegativeNeighbors(MatrixElement me, int[][] matrix) {
		int x = me.x;
		int y = me.y;
		List<MatrixElement> list = new ArrayList<MatrixElement>();
		
		if (x > 0 && matrix[x-1][y] < 0) {
			list.add(new MatrixElement(x-1, y));
		}
		if (y > 0 && matrix[x][y-1] < 0) {
			list.add(new MatrixElement(x, y-1));
		}
		if (x < matrix.length-1 && matrix[x+1][y] < 0) {
			list.add(new MatrixElement(x+1, y));
		}
		if (y < matrix[0].length-1 && matrix[x][y+1] < 0) {
			list.add(new MatrixElement(x, y+1));
		}
		return list;
	}
	
	
	
	private Queue<MatrixElement> getPositiveElementsQueue(int[][] matrix){
		Queue<MatrixElement> queue = new LinkedList<MatrixElement>();
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				if (matrix[i][j] > 0)
					queue.add(new MatrixElement(i, j));
			}
		}
		return queue;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
