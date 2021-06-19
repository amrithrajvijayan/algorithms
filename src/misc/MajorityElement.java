package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
	
	/*
	Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.

	You may assume that the array is non-empty and the majority element always exist in the array.
	*/
	
    public static int majorityElement(final List<Integer> A) {
    	
    	Map<Integer, Integer> map= new HashMap<Integer, Integer>();
    	int maxElement = 0;
    	int maxElementCount = 0;
    	for (int i=0; i<A.size(); i++) {
    		int elem = A.get(i);
    		if (map.get(elem) == null) {
    			map.put(elem, 1);
    			if (i == 0) {
    			maxElement = elem;
    			maxElementCount = 1;
    			}
    		} else {
    			int currentCount = map.get(elem);
    			currentCount++;
    			if (currentCount > maxElementCount) {
    				maxElementCount = currentCount;
    				maxElement = elem;
    			}
    			map.put(elem, currentCount);
    		}
    	}
    	
    	
    	return maxElement;
    }
    
    
    
    public static void main(String[] args) {
    			
    	List<Integer> list = new ArrayList<>();
    	list.add(1);
    	list.add(1);
    	list.add(2);
    			
    	System.out.println(majorityElement(list));
    }

}
