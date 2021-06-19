package preparations.queue;

import java.util.*;

/*
Implement a queue with enqueue, dequeue, and max operations. 
The max operation returns the maximum element currently stored in the queue.
*/

class QueueWithMax<T extends Integer> {
	Queue<T> queue;
	Deque<T> maxQueue;

	public QueueWithMax() {
		queue = new LinkedList<T>();
		maxQueue = new LinkedList<T>();
	}

	public void enQueue(T input) {
		queue.offer(input);
		// if the new element coming is greater than the last element in the maxQueue,
		// replace
		// all the lower elements from the maxQueue from back to front. since new
		// element comes later to all those elements
		// the new element will be the max for all those values. So no need to keep them
		// in the queue.
		if (maxQueue.size() > 0) {
			T lastElement = maxQueue.peekLast();
			if (input > lastElement) {
				while (maxQueue.size() > 0 && maxQueue.peekLast() < input)
					maxQueue.removeLast();
			}
		}
		maxQueue.addLast(input);
	}

	public T deQueue() {
		T value = queue.poll();
		// If the removed element is same as the first element of maxQueue, remove the
		// element from maxQueue as well.
		// else nothing to be done..
		if (value == maxQueue.peekFirst()) {
			maxQueue.removeFirst();
		}
		return value;
	}

	public T max() {
		// first value of maxQueue will be the max, always
		return maxQueue.peekFirst();
	}
}

public class QueueWithMaxApi {

	public static void main(String[] args) {
		QueueWithMax<Integer> q = new QueueWithMax<Integer>();

		q.enQueue(3);
		q.enQueue(1);
		q.enQueue(2);
		System.out.println("1 Max = " + q.max());

		q.deQueue();
		System.out.println("2 Max = " + q.max());

		q.enQueue(5);
		System.out.println("3 Max = " + q.max());

		q.enQueue(2);
		q.enQueue(1);
		q.deQueue();
		q.deQueue();
		q.deQueue();
		System.out.println("4 Max = " + q.max());

	}

}
