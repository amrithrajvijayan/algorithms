package preparations.backtracking;
// The time complexity of this problem is n! 
// n * (n-2) * (n-4) * (n-6) ....etc

/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

N Queens: Example 1

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a 
queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

public class NQueens {

	private static boolean canPlace(String[][] board, int col, int row) {

		int i = 0;
		int j = 0;
		for (i = 0; i < board.length; i++) {
			if (board[row][i] == "Q") {
				return false;
			}
		}

		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == "Q") {
				return false;
			}
		}

		for (i = row, j = col; j >= 0 && i < board.length; j--, i++) {
			if (board[i][j] == "Q") {
				return false;
			}
		}

		return true;
	}

	private static boolean placeQueens(String[][] board, int n, int col) {

		if (col == n)
			return true;

		for (int i = 0; i < n; i++) {

			if (canPlace(board, col, i)) {
				board[i][col] = "Q";
				if (placeQueens(board, n, col + 1))
					return true;
				// backtrack
				board[i][col] = ".";
			}
		}
		return false;
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

	public static void main(String[] args) {
		int n = 10;
		solveNQueens(n);
	}
	
	private static void solveNQueens(int n) {
		String[][] board = new String[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				board[i][j] = ".";

		// placeQueens(board, n, 0); // O(n^3)

		differenceArray = new int[2 * n];
		sumArray = new int[2 * n];
		rowsArray = new int[n];

		System.out.println(System.currentTimeMillis());
		placeQueens(board, n, 0); // O(n^3)
		placeQueensEfficiently(board, n, 0); // O(n^2)
		System.out.println(System.currentTimeMillis());

		printBoard(board);	
	}
	

	static int[] differenceArray;
	static int[] sumArray;
	static int[] rowsArray;

	private static boolean placeQueensEfficiently(String[][] board, int n, int col) {

		if (col == n)
			return true;

		for (int i = 0; i < n; i++) {
			// all right side diagonals will have i+j constant.. all left side diagonals have i-j constant. An additional rowsArray for 
			// recording a queen put to a row.
			// this will essentially reduce complexity from n^3 to n^2 compared with other solution above ('placeQueens()')
			// +n-1 is required to make the index non negative.
			if (differenceArray[i - col + n - 1] != 1 && sumArray[i + col] != 1 && rowsArray[i] != 1) {

				board[i][col] = "Q";
				differenceArray[i - col + n - 1] = 1;
				sumArray[i + col] = 1;
				rowsArray[i] = 1;

				if (placeQueensEfficiently(board, n, col + 1))
					return true;
				// backtrack
				board[i][col] = ".";

				differenceArray[i - col + n - 1] = 0;
				sumArray[i + col] = 0;
				rowsArray[i] = 0;
				
			}

		}
		return false;
	}

}
