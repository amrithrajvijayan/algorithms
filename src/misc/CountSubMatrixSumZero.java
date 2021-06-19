package misc;

import java.util.ArrayList;

public class CountSubMatrixSumZero {

	/*
	 * Given a 2D matrix, find the number of non-empty sub matrices, such that the
	 * sum of the elements inside the sub matrix is equal to 0. (note: elements
	 * might be negative).
	 * 
	 * Example:
	 * 
	 * Input
	 * 
	 * -8 5 7 3 7 -8 5 -8 9
	 * 
	 * Output 2
	 * 
	 * Explanation -8 5 7 3 7 -8 5 -8 9
	 * 
	 * -8 5 7 3 7 -8 5 -8 9
	 */

	public int solve(ArrayList<ArrayList<Integer>> A) {

		if (A.size() == 0) { // || A.size() == 1) {
			return 0;
		}

		int[][] dp = new int[A.size() + 1][A.get(0).size() + 1];

		for (int i = 0; i < A.size(); i++) {
			ArrayList<Integer> row = A.get(i);
			for (int j = 0; j < row.size(); j++) {
				dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] + row.get(j) - dp[i][j];

			}
		}

		
		for (int i=0; i<dp.length; i++) {
			for (int j=0; j<dp[i].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println("");
		}
		
		
		
		int returnValue = 0;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {

				System.out.println("\ni=" + i + ", j=" + j);

				if (dp[i][j] == 0) {
					returnValue++;
					System.out.println("1.1 incrementing returnValue to " + returnValue);
				}

				/*if (i > 1 && j> 1 && (dp[i][j] - dp[i - 1][j]) == 0) {
					returnValue++;
					System.out.println("1.2 incrementing returnValue to " + returnValue);
				}

				if (j > 1 && i> 1 && (dp[i][j] - dp[i][j - 1]) == 0) {
					returnValue++;
					System.out.println("1.3 incrementing returnValue to " + returnValue);
				}*/

				int l = i;
				int m = j - 1;
				while (l >= 0 && m >= 0) {
					// System.out.println("dp[i][j]=" + dp[i][j] +", dp[i][m]=" + dp[i][m] +",
					// dp[l][j]=" + dp[l][j]+", dp[l][m]=" + dp[l][m]);
					if (!(i == 1 && m == (j - 1))) {
						if ((dp[i][j] - dp[l][m]) == 0) {
							returnValue++;
							System.out.println("2.1 incrementing returnValue to " + returnValue);
						}
					}
					// l--;
					m--;
				}

				l = i - 1;
				m = j;
				while (l >= 1 && m >= 1) {
					// System.out.println("dp[i][j]=" + dp[i][j] +", dp[i][m]=" + dp[i][m] +",
					// dp[l][j]=" + dp[l][j]+", dp[l][m]=" + dp[l][m]);
					if (!(j == 1 && l == (i - 1))) {
					if ((dp[i][j] - dp[l][m]) == 0) {
						returnValue++;
						System.out.println("2.2 incrementing returnValue to " + returnValue);
					}
					}
					l--;
					// m--;
				}

				l = i - 1;
				m = j - 1;
				while (l >= 1 && m >= 1) {
					//System.out.println("dp[i][j]=" + dp[i][j] + ", dp[i][m]=" + dp[i][m] + ", dp[l][j]=" + dp[l][j]
					//		+ ", dp[l][m]=" + dp[l][m]);
					if ((dp[i][j] - dp[i][m] - dp[l][j] + dp[l][m]) == 0) {
						returnValue++;
						System.out.println("2.3 incrementing returnValue to " + returnValue);
					}
					l--;
					m--;
				}

			}
		}

		return returnValue;
	}

	public static void main(String[] args) {
		CountSubMatrixSumZero ssz = new CountSubMatrixSumZero();

		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(-8);
		list1.add(5);
		list1.add(7);
		input.add(list1);

		list1 = new ArrayList<>();
		list1.add(3);
		list1.add(7);
		list1.add(-8);
		input.add(list1);

		list1 = new ArrayList<>();
		list1.add(5);
		list1.add(-8);
		list1.add(9);
		input.add(list1);

		//System.out.println("output="+ ssz.solve(input));  // 2

		ArrayList<ArrayList<Integer>> ls = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(-1);
		ls.add(l);

		l = new ArrayList<>();
		l.add(-1);
		l.add(1);
		ls.add(l);

		//System.out.println("output=" + ssz.solve(ls)); // 5

		// [-2, -1, 1, 2]
		ArrayList<ArrayList<Integer>> ls1 = new ArrayList<ArrayList<Integer>>();

		l = new ArrayList<>();
		l.add(-2);
		l.add(-1);
		l.add(1);
		l.add(2);
		ls1.add(l);

		//System.out.println("output="+ ssz.solve(ls1)); // 2

		
		

		ls = new ArrayList<ArrayList<Integer>>();

		l = new ArrayList<>();
		l.add(0);
		l.add(0);
		ls.add(l);

		l = new ArrayList<>();
		l.add(0);
		l.add(0);
		ls.add(l);

		//System.out.println("output=" + ssz.solve(ls)); // 9
		
		


		ls = new ArrayList<ArrayList<Integer>>();

		l = new ArrayList<>();
		l.add(0);
		l.add(0);
		l.add(0);
		ls.add(l);

		l = new ArrayList<>();
		l.add(0);
		l.add(0);
		l.add(0);
		ls.add(l);

		System.out.println("output=" + ssz.solve(ls)); // 18
		
		
	}

}
