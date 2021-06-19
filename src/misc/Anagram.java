package misc;

public class Anagram {
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		String input = "ABC";
		
		Anagram.anagram(input, 0, input.length() - 1);
		
	}

	private static void anagram(String input, int start, int end) {

		//System.out.println("inside anagram with input = " +input);
		if (start == end) {
			System.out.println(input);
		}
		else {
			for (int i =start; i<=end; i++) {
				
				String inputted = swap(input, start, i);
				anagram(inputted, start+1, end);
				//input = swap(input, start, i);
			}
		}
		
		
		
	}

	private static String swap(String input, int start, int i) {
		
		char[] charArray = input.toCharArray();
		
		char temp = charArray[start];
		charArray[start] = charArray[i];
		charArray[i] = temp;
		
		return String.copyValueOf(charArray);
	}

}
