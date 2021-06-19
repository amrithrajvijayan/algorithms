package preparations.arrays;

import java.util.*;
import java.util.Arrays;

/*
Write a function that takes in an array of integers and returns the largest
possible value for the expression
array[a] - array[b] + array[c] - array[d], where a,
b, c, and d are indices of the array
and a < b < c < d.

If the input array has fewer than 4 elements, your function
should return 0.

Sample Input
array = [3, 6, 1, -3, 2, 7]

Sample Output
4
// Choose a = 1, b = 3, c = 4, and d = 5
//  6 - (-3) + 2 - 7 = 4

*/

public class MaxmizeValueOfAnExpression {

	  public int maximizeExpression(int[] array) {
	    
			if (array.length < 4) 
				return 0;
			
			ArrayList<Integer> maxOfA = new ArrayList<Integer>(Arrays.asList(array[0]));
			ArrayList<Integer> maxOfAminusB = new ArrayList<Integer>(Arrays.asList(Integer.MIN_VALUE));
			ArrayList<Integer> maxOfAminusBplusC = new ArrayList<Integer>(Arrays.asList(Integer.MIN_VALUE, Integer.MIN_VALUE));
			ArrayList<Integer> maxOfAminusBplusCMinusD = new ArrayList<Integer>(Arrays.asList(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE));
			
			for (int i=1; i<array.length; i++) {
				int max = Math.max(maxOfA.get(i-1), array[i]);
				maxOfA.add(max);
			}	
				
			for (int i=1; i<array.length; i++) {
				int max = Math.max(maxOfAminusB.get(i-1), 
													maxOfA.get(i-1) - array[i]);
				maxOfAminusB.add(max);
			}	
			
			for (int i=2; i<array.length; i++) {
				int max = Math.max(
					maxOfAminusBplusC.get(i-1),
					maxOfAminusB.get(i-1) + array[i]
				);
				maxOfAminusBplusC.add(max);
			}
			
			for (int i=3; i<array.length; i++) {
				int max = Math.max(
					maxOfAminusBplusCMinusD.get(i-1),
					maxOfAminusBplusC.get(i-1) - array[i]
				);
				maxOfAminusBplusCMinusD.add(max);
			}
			
				
			
	    return maxOfAminusBplusCMinusD.get(maxOfAminusBplusCMinusD.size()-1);
	  }
}
