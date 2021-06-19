package preparations.dynamic_programming;

/*
<p>
  Write a function that takes in three strings and returns a boolean
  representing whether the third string can be formed by interweaving the first
  two strings.
</p>
  <p>
  To interweave strings means to merge them by alternating their letters without
  any specific pattern. For instance, the strings <span>"abc"</span> and
  <span>"123"</span> can be interwoven as <span>"a1b2c3"</span>, as
  <span>"abc123"</span>, and as <span>"ab1c23"</span> (this list is
  nonexhaustive).
</p>
  
  <p>
  Letters within a string must maintain their relative ordering in the
  interwoven string.
</p>
  
  */

public class IsThirdStringIntervowenFromTwoGivenStrings {
	
	
	private static boolean isInterweaving(String one, String two, String three, int i, int j, Boolean[][] cache) {
		
		if (cache[i][j] != null)
			return cache[i][j];
		
		int k = i + j;

		if (k == three.length()) {
			return true;
		}
		
				
		if (i < one.length() && three.charAt(k) == one.charAt(i)) {
				cache[i][j] = isInterweaving(one, two, three, i+1, j, cache);
				if (cache[i][j])
					return true;
		}
		
		if (j < two.length() && three.charAt(k) == two.charAt(j)) {
				cache[i][j] = isInterweaving(one, two, three, i, j+1, cache);
				if (cache[i][j])			
					return true;
		}
		
		cache[i][j] = false;
		return false;
	}
	
	
  public static boolean interweavingStrings(String one, String two, String three) {
    if (three.length() != (one.length() + two.length()))
			return false;
		Boolean[][] cache = new Boolean[one.length() + 1][two.length()+1];
		return isInterweaving(one, two, three, 0, 0, cache);
  }
}


