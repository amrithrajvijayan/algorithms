package preparations.greedy;

import java.util.*;

// Sum of value should be maximum, where as weight should be within capacity

public class DivisibleKnapSackProblem {
	
	private static class KnapSackEntry {
		int value;
		int weight;
		float valuePerWeight;
		int index;
		
		public KnapSackEntry(int v, int w, float vPerW, int in) {
			this.value = v;
			this.weight = w;
			this.valuePerWeight = vPerW;
			this.index = in;
		}
	}

	private static float maxValue(int[] values, int[] weights, int capacity) {
		float maxValue = 0;
		// priority queue based on value per weight.
		PriorityQueue<KnapSackEntry> pq = new PriorityQueue<KnapSackEntry>(new Comparator<KnapSackEntry>() {
				public int compare(KnapSackEntry e1, KnapSackEntry e2) {
					return (int) (e2.valuePerWeight - e1.valuePerWeight); 
				}
		});
		// add all entries to Priority queue
		for (int i=0; i<values.length; i++) {
			pq.offer(new KnapSackEntry(values[i], weights[i], ((float)values[i]/(float)weights[i]), i));
		}
		
		int[] usedWeights = new int[weights.length];
		
		KnapSackEntry kse = pq.poll();
		int capacityUsed = 0;
		
		while(true) {
			int index = kse.index;
			maxValue = maxValue + kse.valuePerWeight;
			
			usedWeights[index]++;
			if (usedWeights[index] == weights[index]) {
				kse = pq.poll();
			}
			capacityUsed++;
			if (capacityUsed == capacity)
				break;
		}
		
		
		return maxValue;
	}

	// Time complexity : n*log n + c
	private static float maxValueEfficient(int[] values, int[] weights, int capacity) {
		float maxValue = 0;
		
		KnapSackEntry[] knapSackEntries = new KnapSackEntry[values.length];
		
		for (int i=0; i<values.length; i++) {
			knapSackEntries[i]  = new KnapSackEntry(values[i], weights[i], ((float)values[i]/(float)weights[i]), i);
		}
		
		Arrays.sort(knapSackEntries, new Comparator<KnapSackEntry>() {
				public int compare(KnapSackEntry e1, KnapSackEntry e2) {
					return (int) (e2.valuePerWeight - e1.valuePerWeight); 
				}
		});
		
		int[] usedWeights = new int[weights.length];
		
		int knapsackEntriesIndex = 0;
		
		KnapSackEntry kse = knapSackEntries[knapsackEntriesIndex];
		
		knapsackEntriesIndex++;
		
		int capacityUsed = 0;
		
		while(capacityUsed <= capacity) {
			int index = kse.index;
			maxValue = maxValue + kse.valuePerWeight;
			
			usedWeights[index]++;
			
			if (usedWeights[index] == weights[index]) {
				kse = knapSackEntries[knapsackEntriesIndex];
				knapsackEntriesIndex++;
			}
			capacityUsed++;
			if (capacityUsed == capacity)
				break;
		}
		
		
		return maxValue;
	}	
	
	public static void main(String[] args) {
		int[] values = { 10, 5, 15, 7, 6, 18, 3 };
		int[] weights = { 2, 3, 5, 7, 1, 4, 1 };

		int capacity = 10;
		System.out.println("Maximum value is " + maxValueEfficient(values, weights, capacity));
	}

}
