package preparations.honors_class;
import java.util.*;

/*
Design an algorithm to find the kth number such that the only prime factors are 3, 5, and 7. 
Note that 3, 5, and 7 do not have to be factors, but it should not have any other prime factors. 
For example, the first several multiples would be (in order) 1, 3, 5, 7, 9, 15, 21
*/
public class KthMultiple {

	private static int findKthNumber(int k) {
		
		if (k==0)
			return 0;
		
		int val =0;
		Queue<Integer> queue3 = new LinkedList<>();
		Queue<Integer> queue5 = new LinkedList<>();
		Queue<Integer> queue7 = new LinkedList<>();
		
		queue3.add(1);
		
		for (int i=0; i<k; i++) {
			
			int v3 = queue3.size() > 0 ? queue3.peek() : Integer.MAX_VALUE;
			int v5 = queue5.size() > 0 ? queue5.peek() : Integer.MAX_VALUE;
			int v7 = queue7.size() > 0 ? queue7.peek() : Integer.MAX_VALUE;
			
			val = Math.min(v3, Math.min(v5, v7));
			
			if (val == v3) {
				queue3.remove();
				queue3.add(v3 * 3);
				queue5.add(v3 * 5);
			} else if (val == v5) {
				queue5.remove();
				queue5.add(v5 * 5);
			} else if (val == v7) {
				queue7.remove();
			}
			queue7.add(val * 7);
			
			
		}
		
		return val;
	}
	
	
	
	
	public static void main(String[] args) {
		
		int k = 5;
		System.out.println(findKthNumber(k));

	}

}
