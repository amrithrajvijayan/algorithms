package preparations;
import java.util.*;

public class Test {
	
	


	public static void main(String[] args) {

		int[] input = {4 ,2 , 7, 2 , 5, 2, 2, 8, 6, 4, 2 , 2, 2 , 2};
		
		int majority = input[0];
		int count = 1;
		for (int i : input) {
			if (i == majority) {
				count++;
			} else {
				count--;
				if (count == 0) {
					count = 1;
					majority = i;
				}
			}
		}
		System.out.println("Majority is "  + majority);
		
	}

}
