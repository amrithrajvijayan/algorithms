package preparations.bitset;
import java.util.*;

public class BitSetOperations {
	
	
	
	private static BitSet getBitSet(int size) {
		return new BitSet(size);
	}
	
	public static void main(String[] args) {
		BitSet a = getBitSet(16);
		BitSet b = getBitSet(16);

		for (int i=0; i<16; i++) {
			a.set(i);
			if (i%2 == 0)
				b.set(i);
		}
		
		b.set(1);
		a.clear(1);
		
		System.out.println("Initial a = " + a);
		System.out.println("Initial b = " + b);
		
		System.out.println("Bs cardinality is " + b.cardinality());
		
		
		System.out.println(" a 1 is " + a.get(1));
		System.out.println(" b 1 is " + b.get(1));
		
		BitSet c = (BitSet)a.clone();
		c.and(b);
		System.out.println("a and b = " + c);
		
		BitSet d = (BitSet)a.clone();
		d.or(b);
		System.out.println("a or b = " + d);

	}

}
