package misc;

import java.util.*;

public class CharacterNumericExample {
	
	 static String biggerIsGreater(String test) {

	        
	        String characters = "abcdefghijklmnopqrstuvwxyz";
	        
	        
	        char[] testChars = test.toCharArray();
	        int maxCharacterValue = -1;
	        int maxCharacterPos = -1;
	        for (int i = 0; i< testChars.length; i++) {
	            int value = characters.indexOf(testChars[i]);
	            if (value > maxCharacterValue) {
	                maxCharacterValue = value;
	                maxCharacterPos = i;
	            } 
	        }
	        int exchangePos1 = -1;
	        int exchangePos2 = -1;
	        boolean previousWasMax = false;
	        for (int i = testChars.length -1 ; i >= 0; i--) {
	            if (i == maxCharacterPos) {
	                exchangePos1 = i;
	                previousWasMax = true;
	                continue;
	            } else {
	            	if (previousWasMax) {
		                exchangePos1 = i + 1;	            		
		            	break;
	            	} else {
	            		exchangePos1 = i;
	            		break;
	            	}
	            }
	        }
	        int exchangePos1Value = characters.indexOf(testChars[exchangePos1]);
	        for (int i = (exchangePos1 -1); i >= 0; i--) {
	            int value = characters.indexOf(testChars[i]);
	            if (value < exchangePos1Value) {
	                exchangePos2 = i;
	                break;
	            }
	        }
	        if ((exchangePos1 > -1) && (exchangePos2 > -1) && (exchangePos1 != exchangePos2)) {
	            char temp = testChars[exchangePos1];
	            testChars[exchangePos1] = testChars[exchangePos2];
	            testChars[exchangePos2] = temp;
	            String finalValue = new String(testChars);
	            return finalValue;
	        } else {
	            return "no answer";
	        }
	        
	        
	    }

	public static void main(String[] args) {
		
		//System.out.println(biggerIsGreater("ab"));
		//System.out.println(biggerIsGreater("bb"));
		//System.out.println(biggerIsGreater("hefg"));
		System.out.println(biggerIsGreater("dkhc"));
		
		

	}

}
