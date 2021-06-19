package misc;
import java.util.*;
import java.util.stream.Stream;

public class StreamExample {
	
	
	
	public static void main(String[] args) {
		
		
		
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(3);
		myList.add(1);
		myList.add(12);
		myList.add(9);
		myList.add(2);
		
		
		//myList.stream().forEach((n) -> System.out.println(n));
		//myList.stream().filter((n) -> (n<10));
		/*
		
		Stream<Integer> str1 = myList.stream();
		str1.forEach((n) -> System.out.println(n));		
		
		myList.stream().filter((n) -> (n < 10)).forEach((k) -> System.out.println("Filtered " + k));
		
		Optional<Integer> opt1 = myList.stream().min(Integer::compare);
		if (opt1.isPresent()) {
			System.out.println("Min value is " + opt1.get());
		}
		
		myList.stream().sorted().forEach((k) -> System.out.println("sorted " + k));
		
		
		Optional<Integer> opt2 = myList.stream().reduce((a, b) -> a + b);
		if (opt2.isPresent())
			System.out.println("reduced value is " + opt2.get());
			*/
		
		Iterator<Integer> iter1 = myList.stream().iterator();
		while(iter1.hasNext()) {
			System.out.println(iter1.next());
		}
		
		System.out.println("Spliterator");
		
		
		
		
		Spliterator<Integer> split = myList.stream().spliterator();
		
		Spliterator<Integer> split2 = split.trySplit();
		while(split.tryAdvance((n) -> System.out.println("split 1 " + n)));
		
		while(split2.tryAdvance((n) -> System.out.println("split 2 " + n)));
		
		
		
		
		
		
		
	}

}
