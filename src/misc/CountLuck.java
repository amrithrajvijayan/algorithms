package misc;

public class CountLuck {

	
    static String countLuck(String[] matrix, int k) {

    	int count = 0;
    	int currentX=0;
    	int currentY=0;
    	int direction = 0; // 1 -> right, 2 -> left 3 -> top 4 -> bottom
    	
    	for (int i=0; i<matrix.length; i++) {
    		if (matrix[i].indexOf('M') != -1) {
    			currentX = i;
    			currentY = matrix[i].indexOf('M');
    		}
    	}
    	
    	
    	while(count < k) {
    		
    		char leftEntry = (currentY > 0 ? matrix[currentX].charAt(currentY-1) : '~');
    		char rightEntry = (currentY < (matrix[currentX].length()-1) ? matrix[currentX].charAt(currentY+1) : '~');
    		char topEntry = (currentX > 0 ? matrix[currentX-1].charAt(currentY) : '~');
    		char bottomEntry = (currentX < (matrix.length -1) ? matrix[currentX+1].charAt(currentY) : '~');
    		
    		
    		
    	}
    	
    	return "Oops!";
    }
	
	
	public static void main(String[] args) {
		
		String[] matrix = {
				".X.X......X",
				".X*.X.XXX.X",
				".XX.X.XM...",
				"......XXXX."			
		};
		int k = 3;
		System.out.println(countLuck(matrix, k));
	}

}
