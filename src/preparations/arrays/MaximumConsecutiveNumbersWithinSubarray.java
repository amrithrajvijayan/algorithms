package preparations.arrays;
import java.util.*;


public class MaximumConsecutiveNumbersWithinSubarray {

	
	private static List<Integer> findMaximumConsecutiveSubarray(Integer[] arr) {
		List<Integer> lst = new ArrayList<>();
	    int totalCount = 0;
	    
		for (int i=0; i<arr.length; i++) {
			int min = Integer.MAX_VALUE;
			int max= Integer.MIN_VALUE;
			for (int j=i; j<arr.length; j++) {
				
				min = Math.min(min, arr[j]);
				max = Math.max(max, arr[j]);
				
				if ( j-i+1 == (max-min + 1)) {
					int count = (max-min+1);
					if (count > totalCount) {
						totalCount = count;
						lst = new ArrayList(Arrays.asList(Arrays.copyOfRange(arr, i, j+1)));
					}
				}
			}
		}
		
		
		return lst;
	}
	
	
	public static void main(String[] args) {
		Integer[] arr = {9, 7, 1, 4, 2, 5, 3, 10};
		List<Integer> lst = findMaximumConsecutiveSubarray(arr);
		for (int i : lst) {
			System.out.print(i + " " );
		}
			
	}

}
