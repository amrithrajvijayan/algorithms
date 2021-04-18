package preparations.arrays;

import java.util.*;

public class ArrayPartialSumInterval {

	
    // Complete the birthday function below.
    static int birthday(List<Integer> s, int m, int d) {
        int count = 0;
        
        if (s != null && s.size() >= d) {
            int partialSum = 0;
            int index = 0;
            for (index=0; index<d; index++) {
                partialSum += s.get(index);
            }
            index = 0;            
            while(index + d - 1 < s.size()) {
            	System.out.println("\npartial sum is " + partialSum+", for "+index);
                if (partialSum == m)
                    count++;
                
                index++;    

                if (index+d-1 >= s.size())
                  break;
                
                System.out.println("new index " + index);
                System.out.println("adding " + s.get(index+d -1) +", deducting " + s.get(index-1));
                
                partialSum = partialSum + s.get(index+d -1);
                partialSum = partialSum - s.get(index-1);                
            }
            
            
        }

        return count;
    }	
	
	public static void main(String[] args) {
		Integer[] arr = {2, 5, 1, 3, 4, 4, 3,  5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1};
		
		
		System.out.println(birthday( new ArrayList<Integer>(Arrays.asList(arr)) ,18, 7));
	}

}
