package misc;

import java.util.*;
import java.util.stream.*;

public class SteamExample {
	
	public static void main(String[] args) {
		
		
		List<Integer> myList = new ArrayList<>();
		for (int i=0; i<50; i++) {
			myList.add(i);
		}
		
		Stream<Integer> str1 = myList.stream();
		Optional<Integer> opt = str1.limit(10).sorted().
		filter((a) -> { return a>5; }).
		map((a) -> {return a *2;}).
		reduce((a, b) -> { return a + b; });
		
		if (opt.isPresent()) {
			System.out.println(opt.get());
		}
		/*.
		forEach((a) -> { System.out.print(a + ", "); });*/ 
		
		
		
		
		
	}

}
