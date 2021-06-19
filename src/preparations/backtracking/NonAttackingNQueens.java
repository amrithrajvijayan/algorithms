package preparations.backtracking;

import java.util.Arrays;

public class NonAttackingNQueens {

	public static void main(String[] args) {
		int n = 7;
		findNQueenPositions(n);
	}

	private static String[][] getBoard(int n) {
		String[][] board = new String[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				board[i][j] = ".";

		return board;
	}

	private static boolean canPlace(String[][] board, int col, int row) {

		int i = 0;
		int j = 0;
		for (i = 0; i < board.length; i++) {
			if (board[row][i] == "Q") {
				// System.out.println("\ninside canPlace. row="+ row + ", col="+ col);
				// System.out.println("returning from 1");
				return false;
			}
		}

		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == "Q") {
				// System.out.println("\ninside canPlace. row="+ row + ", col="+ col);

				// System.out.println("returning from 2");
				return false;
			}
		}

		for (i = row, j = col; j >= 0 && i < board.length; j--, i++) {
			if (board[i][j] == "Q") {
				// System.out.println("\ninside canPlace. row="+ row + ", col="+ col);

				// System.out.println("returning from 3");

				return false;
			}
		}

		return true;
	}

	static int[] rowCache;
	static int[] differenceCache;;
	static int[] sumCache;

	private static void findNQueenPositions(int n) {

		rowCache = new int[n];
		differenceCache = new int[2 * n + 1];
		sumCache = new int[2 * n + 1];

		String[][] board = getBoard(n);

		int count = findPlacements(board, n, 0);

		System.out.println("count = " + count);

		return;
	}

	private static void printBoard(String[][] board) {
		int n = board.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}

	private static int findPlacements(String[][] board, int n, int col) {

		if (col == n) {
			System.out.println("-----------------------------");
			printBoard(board);
			return 1;
		}
		int count = 0;
		
		for (int row = 0; row < n; row++) {

			/*
			 * if ( (rowCache[row] != 1 && differenceCache[row-col + n + 1] != 1 &&
			 * sumCache[row + col] != 1) != canPlace(board, col, row) ) {
			 * System.out.println("\nanomaly found at row = " + row +" and col = " + col);
			 * System.out.println("rowCache[row] is " + rowCache[row]);
			 * System.out.println("differenceCache[row-col + n + 1]=" +
			 * differenceCache[row-col + n + 1]); System.out.println("sumCache[row + col]="
			 * + sumCache[row + col]);
			 * 
			 * System.out.println("\t rowCache " + Arrays.toString(rowCache));
			 * System.out.println("\t difference is " + (row-col+n+1));
			 * System.out.println("\t differenceCache " + Arrays.toString(differenceCache));
			 * System.out.println("\t sum is " + (row+col));
			 * System.out.println("\t sumCache " + Arrays.toString(sumCache));
			 * 
			 * printBoard(board); }
			 */

			if (canPlace(board, col, row)) {

				board[row][col] = "Q";
				/*
				 * rowCache[row] = 1; differenceCache[row-col+n+1] = 1; sumCache[row + col] = 1;
				 * System.out.println("\t\t updated rowCache = " + Arrays.toString(rowCache));
				 */
				count = count + findPlacements(board, n, col + 1);
			}
			board[row][col] = ".";
			/*
			 * rowCache[row]= 0; differenceCache[row-col+n+1] = 0; sumCache[row + col] = 0;
			 */

		}

		return count;
	}

}
