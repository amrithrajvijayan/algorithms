package preparations.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FormLargestNumberFromArray {

	public static void main(String[] args) {
		Integer[] numbers = {3, 30, 34, 5, 9};
		
		FormLargestNumberFromArray flna = new FormLargestNumberFromArray();
		flna.printLargestNumber(numbers);
	}

	private void printLargestNumber(Integer[] numbers) {

		List<Integer> numberList = Arrays.asList(numbers);
		
		Collections.sort(numberList, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				int value1 = Integer.parseInt(o1.toString() + o2.toString());
				int value2 = Integer.parseInt(o2.toString() + o1.toString());
				return value2 - value1;
				//return (value1 > value2 ? -1 : 1);
			}
			
		});
		for(int i : numberList) {
			System.out.print(i);
		}
		
		
	}

}
