package misc;
import java.util.*;


public class MergeSortedArrays {
	
	private static class ArrayElement {
		int value;
		int positionOfArray;
		int positionWithinArray;
		
		public ArrayElement(int v, int pa, int pv) {
			this.value = v;
			this.positionOfArray = pa;
			this.positionWithinArray = pv;
		}
	}
	
	
	
	private static int[] mergeArrays(int[][] arr) {
		
		int[] retArray;
		
		PriorityQueue<ArrayElement> pq = new PriorityQueue<ArrayElement>(new Comparator<ArrayElement>() {
			public int compare(ArrayElement ae1, ArrayElement ae2) {
				return ae1.value - ae2.value;
			}
		});
		int size = 0;
		for (int i=0; i<arr.length; i++) {
			pq.offer(new ArrayElement(arr[i][0], i, 0));
			size = size + arr[i].length;
		}
		
		
		
		retArray = new int[size];
		int retArrayIndex = 0;
		while(!pq.isEmpty()) {
			
			ArrayElement ae = pq.poll();
			retArray[retArrayIndex]= ae.value;
			retArrayIndex++;
			
			int arrayPos = ae.positionOfArray;
			int posWithinArray = ae.positionWithinArray;
			posWithinArray++;
			if (arr[arrayPos].length > posWithinArray) {
				pq.offer(new ArrayElement(arr[arrayPos][posWithinArray], arrayPos, posWithinArray));
			}
		}
		
		
		
		
		return retArray;
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		int[][] arr = {
				{1, 4, 8, 12, 16, 20},	
				{2, 5, 9, 13},
				{3, 6, 10},
				{0, 11, 21, 22, 23, 25},
		};
		
		
		System.out.println("Merged array is \n"+Arrays.toString(mergeArrays(arr)));

	}

}
