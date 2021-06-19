package preparations.numbers;

public class NthFebanocciNumber {
	public static int getNthFib(int n) {
		if (n == 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		}
		int i = 0;
		int j = 1;
		int count = 2;
		for (int k = 3; k <= n; k++) {
			int sum = i + j;
			i = j;
			j = sum;
		}
		return j;
	}
}
