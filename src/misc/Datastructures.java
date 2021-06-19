package misc;
import java.util.*;

public class Datastructures {
	
	private static void out(int i) {
		out("" + i);
	}
	
	private static void out(String v) {
		System.out.print(v + " ");
	}
	
	private static void testHashSet() {
		
		Set<Integer> set = new HashSet<>();
		set.add(4);
		set.add(2);
		set.add(30);
		set.add(24);
		set.add(39);
		
		for (int i : set) {
			out(i + " ");
		}
		
		out("\n" + set.contains(22) + "\n");
		
	    out("\nbefore removal\n");

		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			out(iter.next());
		}
		
		set.remove(24);
		set.remove(39);
		
	    iter = set.iterator();
	    out("\nafter removal\n");
		while(iter.hasNext()) {
			out(iter.next());
		}
	}
	
	private static void testTreeSet() {
		
		TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b-a;
			}
		});
		set.add(14);
		set.add(2);
		set.add(30);
		set.add(24);
		set.add(39);
		
		out("before removal \n");
		for (int i : set) {
			out(i + " ");
		}		
		set.pollFirst();
		
		out("\nafter removal \n");
		for (int i : set) {
			out(i + " ");
		}			
		
		out("set contains 14 ? " + set.contains(14));
		
	}
	
	private static void testTreeMap() {
		
		
	}
	
	
	public static void main(String[] args) {
		// testHashSet();
		
		// testTreeSet();
		
		testTreeMap();
	}

}
