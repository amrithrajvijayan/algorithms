package misc;
import java.util.ArrayList;

public class IncreasingPathInMatrix {
	
	
/*
	Problem Description

	Given a 2D integer matrix A of size N x M.

	From A[i][j] you can move to A[i+1][j], if A[i+1][j] > A[i][j], or can move to A[i][j+1] if A[i][j+1] > A[i][j].

	The task is to find and output the longest path length if we start from (0, 0).

	NOTE:

	If there doesn't exist a path return -1.


	Problem Constraints

	1 <= N, M <= 103

	1 <= A[i][j] <= 108



	Input Format

	First and only argument is an 2D integer matrix A of size N x M.


	Output Format

	Return a single integer denoting the length of longest path in the matrix if no such path exists return -1.


	Example Input

	Input 1:

	 A = [  [1, 2]
	        [3, 4]
	     ]

	Input 2:

	 A = [  [1, 2, 3, 4]
	        [2, 2, 3, 4]
	        [3, 2, 3, 4]
	        [4, 5, 6, 7]
	     ]



	Example Output

	Output 1:

	 3

	Output 2:

	 7



	Example Explanation

	Explanation 1:

	 Longest path is either 1 2 4 or 1 3 4.

	Explanation 2:

	 Longest path is 1 2 3 4 5 6 7.
*/	
	
	/*
    public int solve(ArrayList<ArrayList<Integer>> A) {
    	
    	
    	if (A == null || A.size() == 0) {
    		return 0;
    	}
    	
    	int columnLength = A.size();
    	int rowLength = A.get(0).size();
    	
    	int[][] resultsArray = new int[columnLength][rowLength];
    	int maxLength = 0;
    	    	
    	resultsArray[0][0] = 1;
    	
		for (int i = 0; i < A.size(); i++) {
			ArrayList<Integer> row = A.get(i);
			for (int j = 0; j < row.size(); j++) {



					if (resultsArray[i][j] != 0) {

						int valueNext = (j < rowLength -1 ? row.get(j+1) : 0);
						int valueBelow = (i < columnLength -1 ? A.get(i + 1).get(j) : 0);

						if (valueNext > row.get(j)) {
							int newValue = (valueNext == 0 ? 0 : resultsArray[i][j] + 1);
							if (newValue > resultsArray[i][j+1]) {
								resultsArray[i][j+1] = newValue;
							}
							
						}

						if (valueBelow > row.get(j)) {
							int newValue = (valueBelow == 0 ? 0 : resultsArray[i][j] + 1);
							if (newValue > resultsArray[i + 1][j]) {
								resultsArray[i + 1][j] = newValue;
							}
							
						}

						if (resultsArray[i][j] > maxLength) {
							maxLength = resultsArray[i][j];
						}
					}
				
			}
		}
    	
		if (resultsArray[columnLength-1][rowLength-1] == 0) {
			return -1;
		}
    	
    	return resultsArray[columnLength-1][rowLength-1];
    }
*/
	
	
    public int solve(ArrayList<ArrayList<Integer>> A) {
    	
    	
    	if (A == null || A.size() == 0) {
    		return 0;
    	}
    	
    	int columnLength = A.size();
    	int rowLength = A.get(0).size();
    	
    	int[] firstArray = new int[rowLength];
    	int[] secondArray = new int[rowLength];
    	    	    	
    	firstArray[0] = 1;
    	
		for (int i = 0; i < A.size(); i++) {
			ArrayList<Integer> row = A.get(i);
			for (int j = 0; j < row.size(); j++) {



					if (firstArray[j] != 0) {

						int valueNext = (j < rowLength -1 ? row.get(j+1) : 0);
						int valueBelow = (i < columnLength -1 ? A.get(i + 1).get(j) : 0);

						if (valueNext > row.get(j)) {
							int newValue = (valueNext == 0 ? 0 : firstArray[j] + 1);
							if (newValue > firstArray[j+1]) {
								firstArray[j+1] = newValue;
							}
							
						}

						if (valueBelow > row.get(j)) {
							int newValue = (valueBelow == 0 ? 0 : firstArray[j] + 1);
							if (newValue > secondArray[j]) {
								secondArray[j] = newValue;
							}
							
						}

					}
				
			}
			if (i < columnLength -1) {
			firstArray = secondArray;
			secondArray = new int[rowLength];
			}
		}
    	
		if (firstArray[rowLength-1] == 0) {
			return -1;
		}
    	
    	return firstArray[rowLength-1];
    }
    
    
    
	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
					        		
			        		
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		input.add(list1);

		
		list1 = new ArrayList<>();
		list1.add(2);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		input.add(list1);
		
		
		list1 = new ArrayList<>();
		list1.add(3);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		input.add(list1);
		
		list1 = new ArrayList<>();
		list1.add(4);
		list1.add(5);
		list1.add(6);
		list1.add(7);
		input.add(list1);
		
		

		
		
		IncreasingPathInMatrix m = new IncreasingPathInMatrix();
		System.out.println("result = " + m.solve(input));
	}

}
