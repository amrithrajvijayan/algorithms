package preparations.backtracking;
import java.util.*;

/*
<p>
  You're given a two-dimensional array that represents a 9x9 partially filled
  Sudoku board. Write a function that returns the solved Sudoku board.
</p>
  <p>
  Sudoku is a famous number-placement puzzle in which you need to fill a 9x9
  grid with integers in the range of <span>1-9</span>. Each 9x9 Sudoku board is
  split into 9 3x3 subgrids, as seen in the illustration below, and starts out
  partially filled.
</p>
  <pre>- - 3 | - 2 - | 6 - - 
9 - - | 3 - 5 | - - 1 
- - 1 | 8 - 6 | 4 - -
- - - - - - - - - - - 
- - 8 | 1 - 2 | 9 - -
7 - - | - - - | - - 8 
- - 6 | 7 - 8 | 2 - -
- - - - - - - - - - -
- - 2 | 6 - 9 | 5 - - 
8 - - | 2 - 3 | - - 9
- - 5 | - 1 - | 3 - -
</pre>
  
  <p>
  The objective is to fill the grid such that each row, column, and 3x3 subgrid
  contains the numbers <span>1-9</span> exactly once. In other words, no row may
  contain the same digit more than once, no column may contain the same digit
  more than once, and none of the 9 3x3 subgrids may contain the same digit more
  than once.
</p>
  
  <p>
  Your input for this problem will always be a partially filled 9x9
  two-dimensional array that represents a solvable Sudoku puzzle. Every element
  in the array will be an integer in the range of <span>0-9</span>, where a
  <span>0</span> represents an empty square that must be filled by your
  algorithm.
</p>
  
  <p>
  Note that you may modify the input array and that there will always be exactly
  one solution to each input Sudoku board.
</p>
  */


public class SolvingSudoku {

  public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
    solvePartialSudoku(0,0, board);
    return board;
  }
	
	public boolean solvePartialSudoku(int row, int col, ArrayList<ArrayList<Integer>> board) {
		
		int currentRow = row;
		int currentCol = col;
		
		if (currentCol == board.get(currentRow).size()) {
			currentRow= currentRow + 1;
			currentCol = 0;
			if (currentRow == board.size()) 
				return true;
		}
		
		if (board.get(currentRow).get(currentCol) == 0) {
			return tryDigitsAtPosition(currentRow, currentCol, board);
		}
		
		return solvePartialSudoku(currentRow, currentCol+1, board);
	}
	
	
	public boolean tryDigitsAtPosition(int row, int col, ArrayList<ArrayList<Integer>> board) {
		
		for (int digit = 1; digit < 10; digit++) {
			if (isValidAtPosition(digit, row, col, board)) {
				board.get(row).set(col, digit);
				if (solvePartialSudoku(row, col+1, board)) 
					return true;
			}
		}
		
		board.get(row).set(col, 0);
		return false;
		
	}
	
	private boolean isValidAtPosition(
	int value, int row, int col, ArrayList<ArrayList<Integer>> board) {
		
		boolean rowIsValid = !board.get(row).contains(value);
		boolean columnIsValid = true;
		for (int r=0; r<board.size(); r++) {
			if (board.get(r).get(col) == value) 
				columnIsValid = false;
		}
		
		if (!rowIsValid || !columnIsValid) 
			return false;
		
		int subgridRowStart = (row/3) * 3;
		int subgridColStart = (col/3) * 3;
		
		for (int rowIndex=0; rowIndex<3; rowIndex++) {
			for (int colIndex=0; colIndex<3; colIndex++) {
				int rowToCheck = subgridRowStart+rowIndex;
				int colToCheck = subgridColStart + colIndex;
				int existingValue = board.get(rowToCheck).get(colToCheck);
				if (existingValue == value)
					return false;
			}
		}
		return true;
	}
	
}
