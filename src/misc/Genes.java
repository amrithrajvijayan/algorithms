package misc;

public class Genes {

	
    // Complete the steadyGene function below.
    static int steadyGene(String gene) {
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

        System.out.println("string is " + gene);
        System.out.println("aCount="+aCount);
        System.out.println("tCount="+tCount);
        System.out.println("gCount="+gCount);
        System.out.println("cCount="+cCount);
        
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
        
        System.out.println("aCount="+aCount);
        System.out.println("tCount="+tCount);
        System.out.println("gCount="+gCount);
        System.out.println("cCount="+cCount);
        //int overallCount = aCount+tCount+gCount+cCount;

        int startPointer = 0;
        int endPointer = 0;
        int aNewCount = 0, tNewCount = 0, gNewCount = 0, cNewCount=0;
        int retDiff = Integer.MAX_VALUE;
        int previusEndPointer = -1;

        while(endPointer < gene.length() && startPointer<=endPointer) {
            System.out.println("\nstart="+startPointer+", end="+endPointer);

        System.out.println("1---current counts---");
        System.out.print("aNewCount="+aNewCount);
        System.out.print(", tNewCount="+tNewCount);
        System.out.print(", gNewCount="+gNewCount);
        System.out.print(", cNewCount="+cNewCount+"\n");
        
        
        System.out.println("char is " + gene.charAt(endPointer));
        System.out.println("previusEndPointer="+previusEndPointer+", endPointer="+endPointer);
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
        System.out.println("2---updated counts---");
        System.out.print("aNewCount="+aNewCount);
        System.out.print(", tNewCount="+tNewCount);
        System.out.print(", gNewCount="+gNewCount);
        System.out.print(", cNewCount="+cNewCount+"\n");

            if (!isCountsSatisfied(aCount, tCount, gCount, cCount, aNewCount, tNewCount, gNewCount, cNewCount)) {
                previusEndPointer = endPointer;
                endPointer++;
                System.out.println("new endPOinter ="+endPointer);
            } else {
                previusEndPointer = endPointer;
                int length = endPointer - startPointer +1;
                System.out.println("new diff calculated = " + length);
                retDiff = Math.min(retDiff, length);
                System.out.println("retDiff = " + retDiff);
                char c = gene.charAt(startPointer);
                System.out.println("removing " + c);
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
        System.out.println("3---updated after removal counts---");
        System.out.print("aNewCount="+aNewCount);
        System.out.print(", tNewCount="+tNewCount);
        System.out.print(", gNewCount="+gNewCount);
        System.out.print(", cNewCount="+cNewCount+"\n");

                startPointer++;
                //endPointer++;
                System.out.println("new startPointer ="+startPointer);
            }
        }


        System.out.println(retDiff);
        return retDiff;
    }

    private static boolean isCountsSatisfied(int aCount, int tCount, int gCount, int cCount, int aNewCount, int tNewCount, int gNewCount, int cNewCount) {

        if (aCount <= aNewCount && tCount <= tNewCount && gCount <= gNewCount && cCount <= cNewCount ) {
            System.out.println("returning true");
            return true;
        }
        System.out.println("returning false");
        return false;
    }
	
	
	
	public static void main(String[] args) {
		System.out.println(steadyGene("TATATAGCTTGTCTCCCTAATGTTAGTTCATGCTCGTAAGAGAACTTAGCCTACTAGGACGAGAGAACCGCACGGCGTCGTGAGGTATTTTTCGTAGGACACGCCAGATAGACGGTGGCAATGCCCGTTCAATATGACGCGATGTACGGCTAATGGGAACACTGCCCGACGCGTCTTTAGGACTGTGAGTTGCGGGTTACAGCTATGGTCTTATTGGTATCCGGCCCCTTTCGAGTCGCGATGCGCCTGCCACCACGATATTCGCCCGAAACGCGATTTGTGGGCGAGGTAGTCGTGTTCAACCCTGTAAATTTCCCTAGGTATAATCGTTCTAAGGTTCGCACATACACATCCACACCTACCTTTACACAGTTCGAGGTTCTATACGTCCTCTGAGTGCGTGTTAACACGCCCGTAAATGGGCATTTGGAGTCAGACCAGTACTTTGCGATAAACTTTACTTCCGCGAGACCTGTCCCTGGAACCCTGTTGTAAGGGTTAGGGTTTAATAGCTCCATGTCGTGTGCCTATAAGAAAAGGACGAATGGTGACAGTCCGGCTTAGCCAGGACAATGCGTGGCTGACGACGTCCAGGGTAAATTGAGTTGAATTCGCCTAATTTTAGGGTGTCTTGGTTCAATGAGGTGTCGACTTAACAAAAGGCGACATCAGTTGTCATCTTGCCTTGATAAAGTAAAACACGTGAATAGCCTATCCGGTCTGACCCCCGGGCCATGTGCTTCACCCAGGGAGCATCGCCGCTCTAGAGACGGTGTTCGTAGTCTCGATAACATGTGGGGTAATATAGAATATCCAAGACCGGTAGGAGGGGCGGTTCCGCGTCATAAGAAGTCCCAACGTGGCCTGCCACGTTCAAACAGGATACGCTATAACAGCTTCGTGGGTAATTGATGGATACGCCCGCAGGCTACCCATGCTCTTGCGATTTTGCAACCCTCGGAACCGTCACTCGTACACCCAGACATCATCTCATACAATTGCCTCACCTTCATGCCGGTACATAGGTGCCATCTCCGCTTAAGAATCCTCGCAGCAATTAATGTGACAGCACGCTAGTCCACTAGCGTATGATTACGCCACCGGGCCACCATGGACAAAAACGTTGAATTCCGACTAATAGACGAGTGTCCGATCGGGTCAACCGATCTCGGATGTTGCGTACCAGGACTACTGGGCTCGGGCCGAATCAGACACACGTATGCAACAGATACCGATAGGCGTCTTCCTAAGTAACAGCCGTAATCAATGGTGCCACAGATCTACTAATTACGGTGAAGATCATGGCCCACGACGCTGTACGGGTTTATAGCTGCCACAAACTTTAGGAAGTTTCAGCAATCGACGCGTAGTATGTGTGCTCAGACGGGTCGAGCATGCACTTGTGTATTAAGTTACTTGGCTGAACAACCTGTTGATAGATCTTGAGAGGACCGAGAAATTGCCCTCCGGTTATGAAACAGGTCCTGCGTACCAATCCTT"));

	}

}
