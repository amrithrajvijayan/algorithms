package preparations.dynamic_programming;

import java.util.*;

/*
  You're given a non-empty array of arrays where each subarray holds three
  integers and represents a disk. These integers denote each disk's width,
  depth, and height, respectively. Your goal is to stack up the disks and to
  maximize the total height of the stack. A disk must have a strictly smaller
  width, depth, and height than any other disk below it.

  
  Write a function that returns an array of the disks in the final stack,
  starting with the top disk and ending with the bottom disk. Note that you
  can't rotate disks; in other words, the integers in each subarray must
  represent <span>[width, depth, height] at all times.

  
  You can assume that there will only be one stack with the greatest total
  height.

  
  Sample Input
  
  disks = [[2, 1, 2], [3, 2, 3], [2, 2, 8], [2, 3, 4], [1, 3, 1], [4, 4, 5]]

  
  Sample output
  [[2, 1, 2], [3, 2, 3], [4, 4, 5]]

// 10 (2 + 3 + 5) is the tallest height we can get by
// stacking disks following the rules laid out above.

*/
public class DiskStacking {
  public static List<Integer[]> diskStacking(List<Integer[]> disks) {
    if (disks == null) {
			return new ArrayList<Integer[]>();
		}
		if (disks.size() == 1) {
			return disks;
		}
		disks.sort((disk1, disk2) -> disk1[2].compareTo(disk2[2])); 
		
		int[] heights = new int[disks.size()];
		int[] positions = new int[disks.size()];
		
		for (int i=0; i<disks.size(); i++) {
			heights[i] = disks.get(i)[2];
			positions[i] = -1;
		}
		int maxHeight = Integer.MIN_VALUE;
		int maxHeightPos = -1;
		for (int i=0; i<disks.size(); i++) {
			for (int j=i-1; j>=0; j--) {
				if (disks.get(j)[2] < disks.get(i)[2] && disks.get(j)[0] < disks.get(i)[0] && disks.get(j)[1] < disks.get(i)[1]) {
					if (heights[j] + disks.get(i)[2] > heights[i]) {
						heights[i] = heights[j] + disks.get(i)[2];
						positions[i] = j;
						maxHeight = Math.max(maxHeight, heights[i]);
						if (maxHeight == heights[i])
							maxHeightPos = i;
					}
				} else {
						maxHeight = Math.max(maxHeight, heights[i]);
						if (maxHeight == heights[i])
							maxHeightPos = i;
				}
			}
		}
		
		
		List<Integer[]> retValues = new ArrayList<Integer[]>();
		int i = maxHeightPos;
		while(i>=0) {
			retValues.add(disks.get(i));
			i = positions[i];
		}
		Collections.reverse(retValues);
		
		
    return retValues;
  }
}
