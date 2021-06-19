package preparations.arrays;
import java.util.*;

/*
<p>
  You're given a list of time intervals during which students at a school need a
  laptop. These time intervals are represented by pairs of integers
  <span>[start, end]</span>, where <span>0 &lt;= start &lt; end</span>. However,
  <span>start</span> and <span>end</span> don't represent real times; therefore,
  they may be greater than <span>24</span>.
</p>
  
  <p>
  No two students can use a laptop at the same time, but immediately after a
  student is done using a laptop, another student can use that same laptop. For
  example, if one student rents a laptop during the time interval
  <span>[0, 2]</span>, another student can rent the same laptop during any time
  interval starting with <span>2</span>.
</p>
  
  <p>
  Write a function that returns the minimum number of laptops that the school
  needs to rent such that all students will always have access to a laptop when
  they need one.
</p>
*/
public class LaptopRentals {
  public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
    if (times.size() == 0)
			return 0;
		
		List<Integer> startTimes = new ArrayList();
		List<Integer> endTimes = new ArrayList();
		// separate out start times and end times into two lists
		for (ArrayList<Integer> time : times) {
			startTimes.add(time.get(0));
			endTimes.add(time.get(1));
		}
		//sort the two lists
		Collections.sort(startTimes);
		Collections.sort(endTimes);
		
		System.out.println(startTimes);
		System.out.println(endTimes);
		
		int laptopCount = 0;
		int startIndex = 0;
		int endIndex = 0;
		int countMax = 0;
		while(startIndex < times.size()) {
			
			if (startTimes.get(startIndex) < endTimes.get(endIndex)) {
				laptopCount++;
				startIndex++;
				countMax = Math.max(countMax, laptopCount);
			} else if (startTimes.get(startIndex) > endTimes.get(endIndex)) {
				laptopCount--;
				endIndex++;
			} else {
				startIndex++;
				endIndex++;
			}
			
			
		}
		
		
    return countMax;
  }
}
