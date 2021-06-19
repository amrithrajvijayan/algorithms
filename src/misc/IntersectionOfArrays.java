package misc;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfArrays {
	
/*	
	Find the intersection of two sorted arrays.
	OR in other words,
	Given 2 sorted arrays, find all the elements which occur in both the arrays.

	Example :

	Input : 
	    A : [1 2 3 3 4 5 6]
	    B : [3 3 5]

	Output : [3 3 5]

	Input : 
	    A : [1 2 3 3 4 5 6]
	    B : [3 5]

	Output : [3 5]

*/	

    public static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
    	
    	ArrayList<Integer> common = new ArrayList<>();
    	
    	if (A == null || B==null || A.size() ==0 || B.size() == 0) {
    	    return common;
    	}
    	
    	
    	int aPos = 0;
    	int bPos = 0;
    	
    	while(aPos < A.size() && bPos < B.size()) {
    		
    		if (A.get(aPos).equals(B.get(bPos))) {
    			common.add(A.get(aPos));
    		}
    		if (A.get(aPos) < B.get(bPos)) {
    			aPos++;
    		} else if (B.get(bPos) < A.get(aPos)) {
    			bPos++;
    		} else {
    			aPos++;
    			bPos++;
    		}
    		
    		
    	}
    	
    	
    	return common;
    }	
	
	public static void main(String[] args) {
		
		

		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		/*list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		list1.add(6);

		list2.add(3);
		list2.add(3);
		list2.add(5);*/
		list1.add(1000);
		list2.add(1000);
		

		
		System.out.println(intersect(list1, list2));

	}

}
