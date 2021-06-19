package preparations.arrays;

import java.util.Arrays;
import java.util.List;

// Can we reach till the end of the array by using the values in the array
public class CanReachToTheEndOfArray {

	/*
	public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
		int furthestReachSoFar = 0, lastlndex = maxAdvanceSteps.size() - 1;
		for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastlndex; ++i) {
			furthestReachSoFar = Math.max(furthestReachSoFar, i + maxAdvanceSteps.get(i));
		}
		return furthestReachSoFar >= lastlndex;
	}
	*/

	public static void main(String[] args) {
		Integer[] arr = {3, 1, 0 ,1, 2,	0,	1};
		System.out.println(canReachEnd(Arrays.asList(arr)));
	}
	
	
	private static boolean canReachEnd(List<Integer> lst) {
		
		int maxRangeSoFar = 0;
		for (int i=0; i<lst.size(); i++) {
			if (maxRangeSoFar < i)
				return false;
			maxRangeSoFar = Math.max(maxRangeSoFar, (i+lst.get(i)));
		}
		return true;
	}
	
	
	

}
