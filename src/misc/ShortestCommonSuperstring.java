package misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestCommonSuperstring {
	
	/*
	Given a set of strings, A of length N.

	Return the length of smallest string which has all the strings in the set as substring.


	Input Format:

	The first and the only argument has an array of strings, A.

	Output Format:

	Return an integer representing the minimum possible length of the resulting string.

	Constraints:

	1 <= N <= 18
	1 <= A[i] <= 100

	Example:

	Input 1:
	    A = ["aaaa", "aa"]

	Output 1:
	    4

	Explanation 1:
	    Shortest string: "aaaa"

	Input 2:
	    A = ["abcd", "cdef", "fgh", "de"]

	Output 2:
	    8

	Explanation 2:
	    Shortest string: "abcdefgh"

*/	
	
	
	
	
	
    public static int solve(ArrayList<String> A) {
    	String shortestString = "";
    	Queue<String> queue = new LinkedList<>();
    	
    	for (String str : A) {
    		if (queue.size() == 0) {
    			queue.add(str);
    		} else {
    			int length = queue.size();
    			for (int i=0; i<length; i++) {
    				String queueValue = queue.remove();
    				String leftAppendedValue = leftAppend(queueValue, str);
    				String rightAppendedValue = rightAppend(queueValue, str);
    				queue.add(leftAppendedValue);
    				queue.add(rightAppendedValue);
    			}
    		}
    	}
    	int length = queue.size();
    	for (int i=0; i<length;i++) {
    		if (i==0) {
    			shortestString = queue.remove();
    		} else {
    			String queueValue = queue.remove();
    			if (queueValue.length() < shortestString.length()) {
    				shortestString = queueValue;
    			}
    		}
    	}
    	
    	
    	
    	
    	return shortestString.length();
    }

	private static String leftAppend(String queueValue, String str) {
		
		if (queueValue.indexOf(str) != -1) {
			return queueValue;
		}
		
		int strIndex = str.length()-1;
		int foundIndex = strIndex;
		while(strIndex >= 0 ) {
			System.out.println("str.substring(strIndex, str.length()) = " + str.substring(strIndex, str.length()));
			if (queueValue.startsWith(str.substring(strIndex, str.length()))) {
				foundIndex = strIndex;
				foundIndex--;
			}
			strIndex--;
		}
		
		String ret =  str.substring(0, foundIndex + 1) + queueValue;
		return ret;

		
	}

	private static String rightAppend(String queueValue, String str) {
		
		if (queueValue.indexOf(str) != -1) {
			return queueValue;
		}
		
		int strIndex = 0;
		int foundIndex = 0;
		while(strIndex <str.length()) {
			if (queueValue.endsWith(str.substring(0, strIndex))) {
				foundIndex = strIndex;
			}
			strIndex++;
		}
		
		String ret = queueValue + str.substring(foundIndex, str.length());
		return ret;
		
	}

	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		
		list.add("bcd");
		list.add("ab");
		list.add("cd");
		
		
		System.out.println(solve(list));

	}

}
