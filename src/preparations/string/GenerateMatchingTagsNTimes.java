package preparations.string;
import java.util.*;

/*

  Write a function that takes in a positive integer
  numberOfTags and returns a list of all the valid strings that you
  can generate with that number of matched
  <div></div> tags.

  
  A string is valid and contains matched
  <div></div> tags if for every opening tag
  <div>, there is a closing tag </div>
  that comes after the opening tag and that isn't used as a closing tag for
  another opening tag. Each output string should contain exactly
  numberOfTags opening tags and numberOfTags closing
  tags.

  
  For example, given numberOfTags = 2, the valid strings to return
  would be:
  ["<div></div><div></div>",
    "<div><div></div></div>"].


Note that the output strings don't need to be in any particular order.

*/

public class GenerateMatchingTagsNTimes {
	
	public static void main(String[] args) {
	
		int k = 3;
		System.out.println(new GenerateMatchingTagsNTimes().generateDivTags(k));
	}
	

	public ArrayList<String> generateDivTags(int numberOfTags) {
		ArrayList<String> retList = new ArrayList<>();
		generate(numberOfTags, numberOfTags, "", retList);
		return retList;
	}

	private void generate(int openingTagsNeeded, int closingTagsNeeded, String coreString, List<String> retList) {

		if (openingTagsNeeded > 0) {
			generate(openingTagsNeeded - 1, closingTagsNeeded, coreString + "<div>", retList);
		}

		if (openingTagsNeeded < closingTagsNeeded) {
			generate(openingTagsNeeded, closingTagsNeeded - 1, coreString + "</div>", retList);
		}

		if (closingTagsNeeded == 0)
			retList.add(coreString);

	}

}
