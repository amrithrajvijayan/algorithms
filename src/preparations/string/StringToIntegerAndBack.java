package preparations.string;

public class StringToIntegerAndBack {
	
	private static int convertToInt(String s) {
		
		Integer retValue = 0;
		
		char[] chars = s.toCharArray();
		for (char c : chars) {
			retValue = retValue * 10;
			retValue = retValue + (c - '0');
		}
		
		return retValue;
	}
	
	private static String convertToString(Integer i) {
		
		StringBuffer sb = new StringBuffer("");
		int val = i;
		while(val > 0) {
			sb.append(val % 10);
			val = val / 10;
		}
		sb.reverse();
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "1023";
		System.out.println(convertToInt(s));
		
		Integer i = 4993;
		System.out.println(convertToString(i));
	}

}
