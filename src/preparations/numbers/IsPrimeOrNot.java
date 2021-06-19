package preparations.numbers;

public class IsPrimeOrNot {
	
	
	private static String isPrime(int n) {
		
		double sqrRoot = Math.sqrt(n);
		System.out.println("squareRoot is " + sqrRoot);
		for (int i=2; i<sqrRoot; i++) {
			if (n%i == 0) {
				return "Not a Prime";
			}
		}
		
		return "Prime";
	}

	private static void findFactors(int n) {
		
		double sqrRoot = Math.sqrt(n);
		for (int i=1; i<sqrRoot; i++) {
			if (n%i == 0) {
				System.out.println(i);
				System.out.println(n/i);
			}
		}
		return;
	}

	
	
	public static void main(String[] args) {
		int n = 80;
		
		System.out.println(n + " is " + isPrime(n));
		
		System.out.println("Factors are \n");
		findFactors(n);
		
	}

}
