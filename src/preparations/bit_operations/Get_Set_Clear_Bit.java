package preparations.bit_operations;

public class Get_Set_Clear_Bit {

	private static int getBit(int num, int pos) {
		
		int n = (num & (1 << pos-1));
		if (n == 0)
			return 0;
		else return 1;
	}
	
	private static int setBit(int num, int pos) {
		
		return (num | (1 << pos-1));
	}
	
	private static int clearBit(int num, int pos) {
		
		return (num & ~(1 << pos-1));
	}
	
	
	public static void main(String[] args) {

		int i = 11; // 1011
		int j = 3;
		
		System.out.println("Bit at " + j +"th position of " + i +" is " + getBit(i, j));
		
		i = setBit(i, j);
		
		System.out.println("After setBit : i  is " + i + " and bit at " + j +"th position of " + i +" is " + getBit(i, j));

		i = clearBit(i, j);
		
		System.out.println("After clearBit : i  is " + i + " and bit at " + j +"th position of " + i +" is " + getBit(i, j));

	}

}
