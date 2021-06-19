package misc;
import java.util.ArrayList;


public class PlusOne {
	
	/*
	Given a non-negative number represented as an array of digits,

	add 1 to the number ( increment the number represented by the digits ).

	The digits are stored such that the most significant digit is at the head of the list.

	Example:

	If the vector has [1, 2, 3]

	the returned vector should be [1, 2, 4]

	as 123 + 1 = 124.
	
	*/
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
    	
    	
    	int carryForward = 0;
    	for (int i=A.size()-1; i>=0; i--) {
    		
    		int value = A.get(i);
    		if (i==A.size()-1) {
    			value++;
    		} else if (carryForward == 1) {
    			value = value + 1;
    			carryForward = 0;
    		}
    		if (value>=10) {
    			value = 0;
    			carryForward = 1;
    		}
    		A.set(i, value);
    	}
    	if (carryForward == 1) {
    		A.add(0, 1);
    	}
    	
    	while (A.get(0) == 0) {
    		A.remove(0);
    	}
    	
    	return A;
    }
    
    
	public static void main(String[] args) {
		PlusOne po = new PlusOne();
		
		ArrayList<Integer> input = new ArrayList<>();
		//input.add(0);
		input.add(0);
		input.add(8);
		input.add(9);
		
		System.out.println(po.plusOne(input));
	}

}
