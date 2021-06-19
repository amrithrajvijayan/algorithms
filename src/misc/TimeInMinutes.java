package misc;

public class TimeInMinutes {


    private static final String[] onesNames = {
        "",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        "ten",
        "eleven",
        "twelve"
    };
    private static final String[] elevenToNinteen = {
        "",
        "eleven",
        "twelve",
        "thirteen",
        "fourteen",
        "fifteen",
        "sixteen",
        "seventeen",
        "eighteen",
        "ninteen"
    };

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        String timeInWords = "";

        if (m == 0) {
            timeInWords = onesNames[h] + " o' clock";
        } else if (m == 15) {
            timeInWords = "quarter past " + onesNames[h];
        } else if (m == 30) {
            timeInWords = "half past " + onesNames[h];
        } else if (m == 45) {
            timeInWords = "quarter to " + onesNames[(h +1) % 12];
        } else {
            if ( m < 30 ) {
                int firstMinutePart = m / 10;
                int secondMinutePart = m % 10;

                if (m > 10 && m < 20) {
                    timeInWords = elevenToNinteen[secondMinutePart];

                } else {
                    timeInWords = tensNames[firstMinutePart] + onesNames[secondMinutePart];
                }
                timeInWords = timeInWords + " minutes past " + onesNames[h];
            } else {
                m = ( 60 - m);
                int firstMinutePart = m / 10;
                int secondMinutePart = m % 10;
        
                if (m > 10 && m < 20) {
                    timeInWords = elevenToNinteen[secondMinutePart];

                } else {
                    timeInWords = tensNames[firstMinutePart] + onesNames[secondMinutePart];
                }
                timeInWords = timeInWords + " minutes to " + onesNames[(h +1) % 12];
            }
        }

        return timeInWords;

    }
	
    

    private static final String[] tensNames = {
        "",
        "ten",
        "twenty",
        "thirty",
        "forty",
        "fifty",
        
    };
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(timeInWords(1, 1));

	}

}


