package misc;

public class LexiographicalNextString {

    static String biggerIsGreater(String w) {
        if (w==null || w.length() == 0) {
            return "no answer";
        }
        char[] chars = w.toCharArray();
        int i = chars.length-1;
        while(i>0) {
            if (chars[i-1] < chars[i]) {
                break;
            }
            i--;
        }
        if (i<=0) {
            return "no answer";
        }
        int j=chars.length-1;
        while(chars[j] <= chars[i-1]) {
            j--;
        }
        char t = chars[i-1];
        chars[i-1] = chars[j];
        chars[j] = t;

        j=chars.length-1;
        while(i<j) {
            char tt = chars[i];
            chars[i] = chars[j];
            chars[j] = tt;
            i++;
            j--;
        }

        return new String(chars);

    }	
	
	public static void main(String[] args) {
		System.out.println(biggerIsGreater("dkhc"));

	}

}
