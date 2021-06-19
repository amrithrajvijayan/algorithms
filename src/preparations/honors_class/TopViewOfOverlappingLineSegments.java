package preparations.honors_class;
import java.util.*;

/*
You are given a set of line segments. Each segment consists of a closed interval of the X-axis, a color, and a 
height. When viewed from above, the color at point x on the X-axis is the color of the highest 
segment that includes x

Write a program that takes lines segments as input, and outputs the view from above for these segments. 
You can assume no two segments whose intervals overlap have the same height.
*/

public class TopViewOfOverlappingLineSegments {
	
	//Represent a Line
	static class LineSegment {
		int start;
		int end;
		int height;
		String color;
		public LineSegment(int s, int e, int h, String c) {
			this.start = s;
			this.end = e;
			this.height = h;
			this.color = c;
		}
	}
	
	// Represents a start point or end point of a line
	static class EndPoint {
		int interval;
		boolean isStart;
		LineSegment lineSegment;
		public EndPoint(int i, boolean isS, LineSegment ls) {
			this.interval = i;
			this.isStart = isS;
			this.lineSegment = ls;
		}
	}
	
	private static List<String> findTopView(List<LineSegment> lineSegments, int range) {
		
		List<EndPoint> endPoints = new ArrayList<>();
		// For each line, create two end point objects and add to endPoint list
		for (LineSegment segment : lineSegments) {
			EndPoint startPoint = new EndPoint(segment.start, true, segment);
			endPoints.add(startPoint);
			endPoints.add(new EndPoint(segment.end, false, segment));
			
		}
		// sort the end point lists based on interval.
		Collections.sort(endPoints, new Comparator<EndPoint>() {
			public int compare(EndPoint p1, EndPoint p2) {
				return p1.interval - p2.interval;
			}
		});
		
		// This tree will sort the intervals based on height
		TreeSet<EndPoint> treeSet = new TreeSet<>(new Comparator<EndPoint>() {
			public int compare(EndPoint p1, EndPoint p2) {
				return p2.lineSegment.height - p1.lineSegment.height;
			}
		});
		
		String[] retArray = new String[range];
		// for each end point, if its a start of a line, add this to the tree.. in the end of the loop, if the line ends at this point
		// remove the endPoint from the tree. In between these two, find the endPoint which has highest height
		for (EndPoint ep : endPoints) {
			
			if (ep.isStart) {
				treeSet.add(ep);
			}
			
			EndPoint topOfTree = treeSet.first();
			//capture the color of the highest line
			retArray[topOfTree.interval] = topOfTree.lineSegment.color;
			
			if (!ep.isStart) {
				treeSet.remove(ep);
			}
			
		}
		
		// The above logic has a problem. the number of endpoints may not really match the number of intervals as 
		// line may extend to multiple intervals. So if we want to find the color of an intermediate interval, where there are 
		// no line start / end, we will have to copy the last valid color in the array
		List<String> retList = new ArrayList<String>();
		retList.add(retArray[0]);
		for (int i=1; i<range; i++) {
			if (retArray[i] == null) {
				retList.add(retList.get(retList.size()-1));
			} else {
				retList.add(retArray[i]);
			}
			
		}
		
		return retList;
	}	
	
	

	public static void main(String[] args) {
		
		
		LineSegment l1 = new LineSegment(0,2,4,"yellow");
		LineSegment l2 = new LineSegment(4,5,5,"cyan");
		LineSegment l3 = new LineSegment(3,6,2,"red");
		LineSegment l4 = new LineSegment(6,8,2,"blue");
		
		List<LineSegment> list = new ArrayList<>();
		list.add(l1);
		list.add(l2);
		list.add(l3);
		list.add(l4);
		
		int range = 9;

		List<String> topView = findTopView(list, range);
		// Expected answer "yellow | yellow | yellow | red | cyan | cyan | blue | blue | blue "
		for (String color : topView) {
			System.out.print(color + " | ");
		}
		
	}

}
