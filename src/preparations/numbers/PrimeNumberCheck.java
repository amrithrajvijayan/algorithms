package preparations.numbers;

public class PrimeNumberCheck {
	
	
	private static String checkPrime(int n) {
		
		for (int i=2; i<Math.sqrt(n); i++) {
			if (n %i == 0)
				return "not a prime number";
		}
	
		return "a prime number";
	}
	
	
	public static void main(String[] args) {
		int n = 250;
		System.out.println("Number "+ n + " is " + checkPrime(n));
	}

}
