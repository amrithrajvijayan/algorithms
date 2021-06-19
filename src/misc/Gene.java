package misc;

public class Gene {


    // Complete the steadyGene function below.
    static int steadyGene(String geneString) {
        StringBuilder gene = new StringBuilder(geneString);
        if (gene.length() %4 != 0) {
            return 0;
        }
        int totalCount = gene.length();
        int aCount = totalCount/4;
        int tCount = aCount;
        int gCount = aCount;
        int cCount = aCount;
        for (int i=0; i<gene.length(); i++) {
            switch(gene.charAt(i)) {
                case 'A': {
                    aCount--;
                    continue;
                }
                case 'T': {
                    tCount--;
                    continue;
                }
                case 'G': {
                    gCount--;
                    continue;
                }
                case 'C': {
                    cCount--;
                    continue;
                }
            }
        }

        if (aCount==tCount && aCount == gCount && aCount==cCount) {
            return 0;
        }

        if (aCount < 0) {
            aCount = 0 - aCount;
        } else aCount = 0;
        if (tCount < 0) {
            tCount = 0 - tCount;
        } else tCount = 0;
        if (gCount < 0) {
            gCount = 0 - gCount;
        } else gCount = 0;
        if (cCount < 0) {
            cCount = 0 - cCount;
        } else cCount = 0;
        

        int startPointer = 0;
        int endPointer = 0;
        int aNewCount = 0, tNewCount = 0, gNewCount = 0, cNewCount=0;
        int retDiff = Integer.MAX_VALUE;
        int previusEndPointer = -1;

        while(endPointer < gene.length() && startPointer<=endPointer) {
 
        if (previusEndPointer != endPointer) {
            switch(gene.charAt(endPointer)) {
                case 'A': {
                    aNewCount++;
                    break;
                }
                case 'T': {
                    tNewCount++;
                    break;
                }
                case 'G': {
                    gNewCount++;
                    break;
                }
                case 'C': {
                    cNewCount++;
                    break;
                }
            }
            }

            if (!isCountsSatisfied(aCount, tCount, gCount, cCount, aNewCount, tNewCount, gNewCount, cNewCount)) {
                previusEndPointer = endPointer;
                endPointer++;
            } else {
                previusEndPointer = endPointer;
                int length = endPointer - startPointer +1;
                retDiff = Math.min(retDiff, length);
                char c = gene.charAt(startPointer);
                switch(c) {
                    case 'A': {
                        aNewCount--;
                        break;
                    }
                    case 'T': {
                        tNewCount--;
                        break;
                    }
                    case 'G': {
                        gNewCount--;
                        break;
                    }
                    case 'C': {
                        cNewCount--;
                        break;
                    }
                }
  

                startPointer++;
            }
        }


        System.out.println(retDiff);
        return retDiff;
    }

    private static boolean isCountsSatisfied(int aCount, int tCount, int gCount, int cCount, int aNewCount, int tNewCount, int gNewCount, int cNewCount) {

        if (aCount <= aNewCount && tCount <= tNewCount && gCount <= gNewCount && cCount <= cNewCount ) {
            return true;
        }
        return false;
    }

	
	public static void main(String[] args) {
		System.out.println(steadyGene("GAAATAAA"));

	}

}
