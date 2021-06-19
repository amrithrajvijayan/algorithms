package preparations.sorting;

import java.util.Arrays;

// Best sorting alg for almost sorted data
public class InsertionSort {
	
	
	private static void insertionSort(int[] a) {
	    for(int k=1; k<a.length; k++)   
	    {  
	        int temp = a[k];  
	        int j= k-1;  
	        while(j>=0 && temp <= a[j])  
	        {  
	            a[j+1] = a[j];   
	            j = j-1;  
	        }  
	        a[j+1] = temp;  
	    }  
	}
	
	
	public static void main(String[] args) {
		//int[] input = {4, 1, 0, 3, 30, 23, 6, 2};
		int[] input = {1, 2, 3, 5, 4};
		insertionSort(input);
		System.out.println(Arrays.toString(input));
	}

}
