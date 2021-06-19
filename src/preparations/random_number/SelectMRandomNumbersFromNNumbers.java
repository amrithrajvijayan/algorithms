package preparations.random_number;
import java.util.*;

public class SelectMRandomNumbersFromNNumbers {
	
	
	private static int[] generateRandom(int[] arr, int m, int n) {
		int[] responseArr = new int[n];
		int pos = 0;
		Random random = new Random();
		
		int rangeMax = m;
		while(rangeMax > 0 && pos < n) {
			int randomNumber = generateRandomWithinRange(rangeMax, random);
			responseArr[pos] = arr[randomNumber];
			pos++;
			
			int temp = arr[rangeMax];
			arr[rangeMax] = arr[randomNumber];
			arr[randomNumber] = temp;
			rangeMax--;
		}
		
		return responseArr;
	}
	
	private static int generateRandomWithinRange(int m, Random random) {
		//return (int)(Math.random() * m);
		return random.nextInt(m);
	}
	
	
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		int m = arr.length-1;
		int n = 10;
		
		int[] randomNumbers = generateRandom(arr, m, n);
		
		System.out.println(Arrays.toString(randomNumbers));
		
	}

}
