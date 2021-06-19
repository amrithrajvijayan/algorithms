package preparations.arrays;

import java.util.*;

/*

  Write a function that takes in an array of unique integers and returns its
  powerset.

  
  The powerset P(X) of a set X is the set of all
  subsets of X. For example, the powerset of [1,2] is
  [[], [1], [2], [1,2]].

  
  Note that the sets in the powerset do not need to be in any particular order.


<pre><span class="CodeEditor-promptParameter">array = [1, 2, 3]
</pre>

<pre>[[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]
</pre>
  */
public class PowerSetOfElements {
	public static List<List<Integer>> powerset(List<Integer> array) {

		List<List<Integer>> retList = new ArrayList<List<Integer>>();

		retList.add(new ArrayList<Integer>());

		for (Integer num : array) {

			int size = retList.size();
			for (int i = 0; i < size; i++) {
				List<Integer> subList = new ArrayList<>(retList.get(i));
				subList.add(num);
				retList.add(subList);
			}

		}

		return retList;
	}
}
