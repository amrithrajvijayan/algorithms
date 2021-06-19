package preparations.backtracking;

import java.util.*;

// Time complexity : n! upper bound.
// Space complexity : n
public class NonAttackingNQueensBetterVersion {
	
	public static void main(String[] args) {
		int n = 5;
		System.out.println("No of positions = " + new NonAttackingNQueensBetterVersion().nonAttackingQueens(n));
	}

	  public int nonAttackingQueens(int n) {
	    
			HashSet<Integer> blockedColumns = new HashSet<>();
			HashSet<Integer> blockedUpDiagonals = new HashSet<>();
			HashSet<Integer> blockedDownDiagonals = new HashSet<>();
			
	    return getNumberOfNonAttackingPlacements(
			0, blockedColumns, blockedUpDiagonals, blockedDownDiagonals, n);
	  }
		
		private int getNumberOfNonAttackingPlacements(
			int row, HashSet<Integer> blockedColumns, 
			HashSet<Integer> blockedUpDiagonals, 
			HashSet<Integer> blockedDownDiagonals, 
			int n) {
		
			if (row == n)
				return 1;
			int validPlacements = 0;
		
			for (int col=0; col<n; col++) {
				if (isValidPlacement(row, col, blockedColumns, blockedUpDiagonals, blockedDownDiagonals)) {
					
					placeQueen(row, col, blockedColumns, blockedUpDiagonals, blockedDownDiagonals);
					
					validPlacements += getNumberOfNonAttackingPlacements(
			row+1, blockedColumns, blockedUpDiagonals, blockedDownDiagonals, n);
					
					removeQueen(row, col, blockedColumns, blockedUpDiagonals, blockedDownDiagonals);
				}
			}
			return validPlacements;
		}
		
		private boolean isValidPlacement(int row, int col, 
																		 HashSet<Integer> blockedColumns, 
																		 HashSet<Integer> blockedUpDiagonals, 
																		 HashSet<Integer> blockedDownDiagonals) {
			
			if (blockedColumns.contains(col))  {
				return false;
			}
			
			if (blockedUpDiagonals.contains(row+col)) 
				return false;
			
			if (blockedDownDiagonals.contains(row-col))
				return false;
			
			return true;
		}
		
		private void placeQueen(int row, int col,
														HashSet<Integer> blockedColumns, 
														HashSet<Integer> blockedUpDiagonals, 
														HashSet<Integer> blockedDownDiagonals
													 ) {
			
			blockedColumns.add(col);
			blockedUpDiagonals.add(row+col);
			blockedDownDiagonals.add(row-col);
		}
		
			private void removeQueen(int row, int col,
														HashSet<Integer> blockedColumns, 
														HashSet<Integer> blockedUpDiagonals, 
														HashSet<Integer> blockedDownDiagonals
													 ) {
			
			blockedColumns.remove(col);
			blockedUpDiagonals.remove(row+col);
			blockedDownDiagonals.remove(row-col);
		}
		
}
