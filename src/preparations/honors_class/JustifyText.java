package preparations.honors_class;

import java.util.*;

public class JustifyText { 

	public static void main(String[] args) {
		String[] words = new String[] { "Hi", "hello", "how", "are", "you", "doing", "I", "am", "fine", "and", "good" };
		int length = 14;
		List<String> list = justifyText(words, length);
		for (String s : list) {
			System.out.println(s);
		}
	}
	
	private static List<String> justifyText(String[] words, int length) {
		
		List<String> retList = new ArrayList<>();
		
		int lengthOfCurrentLine = 0; // current line length
		int numberOfWordsInCurrentLine = 0; // number of words till now ( for adding space )
		int lineStartWordIndex = 0; // index of array where current line starts
		
		for (int i=0; i<words.length; i++) {
			// possible new length if we include words[i] in current line.
			int probableNewLength = lengthOfCurrentLine + numberOfWordsInCurrentLine - 1 + words[i].length();
			
			if(probableNewLength < length) { // if current word could be included in the current line, just update length and number of words. do not add the word yet
				lengthOfCurrentLine = lengthOfCurrentLine + words[i].length();
				numberOfWordsInCurrentLine++;
			} else if (probableNewLength == length) { // if new length match the length limit, then do below
				
				addNewLine(retList, words, lineStartWordIndex, i, i - lineStartWordIndex); // add words from lineStartIndex till 'i' as a new line (i is inclusive)
				
				lengthOfCurrentLine = 0;//  reset current line length
				numberOfWordsInCurrentLine = 0; // reset number of words in current line
				lineStartWordIndex = i+1; // the next line should start from next word as current word is included in current line
			} else {

				
				addNewLine(retList, words, lineStartWordIndex, i-1, length - lengthOfCurrentLine); // add words from lineStartIndex till 'i-1' as a new line. Cannot include ith word since that will exceed the line length limit
				
				lengthOfCurrentLine = words[i].length(); // since the current word is not included in current line, current line length is current word length
				numberOfWordsInCurrentLine = 1; // number of words is 1 because of above reason
				lineStartWordIndex = i; // the next line should start from current 'i' as its not included in current line.
			}
		}
		
		// if there are any outstanding words ( for last line ), append them too.
		if (lengthOfCurrentLine > 0) {
			addNewLine(retList, words, lineStartWordIndex, words.length-1, 0); 				
		}
				
		return retList;
	}
	
	// construct a line with proper spacing from words with index startIndex, till endIndex (inclusive)
	private static void addNewLine(List<String> retList, String[] words, int startIndex, int endIndex, int spaceCount) {
		
		int numOfWords = (endIndex-startIndex + 1);
		
		StringBuilder strBuilder = new StringBuilder();
		
		for (int j = startIndex; j < endIndex; j++) {
			// append word
			strBuilder.append(words[j]);
			numOfWords--;
			// calculate approximate number of spaces after each word. It will be total outstanding space count / number of words
			int numOfCurSpaces = (int)Math.floor(spaceCount/numOfWords);
			// append spaces
			for (int k=1; k<=numOfCurSpaces; k++)
				strBuilder.append(" ");
			// reduce outstanding space count
			spaceCount = spaceCount - numOfCurSpaces;
		}
		// append last word
		strBuilder.append(words[endIndex]);
		// if there are still pending spaces, append it
		for (int i = 0; i < spaceCount; i++) {
			strBuilder.append(" ");
		}
				
		retList.add(strBuilder.toString());
	}
	

}
