package preparations.arrays;

import java.util.*;

public class MinimumAreaRectangleGivenCoordinatesArray {

	/*
	 * You're given an array of points plotted on a 2D graph (the xy-plane). Write a
	 * function that returns the minimum area of any rectangle that can be formed
	 * using any 4 of these points such that the rectangle's sides are parallel to
	 * the x and y axes (i.e., only rectangles with horizontal and vertical sides
	 * should be considered--no rectangles with diagonal sides). If no rectangle can
	 * be formed, your function should return <span>0</span>.
	 */

	public int minimumAreaRectangle(int[][] points) {
		int minArea = Integer.MAX_VALUE;

		// The idea is to consider two coordinates and assume them to be two far end
		// corners of the rectangle. With this
		// other two coordinates can be calculated. Check if those coordinates are there
		// in the given list. if yes, calculate area and thus
		// minimum area

		Map<String, Boolean> pointsMap = new HashMap<>();
		for (int[] point : points) {
			String p = point[0] + ":" + point[1];
			pointsMap.put(p, true);
		}

		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				int firstPointX = points[i][0];
				int firstPointY = points[i][1];
				int secondPointX = points[j][0];
				int secondPointY = points[j][1];

				if (firstPointX == secondPointX || firstPointY == secondPointY)
					continue;

				if (pointsMap.get(firstPointX + ":" + secondPointY) != null
						&& pointsMap.get(secondPointX + ":" + firstPointY) != null) {

					int area = Math.abs(secondPointX - firstPointX) * Math.abs(firstPointY - secondPointY);
					// System.out.println("area = " + area);
					minArea = Math.min(minArea, area);
				}
			}
		}

		if (minArea == Integer.MAX_VALUE)
			return 0;

		return minArea;
	}
}
