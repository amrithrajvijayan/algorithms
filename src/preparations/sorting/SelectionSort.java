package preparations.sorting;

import java.util.Arrays;

public class SelectionSort {
	
    public static void selectionSort(int[] arr){  
        for (int i = 0; i < arr.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < arr.length; j++){  
                if (arr[j] < arr[index]){  
                    index = j;//searching for lowest index  
                }  
            }  
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;  
        }  
    }  	

	public static void main(String[] args) {
		int[] input = {4, 1, 0, 3, 30, 23, 6, 2};
		selectionSort(input);
		System.out.println(Arrays.toString(input));
	}

}
