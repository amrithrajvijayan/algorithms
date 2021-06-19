package preparations.queue;

import java.util.*;
/*
	Write a ContinuousMedianHandler class that supports:
    The continuous insertion of numbers with the insert method.
    The instant (O(1) time) retrieval of the median of the numbers that have
    been inserted thus far with the getMedian method.
*/

public class ContinuousMedianConstantTime {

	static class ContinuousMedianHandler {
		double median = 0;
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> (b - a));
		PriorityQueue<Integer> minQueue = new PriorityQueue<>();

		public void insert(int number) {
			if (maxQueue.size() == 0) {
				maxQueue.add(number);
				median = number;
				return;
			}
			if (maxQueue.peek() < number) {
				minQueue.add(number);
			} else {
				maxQueue.add(number);
			}

			if (maxQueue.size() == minQueue.size()) {
				median = (double) (maxQueue.peek() + minQueue.peek()) / 2;
			} else {
				if (Math.abs(maxQueue.size() - minQueue.size()) == 1) {
					median = (maxQueue.size() > minQueue.size() ? maxQueue.peek() : minQueue.peek());
				} else {
					if (maxQueue.size() > minQueue.size()) {
						int num = maxQueue.poll();
						minQueue.add(num);
					} else {
						int num = minQueue.poll();
						maxQueue.add(num);
					}
					median = (double) (maxQueue.peek() + minQueue.peek()) / 2;
				}
			}
		}

		public double getMedian() {
			return median;
		}
	}

}
