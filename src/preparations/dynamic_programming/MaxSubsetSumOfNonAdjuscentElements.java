package preparations.dynamic_programming;

/*
  Write a function that takes in an array of positive integers and returns the
  maximum sum of non-adjacent elements in the array.

  <p>If the input array is empty, the function should return <span>0</span>.</p>
  
  <pre><span class="CodeEditor-promptParameter">array</span> = [75, 105, 120, 75, 90, 135]
</pre>
  
  330 <span class="CodeEditor-promptComment">// 75 + 120 + 135</span>

  */

public class MaxSubsetSumOfNonAdjuscentElements {
  public static int maxSubsetSumNoAdjacent(int[] array) {
    
		if(array.length == 0){
			return 0;
		} else if (array.length == 1) {
			return array[0];
		}
		int[] maxSums = array.clone();
		maxSums[1] = Math.max(array[0], array[1]);
		
		for (int i=2; i< array.length; i++) {
			maxSums[i] = Math.max ( maxSums[i-1], maxSums[i-2] + array[i]);
		}
		
		return maxSums[array.length-1];
  }
  
  
}
