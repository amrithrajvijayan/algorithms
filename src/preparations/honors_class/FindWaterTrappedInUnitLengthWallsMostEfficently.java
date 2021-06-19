package preparations.honors_class;

import java.util.*;

// Time: O(n).  Space: O(1)
public class FindWaterTrappedInUnitLengthWallsMostEfficently {

	private static int getIndexOfMaxElement(List<Integer> list) {
		int index = 0;
		for (int i = 0; i < list.size(); i++) {

			if (list.get(index) < list.get(i))
				index = i;
		}
		return index;
	}

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>(Arrays.asList(3, 2, 1, 6, 2, 4, 6, 4));
		System.out.println(calculateTrappingWaterEfficient(list));
	}

	private static int calculateTrappingWaterEfficient(List<Integer> list) {

		if (list.size() == 0)
			return 0;

		int highestIndex = getIndexOfMaxElement(list);
		int waterQuantity = 0;
		int maxLeft = list.get(0);
		for (int i = 1; i < highestIndex; i++) {
			if (list.get(i) > maxLeft) {
				maxLeft = list.get(i);
			} else {
				waterQuantity = waterQuantity + maxLeft - list.get(i);
			}
		}

		int maxRight = list.get(list.size() - 1);
		for (int i = list.size() - 2; i > highestIndex; i--) {
			if (list.get(i) > maxRight) {
				maxRight = list.get(i);
			} else {
				waterQuantity = waterQuantity + maxRight - list.get(i);
			}

		}

		return waterQuantity;
	}

}
