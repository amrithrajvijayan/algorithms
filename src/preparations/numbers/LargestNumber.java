package preparations.numbers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

	/*
	 * Given a list of non negative integers, arrange them such that they form the
	 * largest number.
	 * 
	 * For example:
	 * 
	 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
	 * 
	 * Note: The result may be very large, so you need to return a string instead of
	 * an integer.
	 */

	public String largestNumber(final List<Integer> B) {

		List<Integer> A = new ArrayList<Integer>(B);
		A.sort(new Comparator<Integer>() {
			public int compare(Integer i, Integer j) {

				Long k = Long.parseLong(i + "" + j);
				Long l = Long.parseLong(j + "" + i);

				if (k > l) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		StringBuffer retValue = new StringBuffer();
		boolean nonZeroFound = false;
		for (Integer i : A) {
			retValue.append(i);
			if (i != 0) {
				nonZeroFound = true;
			}
		}
		if (!nonZeroFound) {
			return "0";
		} else
			return (retValue.toString());
	}

	public static void main(String[] args) {
		LargestNumber ln = new LargestNumber();
		List<Integer> input = new ArrayList<>();

		input.add(3);
		input.add(30);
		input.add(34);
		input.add(5);
		input.add(9);

		// 9534330

		/// 4, 25, 21, 2, 6
		// 6425221

		System.out.println(ln.largestNumber(input));

	}

}
