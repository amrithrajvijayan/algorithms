package preparations.numbers;

public class NumberPalindrom {

	
	
	
	private static boolean isPalindrom(int n) {
		if (n < 9)
			return true;
		int length = 0;
		int number = n;
		while(number > 0) {
			number = number/10;
			length++;
		}
		
		for (int i=1; i<=length/2; i++) {
			int first = getDigit(n, length, i);
			int second = getDigit(n, length, length-i+1);
			if (first != second)
				return false;
		}
		
		return true;
	}
	
	private static int getDigit(int num, int length, int pos) {
		double nums = num / Math.pow(10, (length-pos));
		return (int)nums % 10;
	}
	
	
	
	public static void main(String[] args) {
		int n = 77877;
		System.out.println(isPalindrom(n));
	}

}
