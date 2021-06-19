package preparations.honors_class;

public class GCDOfTwoNumbers {

	private static int GCD(int x, int y) {
		// System.out.println("GCD : x="+x+", y="+y);
		if (x > y)
			return GCD(x - y, y);
		else
			return x;
	}

	private static int GCDEfficient(int x, int y) {
		// System.out.println("GCD Efficient: x="+x+", y="+y);
		if (y > 0)
			return GCDEfficient(y, x % y);
		else
			return x;
	}

	private static int GCDWithoutMultiplicationDivisionModulusOperations(int x, int y) {

		if (x == y) {
			return x;
		} else if (((x & 1) == 0) && ((y & 1) == 0)) { // x and y are even
			return GCDWithoutMultiplicationDivisionModulusOperations(x >> 1, y >> 1) << 1; // divide x and y by 2.
																							// Multiple the result with
																							// 2
		} else if (((x & 1) == 0) && ((y & 1) != 0)) { // x is even, y is odd
			return GCDWithoutMultiplicationDivisionModulusOperations(x >>> 1, y);// divide only x by 2
		} else if (((x & 1) != 0) && ((y & 1) == 0)) { // x is odd, y is even
			return GCDWithoutMultiplicationDivisionModulusOperations(x, y >>> 1);// divide only y by 2
		} else if (x > y) { // both x and y are odd and x > y
			return GCDWithoutMultiplicationDivisionModulusOperations(x - y, y);
		} else { // both x and y are odd and y>=x
			return GCDWithoutMultiplicationDivisionModulusOperations(x, y - x);
		}

	}

	public static void main(String[] args) {

		int x = 121;
		int y = 22;

		System.out.println(GCD(x, y));
		System.out.println(GCDEfficient(x, y));
		System.out.println(GCDWithoutMultiplicationDivisionModulusOperations(x, y));

	}

}
