package preparations.bit_operations;

/*
Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print the binary representation
*/
public class BinaryToString {

	public static void main(String[] args) {
		
		double value = 0.20;
		
		StringBuffer binary = new StringBuffer();
		binary.append(".");
		while(value > 0) {
			
			double r = value * 2;
			if (r >=1) {
				binary.append("1");
				value = r - 1;
			} else {
				binary.append("0");
				value = r;
			}
				
		}
		
		System.out.println(binary.toString());
	}

}
