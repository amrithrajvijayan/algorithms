package preparations.sorting;

import java.util.Arrays;

// If the values are within a range, use this alg
/// Space O(k),  Time O(n+k) in avg, best and worst cases

public class CountingSort {

	void sort(int arr[])
    {
        int n = arr.length;
        int k = 0;
        
        // find out the max value in the input
        for (int i : arr) {
        	k = Math.max(k,  i);
        }
        k++;
        
 
        // The output array that will have sorted arr
        int output[] = new int[n];
 
        // Create a count array to store count of individual
        // characters and initialize count array as 0
        int count[] = new int[k];
        for (int i = 0; i < k; ++i)
            count[i] = 0; // set count to zero for all positions
 
        // store count of each input value
        for (int i = 0; i < n; ++i)
            ++count[arr[i]];
 
        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i < k; ++i)
            count[i] += count[i - 1]; // calculate increasing sum
 
        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (int i = n - 1; i >= 0; i--) {
        	System.out.println("\narr[i]=" + arr[i]);
        	System.out.println("\ncount[arr[i]] - 1=" + (count[arr[i]] - 1));
            output[count[arr[i]] - 1] = arr[i]; // copy the data to output array based on index calculated using counts array.
            --count[arr[i]]; // update the counts array
        }
 
        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i < n; ++i)
            arr[i] = output[i];
    }
 
    public static void main(String args[])
    {
        CountingSort ob = new CountingSort();
//        int arr[] = {4, 1, 0, 3, 30, 23, 6, 2};
        int arr[] = {3,2,1};
 
        ob.sort(arr);
 
		System.out.println(Arrays.toString(arr));

    }	
	

}
