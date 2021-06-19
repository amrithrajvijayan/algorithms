package misc;

public class StringReverse {
	
	
	
	
	public static void main(String[] args) {
		
		String s = "hello world";
		
		
		StringBuffer sb = new StringBuffer();
		for (int i= s.length() -1 ; i>=0; i--) {
			sb.append(s.charAt(i));
		}
		System.out.println(sb.toString());
	}

}
