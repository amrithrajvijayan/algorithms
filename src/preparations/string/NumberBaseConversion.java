package preparations.string;

public class NumberBaseConversion {

	// Convert a number from base1 to base2
	public static void main(String[] args) {
		String str = "1010";

		int base1 = 2;
		int base2 = 2;
		

		// Convert from base1 to base 10.
		System.out.println("Input base " + base1 + " number is " + str);

		int number = 0;
		char[] chars = str.toCharArray();
		int power = 0;
		for (int i = chars.length - 1; i >= 0; i--) {
			int j = chars[i] - '0';
			number = (int) (number + j * Math.pow(base1, power));
			power++;
		}

		System.out.println("Intermediate base 10 number is " + number);
		StringBuffer sb = new StringBuffer("");
		int num = number;
		while (num > 0) {
			sb.append(num % base2);
			num = num / base2;
		}
		sb.reverse();
		System.out.println("Output base " + base2 + " number is " + sb);
	}

}
