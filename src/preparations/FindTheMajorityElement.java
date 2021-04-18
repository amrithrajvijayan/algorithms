package preparations;

public class FindTheMajorityElement {

	public static void main(String[] args) {

		int[] arr = {3 ,6, 1, 3, 6, 3 ,3 ,7, 3, 3, 2, 3,3,3 ,1 ,3 };
		
		int majority = arr[0];
		int count = 1;
		for (int i : arr) {
			if (count == 0) {
				majority = i;
				count = 1;
			} else {
				if ( i == majority) {
					count++;
				} else 
					count --;
			}
		}
		
		System.out.println("Majority is " + majority);
	}

}
