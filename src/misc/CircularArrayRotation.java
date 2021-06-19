package misc;

public class CircularArrayRotation {
	
	
	public static void main(String[] args) {
		
		
		
//		int[] a = {1, 2, 3};//{1, 2, 3, 4, 5, 6};
//		int k = 2;

		//int[] output = CircularArrayRotation.circularArrayRotation(a, k);
		
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};//{596,53804,13567,538,55791,75204,15873,98117,41061,49377,64425,62232,49127,20342,99276,24860,25787,81841,97359,7404,34400,37174,73359,257,88477,28020,25920,62652,3228,20401,99722,20175,74204,29640,20713,29994,4843,52937,28110,45903,18665,92535,24487,67791,29228,23762,9002,71367,21955,6360,78770,56354,59886,68480,72962,48362,96499,15233,11013,99726,35633,27086,36253,9836,73077,56965,39830,77919,26253,84291,40174,44918};
		int k =11;
		int[] query = {0, 1, 2, 3,4, 5, 6, 7, 8};//{0, 35, 3,4,4,37}; //{47, 10, 12, 13};
		
		int[] output = CircularArrayRotation.circularArrayRotation(a, k, query);
		for (int val : output) {
			System.out.print(val + " ");
		}
		// 72722, 90286, 44792, 65142
	}
	
    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {

    	k = k % a.length;
        
        int arrayLength = a.length;

        for (int i=0; i< (arrayLength - k)/2; i++) {
            int temp = a[i];
            a[i] = a[arrayLength -k - i -1];
            a[arrayLength - i -k -1] = temp;
        }
       

        int pos = arrayLength - 1;
        for (int i = (arrayLength - k); i <= (arrayLength - (arrayLength -k))/2; i++) {
            int temp = a[i];
            a[i] = a[pos];
            a[pos] = temp;
            pos--;
        }

        for (int i=0; i< arrayLength/2; i++) {
            int temp = a[i];
            a[i] = a[arrayLength - i - 1];
            a[arrayLength -i -1] = temp;
        }
        int[] retArray = new int[queries.length];
        for (int i=0; i< queries.length; i++) {
            retArray[i] = (a[queries[i]]);
        }

        return retArray;
    }


    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] a, int k) {

        System.out.println("-----input");
        for(int val : a) { System.out.print(val + ", "); 
        };

        int arrayLength = a.length;

        for (int i=0; i< (arrayLength - k)/2; i++) {
            int temp = a[i];
            a[i] = a[arrayLength -k - i -1];
            a[arrayLength - i -k -1] = temp;
        }
        System.out.println("\n-----first half rotation done");
        for(int val : a) { System.out.print(val + ", "); };

        int pos = arrayLength - 1;
        for (int i = (arrayLength - k); i <= ((arrayLength - k) + (arrayLength - k)/2); i++) {
            int temp = a[i];
            a[i] = a[pos];
            a[pos] = temp;
            pos--;
        }
        System.out.println("\n-----second half rotation done");
        for(int val : a) { System.out.print(val + ", "); };

/*
        int loc = 1;
        for (int i=d; i< (d + (n-d)/2); i++) {
            int temp = a[i];
            a[i] = a[n - loc];
            a[n - loc] = temp;
            loc++;
        }
        System.out.println("\n-----second half rotation done");
        for(int val : a) { System.out.print(val + ", "); };
/*
        for (int i=0; i< n/2; i++) {
            int temp = a[i];
            a[i] = a[n-i-1];
            a[n-i-1] = temp;
        }

        for (int i=0; i< n; i++) {
            System.out.print(a[i] + " ");
        }
*/
        return new int[0];
    }

}
