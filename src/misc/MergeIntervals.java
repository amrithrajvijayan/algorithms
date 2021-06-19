package misc;

import java.util.ArrayList;

public class MergeIntervals {
	
/*	



Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.

1, 2, 3, 5, 6, 7, 8, 10
4, 9

1, 2, 3, 10

*/
	  private class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		  }	
	
	
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    	
    	
    	if (intervals.size() ==0) {
    		intervals.add(0, newInterval);
    		return intervals;
    		
    	}
    	
		if(newInterval.end < intervals.get(0).start) {
			intervals.add(0, newInterval);
		} else if(newInterval.start > intervals.get(intervals.size()-1).end) {
			intervals.add(intervals.size(), newInterval);
		} else {
			
			Interval previousInterval = null;
			Interval currentInterval = null;
	    	int startValue = 0;
	    	int startIndex = -1;
	    	int endValue = 0;
	    	int endIndex = -1;
	    	
			for (int i=0; i<intervals.size();i++) {
	    		
	    		currentInterval = intervals.get(i);    	
	    		
	    		if (currentInterval.end > 95801093) {
	    			System.out.println("");
	    		}
	    		
	    		if (previousInterval != null && startValue == 0 && previousInterval.end < newInterval.start && newInterval.end < currentInterval.start ) {
	    			intervals.add(i, newInterval);
	    			break;
	    		} else {
	    			
	    			
	    			if (currentInterval.start <= newInterval.start && newInterval.start <= currentInterval.end) {
	        			startValue = currentInterval.start;
	        			startIndex = i;

	        		} else if (newInterval.start < currentInterval.start && startIndex == -1) {
	        			startIndex = i;
	        			startValue = newInterval.start;
	        			//continue;
	        		}
	        		
	        		
	        		if (currentInterval.start <= newInterval.end && newInterval.end <= currentInterval.end) {
	        			endValue = currentInterval.end;
	        			endIndex = i;
	        			break;

	        		} else if (newInterval.end < currentInterval.start && previousInterval != null && newInterval.end > previousInterval.end) {
	        			endValue=newInterval.end;
	        			endIndex = i-1;
	        			break;
	        		} else if(newInterval.end > currentInterval.end && i == (intervals.size()-1)){
	        			endValue= newInterval.end;
	        			endIndex = i;
	        		}
	    			
	    			
	    		}
	    			    		
	    		previousInterval = currentInterval;
			}		
			
			if (startValue !=0 && endValue != 0) {
		    	intervals.add(startIndex, new Interval(startValue, endValue));
		    	for (int j= startIndex; j<=endIndex; j++) {
		    		intervals.remove(startIndex+1);
		    	}
			}			
			
		}
		
		
		return intervals;

    }	
	
	public static void main(String[] args) {
		MergeIntervals mi = new MergeIntervals();
		
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(mi.new Interval(2503984, 6044502 ));
		intervals.add(mi.new Interval(8299441, 16663259 ));
		intervals.add(mi.new Interval(16793501, 19614603 ));
		intervals.add(mi.new Interval(19728782, 20375958 ));
		intervals.add(mi.new Interval(25968417, 28010146 ));
		intervals.add(mi.new Interval(30254350, 33374607 ));
		intervals.add(mi.new Interval(33743564, 34552113 ));
		intervals.add(mi.new Interval(34895961, 37161555 ));
		intervals.add(mi.new Interval(37636639, 43342869 ));
		intervals.add(mi.new Interval(44647063, 44992642 ));
		intervals.add(mi.new Interval(49293038, 51523422 ));
		intervals.add(mi.new Interval( 53305202, 55498385));

		
		
		intervals.add(mi.new Interval(59045828, 59565709));
		
		
		
		intervals.add(mi.new Interval(61864653, 62763559));
		intervals.add(mi.new Interval(65368847, 67301301));
		intervals.add(mi.new Interval(68261707, 69696418));
		intervals.add(mi.new Interval(71761861, 74222143));
		intervals.add(mi.new Interval(76440643, 76882070));
		intervals.add(mi.new Interval(81206484, 82877369));
		intervals.add(mi.new Interval(83619110, 89235740));
		intervals.add(mi.new Interval(89986065, 89994469));
		intervals.add(mi.new Interval(94674386, 95801093));
		intervals.add(mi.new Interval(96983158, 98983423));
		intervals.add(mi.new Interval(99682953, 99956221));

				// (31935139, 38366404), (54099301, 76986474), (87248431, 94675146)
		// [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9]
		Interval newInterval = mi.new Interval(16338702, 96742429);
		ArrayList<Interval> result = (mi.insert(intervals, newInterval));
		
		for (Interval i : result) {
			System.out.print("[" + i.start+ "," + i.end + "]");
		}
		
	}

}
