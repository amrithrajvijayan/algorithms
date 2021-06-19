package preparations.bit_operations;

import java.util.Random;

public class ClearLowerMostBit {

	public static void main(String[] args) {
		int i = 9; // 11
		// Clear the lower most bit;
		i = i & ((~0) << 1);
	    System.out.println("lowermost bit cleared -> i = " + i);
	    
	    i = 9;
	    i = i & ((~0) >> 1);
	    System.out.println("leftmost bit cleared -> i = " + i);
	    
	    
	    
	    //short cuts
	    i = 10;//110
	    System.out.println("The lowest bit  is " + (i & ~(i-1)));
	    
	    
	    i = 9;//110
	    System.out.println("Cleared lowest bit  is " + (i & (i-1)));
	    
	}

}
