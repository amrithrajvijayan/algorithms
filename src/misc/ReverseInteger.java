package misc;

public class ReverseInteger {

	public static int reverse(int i) {
		
		if (i < 10 && i > -10) 
			return i;
		
		if (i > 0) {
			return rev(i);
		} else return 0 - rev(-i); 
	}
	
	private static int rev(int i) {
		
		char[] chars = String.valueOf(i).toCharArray();
		for (int j=0; j<= chars.length/2; j++) {
			char temp = chars[j] ;
			chars[j] = chars[chars.length-1-j];
			chars[chars.length-1-j] = temp;
		}
		
		long l = Long.parseLong(String.copyValueOf(chars));
		if (l > Integer.MAX_VALUE) {
			return -1;
		}
		return (int)(l);
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println(reverse(1000000003));

	}

}
