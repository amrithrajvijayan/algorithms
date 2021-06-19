package preparations.string;

import java.util.Arrays;

/*
Consider the following two rules that are to be applied to an array of characters.
� Replace each 'a' by two 'd's.
� Delete each entry containing a 'b'.
For example, applying these rules to the array (a,c,d,b,b,c,a ) results in the array
 (d,d, c,d,c,d, d )
*/
public class CharacterReplacement {

	// do in O(n) time and O(1) space
	private static char[] replaceChars(char[] arr) {

		// in first iteration, remove all 'b's.
		int posToCopy = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 'b') {
				if (i != posToCopy)
					arr[posToCopy] = arr[i];
				posToCopy++;
			}
		}
		if (posToCopy < arr.length) {
			Arrays.fill(arr, posToCopy, arr.length, '\0');
		}

		// in second iteration, start from the end and replace 'a's with two 'd's
		int toTakePointer = posToCopy - 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[toTakePointer] == 'a') {
				arr[i] = 'd';
				arr[i - 1] = 'd';
				i--;
			} else {
				arr[i] = arr[toTakePointer];
			}
			toTakePointer--;
		}

		return arr;
	}

	public static void main(String[] args) {
		char[] arr = { 'a', 'c', 'd', 'b', 'b', 'c', 'a' };
		System.out.println(Arrays.toString(replaceChars(arr)));
	}

}
