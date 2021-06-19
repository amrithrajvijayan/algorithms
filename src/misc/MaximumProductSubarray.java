package misc;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		MaximumProductSubarray mp = new MaximumProductSubarray();
		
		int[] values = {-2, -3, 0, -2, -40, -1, 3};
		
		
		int startPos = 0;
		int endPos = 1;
		int currentProduct = values[startPos];
		
		while(endPos < values.length) {
			int newProduct = currentProduct * values[endPos]; 
			//System.out.println("temporary new product is " + newProduct);
			if (newProduct <= currentProduct) {
				System.out.print("\nproduct : " + currentProduct + " -> ");
				for (int x= startPos; x < endPos; x++) {
					System.out.print(values[x] + " ");
				}
				startPos = endPos;
				endPos = startPos + 1;
				currentProduct= values[startPos];
			} else {
				currentProduct = newProduct;
				endPos++;
			}

			
		}
		
		
		
		
		
		
	}

}
