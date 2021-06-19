package preparations.honors_class;

import java.util.*;

/*
Write a program which takes as input a 2D array A of 1s and 0s, where the 0s encode the positions of rooks 
on an n X m chessboard. Update the array to contain Os at all locations 
which can be attacked by rooks
*/

public class RooksAttackInChessBoard {

	// Time: O(nm). Space: O(1)
	private static void markAttackedCells(List<List<Integer>> board) {

		int m = board.size();
		int n = board.get(0).size();

		boolean hasRookInFirstRow = false;
		boolean hasRookInFirstColumn = false;
		// Check if rook is present in first column.. This is because we are going to
		// use first row and first column
		// for storing the presence of rooks.. so current values in first row and first
		// column are going to be lost.
		for (int i = 0; i < m; i++) {
			if (board.get(i).get(0) == 0) {
				hasRookInFirstColumn = true;
				break;
			}
		}
		// check if rook is present in first row
		for (int i = 0; i < n; i++) {
			if (board.get(0).get(i) == 0) {
				hasRookInFirstRow = true;
				break;
			}
		}

		// iterate through each element in the board, if a rook found ( value 0), mark
		// the first column cell and first row cell with zero )
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (board.get(i).get(j) == 0) {
					board.get(i).set(0, 0);
					board.get(0).set(j, 0);
				}
			}
		}
		// iterate again.. if the first value of a row is zero, the whole row should be
		// zero
		for (int i = 1; i < m; i++)
			if (board.get(i).get(0) == 0)
				Collections.fill(board.get(i), 0);

		// rows are done..need to take care of columns..Collection.fill cannot be done
		// for columns
		for (int j = 1; j < n; j++)
			if (board.get(0).get(j) == 0) {
				for (int i = 1; i < m; i++) {
					board.get(i).set(j, 0);
				}
			}

		// use the pre calculated boolean values for filling first row and first column
		if (hasRookInFirstColumn) {
			for (int i = 0; i < m; i++)
				board.get(i).set(0, 0);
		}
		if (hasRookInFirstRow) {
			for (int i = 0; i < n; i++)
				board.get(i).set(0, 0);
		}

	}

	public static void main(String[] args) {

		List<List<Integer>> board = new ArrayList<List<Integer>>();

		board.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1)));
		board.add(new ArrayList<Integer>(Arrays.asList(1, 1, 0, 1, 1, 1)));
		board.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1)));
		board.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1)));
		board.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1, 1, 1, 1)));

		markAttackedCells(board);

		for (List<Integer> lst : board) {
			for (Integer i : lst) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}

	}

}
