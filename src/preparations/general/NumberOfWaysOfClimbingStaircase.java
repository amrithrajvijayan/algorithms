package preparations.general;
import java.util.*;


/*
  You're given two positive integers representing the height of a staircase and
  the maximum number of steps that you can advance up the staircase at a time.
  Write a function that returns the number of ways in which you can climb the
  staircase.


  For example, if you were given a staircase of height = 3 and
  maxSteps = 2 you could climb the staircase in 3 ways. You could
  take 1 step, 1 step, then 1 step, you could also take
  1 step, then 2 steps, and you could take 2 steps, then 1 step.

  
  Note that maxSteps < height will always be true.
  
  Input
  
  height = 4
  maxSteps = 2


Output

5
// You can climb the staircase in the following ways: 
// 1, 1, 1, 1
// 1, 1, 2
// 1, 2, 1
// 2, 1, 1
// 2, 2

*/

public class NumberOfWaysOfClimbingStaircase {

	
	private int countTraversals(int height, int maxSteps, int remainingHeight) {
		if (remainingHeight == 0)
			return 1;
		if (remainingHeight < 0)
			return 0;
		
		
		int count = 0;
		for (int i=1; i<=maxSteps; i++) {
			count = count + countTraversals(height, maxSteps, remainingHeight - i);
		}
		return count;
	}
	
	
  public int staircaseTraversal(int height, int maxSteps) {
    // Iterative
		//return countTraversals(height, maxSteps, height);
		
		//DP solution.. O(n*k) time and O(n) space
		int[] dp = new int[height+1];
		dp[0] = 1;
		
		for (int i=1; i<=height; i++) {
			int count = 0;
			for (int j=1; j<=maxSteps; j++) {
				if (i>=j)
					count = count + dp[i-j];
			}
			dp[i] = count;
		}
		
		
		//return dp[height];		
		
		// Most efficient solution
		// O(n) time and space
		return stairCaseTraversalMostEfficient(height, maxSteps);
  }
	
	public int stairCaseTraversalMostEfficient(int height, int maxSteps) {
		int numberOfWays = 0;
		
		ArrayList<Integer> waysToTop = new ArrayList<>();
		waysToTop.add(1);
		
		for (int currentHeight = 1; currentHeight <= height; currentHeight++) {
			
			int startOfWindow  = currentHeight - maxSteps - 1;
			int endOfWindow = currentHeight - 1;
			
			if (startOfWindow >= 0) {
				numberOfWays = numberOfWays - waysToTop.get(startOfWindow);
			}
			
			numberOfWays = numberOfWays + waysToTop.get(endOfWindow);
			waysToTop.add(numberOfWays);
			
		}
		
		return waysToTop.get(height);
	}
	
	public static void main(String[] args) {
		for (int i=1; i<10; i++)
		System.out.println(new NumberOfWaysOfClimbingStaircase().stairCaseTraversalMostEfficient(i, 2));
	}
}
