package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxDistance {
	
/*	Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].


			Input Format

			First and only argument is an integer array A.


			Output Format

			Return an integer denoting the maximum value of j - i;


			Example Input

			Input 1:

			 A = [3, 5, 4, 2]



			Example Output

			Output 1:

			 2



			Example Explanation

			Explanation 1:

			 Maximum value occurs for pair (3, 4).
			 */
	
	class Pair {
		int value;
		int location;
		public Pair(int value, int location) {
			this.value = value;
			this.location = location;
		}
	}
	
	
	
	
	public int maximumGap(final List<Integer> A) {
		
        if (A.size() == 0 || A.size() ==1){
            return 0;
        }		
		int maxGap = -1;
		
		int[] leftMinArray = new int[A.size()];
		int[] rightMaxArray = new int[A.size()];
				
		leftMinArray[0] = A.get(0);
		for (int i=1; i<A.size(); i++) {
			leftMinArray[i] = Math.min(A.get(i), leftMinArray[i-1]);
		}
		rightMaxArray[A.size() - 1] = A.get(A.size()-1);
		for (int i=A.size()-2; i>=0; i--) {
			rightMaxArray[i] = Math.max(A.get(i), rightMaxArray[i+1]);
		}
			
		int i = 0;
		int j =0;
		while(i<A.size() && j<A.size()) {
			if (leftMinArray[i] <= rightMaxArray[j]) {
				maxGap = Math.max(maxGap, j-i);
				j++;
			} else {
				i++;
			}
		}
		
		
		return maxGap;
	}	
	

	public static void main(String[] args) {
		List<Integer> A = new ArrayList<>();
		A.add(3);
		A.add(3);
		A.add(3);
		A.add(3);
		//A.add(8);
		System.out.println(new MaxDistance().maximumGap(A));
	}

}
