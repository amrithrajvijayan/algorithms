package misc;
import java.util.*;

public class ClimbingLedger {
	
	
	public static void main(String[] args) {
		int[] input1 = {1};
		int[] input2 = {1, 1};
		for (int i: climbingLeaderboard(input1, input2)) {
			System.out.println(i);
		}
	
	}
	
	 
    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {

        Set<Integer> scoresSet = new HashSet<Integer>();
        for (int score : scores) {
            scoresSet.add(score);
        }
        Integer[] sortedUniqueScores = new Integer[scoresSet.size()];
        scoresSet.toArray(sortedUniqueScores);

        Arrays.sort(sortedUniqueScores, Collections.reverseOrder());

        int[] returnArray = new int[alice.length];
        int returnArrayIndex = 0;
        int midPoint = 0;

        for (int i : sortedUniqueScores) {
            System.out.print(i + " ");
        }
        System.out.println("");

        for (int score : alice) {
            System.out.println("\nconsidering score = " + score);
            int startIndex = 0, endIndex = sortedUniqueScores.length -1;
            
            returnArray[returnArrayIndex] = -1;
            while(startIndex <= endIndex && returnArray[returnArrayIndex] == -1) {
                System.out.println("startIndex = " + startIndex + "-> " + sortedUniqueScores[startIndex] +" and endIndex = " + endIndex + " -> " +sortedUniqueScores[endIndex]);
                if (score == sortedUniqueScores[startIndex]) {
                    returnArray[returnArrayIndex] = startIndex + 1;
                    System.out.println("1:  returnArray[returnArrayIndex]= " + returnArray[returnArrayIndex]);
                } else if (score == sortedUniqueScores[endIndex]) {
                    returnArray[returnArrayIndex] = endIndex + 1;
                    System.out.println("2:  returnArray[returnArrayIndex]= " + returnArray[returnArrayIndex]);
                } else if (endIndex - 1 == startIndex) {
                    if (score > sortedUniqueScores[startIndex]) {
                        returnArray[returnArrayIndex] = startIndex + 1;
                    System.out.println("3:  returnArray[returnArrayIndex]= " + returnArray[returnArrayIndex]);
                    } else if (score < sortedUniqueScores[endIndex]){
                        returnArray[returnArrayIndex] = endIndex + 2;
                    System.out.println("4:  returnArray[returnArrayIndex]= " + returnArray[returnArrayIndex]);
                    } else {
                        returnArray[returnArrayIndex] = startIndex + 2;
                    System.out.println("5:  returnArray[returnArrayIndex]= " + returnArray[returnArrayIndex]);
                    }
                }


                midPoint = (endIndex - startIndex) / 2;
                System.out.println("mid point is " + midPoint);
                if (sortedUniqueScores[startIndex + midPoint] < score ) {
                    endIndex = startIndex + midPoint;
                } else {
                    startIndex = startIndex + midPoint;
                }
            }
            returnArrayIndex++;
        }


        return returnArray;
    }  
    

}
