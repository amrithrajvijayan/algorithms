package misc;

import java.util.ArrayList;
import java.util.List;

public class MaxRectangleInBinaryMatrix {

	/*
	 * Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle
	 * containing all ones and return its area.
	 * 
	 * Bonus if you can solve it in O(n^2) or less.
	 * 
	 * Example :
	 * 
	 * A : [ 1 1 1 0 1 1 1 0 0 ]
	 * 
	 * Output : 4
	 * 
	 * As the max area rectangle is created by the 2x2 rectangle created by (0,1),
	 * (0,2), (1,1) and (1,2)
	 * 
	 */

	public static int maximalRectangle(List<List<Integer>> A) {

		int[][] dbMatrix = new int[A.size()][A.size()];

		int maxArea = -1;

		for (int i = 0; i < A.size(); i++) {
			List<Integer> row = A.get(i);
			for (int j = 0; j < row.size(); j++) {
				
							
				if (A.get(i).get(j) == 1) {
										
					if (i == 0) {
						if (j > 0)
							dbMatrix[i][j] = dbMatrix[i][j-1] + 1;
						else dbMatrix[i][j] = 1;
						continue;
					} 
					if (j == 0) {
						if (i > 0) {
							dbMatrix[i][j] = dbMatrix[i-1][j] + 1;
						} else dbMatrix[i][j] = 1;
						continue;
					}
					
					
					if (A.get(i - 1).get(j - 1) == 0) {
						dbMatrix[i][j] = Math.max(dbMatrix[i - 1][j], dbMatrix[i][j - 1]) + 1;
					} else {
						if (dbMatrix[i - 1][j] != 0 || dbMatrix[i][j - 1] != 0) {
							dbMatrix[i][j] = dbMatrix[i - 1][j] + dbMatrix[i][j - 1] - dbMatrix[i - 1][j - 1] + 1;
						} else {
							dbMatrix[i][j] = 1;
						}
					}
					if (dbMatrix[i][j] > maxArea) {
						maxArea = dbMatrix[i][j];
					}

				}

			}
		}
		return maxArea;
	}

	private static int getArea(List<Integer> row, int start, int end) {

		if (end < 0 || start > row.size()) {
			return 0;
		}
		if (start == end) {
			return row.get(start);
		}
		int lowestHeight = Integer.MAX_VALUE;
		int lowestPos = -1;
		for (int i = start; i < end; i++) {
			if (row.get(i) < lowestHeight) {
				lowestHeight = row.get(i);
				lowestPos = i;
			}
		}

		int area = (end - start) * lowestHeight;
		int leftArea = getArea(row, start, lowestPos - 1);
		int rightArea = getArea(row, lowestPos + 1, end);

		if (area >= leftArea && area >= rightArea) {
			return area;
		} else if (leftArea >= area && leftArea >= rightArea) {
			return leftArea;
		} else {
			return rightArea;
		}
	}

	public static void main(String[] args) {

		List<List<Integer>> param = new ArrayList<List<Integer>>();
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(0);
		list1.add(0);
		list1.add(1);
		param.add(list1);

		List<Integer> list2 = new ArrayList<>();
		list2.add(0);
		list2.add(1);
		list2.add(1);
		list2.add(1);
		param.add(list2);

		List<Integer> list3 = new ArrayList<>();
		list3.add(0);
		list3.add(1);
		list3.add(1);
		list3.add(0);
		param.add(list3);

		List<Integer> list4 = new ArrayList<>();
		list4.add(1);
		list4.add(1);
		list4.add(1);
		list4.add(1);
		param.add(list4);
		
		
		
		System.out.println(maximalRectangle(param));

	}

}
