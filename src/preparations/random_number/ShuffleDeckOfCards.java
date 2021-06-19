package preparations.random_number;

/*
Write a method to shuffle a deck of cards. It must be a perfect shuffle-in other words, each of the 52! 
permutations of the deck has to be equally likely. Assume that you are given a random number generator 
which is perfect
*/

public class ShuffleDeckOfCards {

	
	private static int rand(int start, int end) {
		return start + (int)(Math.random() * (end-start+1));	
	}
	
	private static void shuffleDeckIteratively(int[] deck) {
		
		for (int i=0; i<deck.length; i++) {
			int k = rand(0, i);
			int temp = deck[k];
			deck[k] = deck[i];
			deck[i] = temp;
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int[] cards = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
				21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36,37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
				48, 49, 50, 51, 52};
		
		shuffleDeckIteratively(cards);
		
		for(int i : cards) {
			System.out.print(i+" ");
		}
	}

}
