package preparations.string;

public class RabinKarpStringMatching {

	private static boolean search(String a, String b) {
		// Get the hash of search string.
		int hashOfSubstring = hash(b);
		// keep finding the hash of string of length equal to substring from master string. if 
		// hash matches substring hash, we can assume there is a match.
		// if required, we can do a letter by letter check within if condition
		for (int i=0; i<(a.length()-b.length()); i++) {
			String sub = a.substring(i, i+b.length());

			if (hashOfSubstring == hash(sub)) {
				return true;
			}
			
		}
		
		
		
		return false;
	}
	
	
	private static int hash(String input) {
		return input.hashCode();
	}
	
	
	
	public static void main(String[] args) {
		String a = "Hello this is a simple search text";
		String b = "simple";
		System.out.println("String search result = " + search(a, b));
	}

}
