package preparations.linked_hash_map;

import java.util.*;

public class LinkedHashMapExample {

	public static void main(String[] args) {
		
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>() {
					protected boolean removeEldestEntry(Map.Entry<Integer, String> e) {
						return size() > 5;
					}
		};
		
		map.put(1,"one");
		map.put(2,"two");
		map.put(3,"three");
		map.put(4,"four");
		map.put(5,"five");
		map.put(6,"six");
		
		System.out.println("Map is " + map);
		
		for (Integer k : map.keySet()) {
			System.out.println("key=" + k+", value="+ map.get(k));
		}
		
		for (Map.Entry<Integer, String> m : map.entrySet()) {
			System.out.println("Entry : " + m);
		}
		
		
	}

}
