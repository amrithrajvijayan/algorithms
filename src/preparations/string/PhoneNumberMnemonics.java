package preparations.string;

import java.util.*;

/*
<p>
  A mnemonic is defined as a pattern of letters, ideas, or associations that
  assist in remembering something. Companies oftentimes use a mnemonic for their
  phone number to make it easier to remember.
</p>
  <p>
  Given a stringified phone number of any non-zero length, write a function that
  returns all mnemonics for this phone number, in any order.
</p>
  
  <p>
  For this problem, a valid mnemonic may only contain letters and the digits
  <span>0</span> and <span>1</span>. In other words, if a digit is able to be
  represented by a letter, then it must be. Digits <span>0</span> and
  <span>1</span> are the only two digits that don't have letter representations
  on the keypad.
</p>
  */

public class PhoneNumberMnemonics {

	Map<Character, Character[]> digitLetters = new HashMap<>();
	{
		digitLetters.put('0', new Character[] { '0' });
		digitLetters.put('1', new Character[] { '1' });
		digitLetters.put('2', new Character[] { 'a', 'b', 'c' });
		digitLetters.put('3', new Character[] { 'd', 'e', 'f' });
		digitLetters.put('4', new Character[] { 'g', 'h', 'i' });
		digitLetters.put('5', new Character[] { 'j', 'k', 'l' });
		digitLetters.put('6', new Character[] { 'm', 'n', 'o' });
		digitLetters.put('7', new Character[] { 'p', 'q', 'r', 's' });
		digitLetters.put('8', new Character[] { 't', 'u', 'v' });
		digitLetters.put('9', new Character[] { 'w', 'x', 'y', 'z' });
	}
	
	public static void main(String[] args) {
		
		PhoneNumberMnemonics pnm = new PhoneNumberMnemonics();
		String phoneNumber = "234";
		System.out.println(pnm.phoneNumberMnemonics(phoneNumber));
	}

	public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {

		ArrayList<String> retList = new ArrayList<>();
		generate(phoneNumber.toCharArray(), phoneNumber.length(), 0, retList);
		return retList;
	}

	private void generate(char[] phoneNumber, int length, int i, List<String> retList) {

		if (i == length) {
			retList.add(new String(phoneNumber));
			return;
		}

		for (Character character : digitLetters.get(phoneNumber[i])) {
			char[] newPhoneNumber = Arrays.copyOf(phoneNumber, phoneNumber.length);
			newPhoneNumber[i] = character;
			generate(newPhoneNumber, length, i + 1, retList);
		}

		return;
	}
}
