package preparations.arrays;

import java.util.*;

public class MergeOverlappingIntervals {

	public int[][] mergeOverlappingIntervals(int[][] intervals) {

		Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

		for (int i = 0; i < intervals.length; i++) {
			System.out.println(Arrays.toString(intervals[i]));
		}

		List<int[]> retList = new ArrayList<int[]>();
		retList.add(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {

			if (intervals[i][0] <= retList.get(retList.size() - 1)[1]) {
				retList.get(retList.size() - 1)[1] = Math.max(intervals[i][1], retList.get(retList.size() - 1)[1]);
			} else {
				retList.add(intervals[i]);
			}
		}

		return retList.toArray(new int[retList.size()][]);
	}
}
