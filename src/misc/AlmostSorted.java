package misc;

public class AlmostSorted {

	
	static void almostSorted(int[] arr) {
		
		
        int start = 0;
        int end = arr.length-1;
		int pos = 0;
		boolean isDecrementing = false;

		while(pos < (arr.length-1) && arr[pos] < arr[pos+1]) {
			//System.out.println("comparing " + arr[pos] + " with pre value " + arr[pos-1] +" and pos =" + pos);
			pos++;
		}
		//System.out.println("Done comparing " + arr[pos] + " with pre value " + arr[pos-1] +" and pos =" + pos);

		
		if (pos == 0) {
			int k = 0;
			while(k < (arr.length - 1) && arr[k] > arr[k+1]) {
				k++;
			}
			if (k == arr.length-1) {
				System.out.println("yes");
                if (end-start > 3)
                    System.out.println("reverse " + (start +1) + " " + (end + 1));
                else 
                    System.out.println("swap " + (start +1) + " " + (end + 1));
                return;
			}
		}
		
		
		if (pos == arr.length - 1) {
			System.out.println("yes");
			return;
		} else {
			start = pos + 1;
			System.out.println("got start as " + start);
			
			
			if (pos > 0 && pos < arr.length && arr[pos-1] < arr[pos+1]) {
				pos++;	
			}
			
			while(pos < (arr.length-1) && arr[pos] > arr[pos+1]) {
				isDecrementing = true;
				pos++;
			}

			if (!isDecrementing) {
				while(pos < (arr.length -1) && arr[pos-1] < arr[pos+1]) {
					//System.out.println("2 comparing " + arr[pos] + " with next value " + arr[pos+1] +" and pos =" + pos);
					pos++;
				}
			}
			//System.out.println("out of loop for " + arr[pos] + " with next value " + arr[pos+1] +" and pos =" + pos);
			
			
			if (pos < arr.length - 2 && arr[pos-1] > arr[pos+1]) {
				pos++;	
			}
			end = (pos+1);
			
			System.out.println("end is " + end);
			
			
			pos = pos + 1;
			int compareValue = arr[start-1];
			while(pos < (arr.length-1) && compareValue < arr[pos+1]) {
				pos++;
				compareValue = arr[pos];
			}

			
	        if (pos == arr.length-1) {
	            System.out.println("yes");
	        } else {
	            System.out.println("no");
	            return;
	        }		
	        
            if (isDecrementing) {
                System.out.println("reverse " + (start) + " " + (end));
            } else {
                System.out.println("swap " + (start) + " " + (end));
            }
	        
			
		}
		
		
		
	}

	/*
    // Complete the almostSorted function below.
    static void almostSorted(int[] arr) {
        int hasUpwardTrend = 1;
        int hasDownwardTrend = -1;
        int start = 0;
        int end = arr.length-1;
        for (int i=1; i<arr.length; i++) {
            System.out.println("i=" + i + ", arr[i]=" + arr[i] + " upwardTrend="+ hasUpwardTrend+", downwardTrend="+hasDownwardTrend);
            if (arr[i] > arr[i-1]) {
                if (hasUpwardTrend == -1) {
                    hasUpwardTrend = 1;
                } else if (hasUpwardTrend == 1 && hasDownwardTrend==1){
                	
                    end = i-1;
                    System.out.println("end is " + end);
                }
            } else if (arr[i] < arr[i-1]) {
                if (hasUpwardTrend == 1 && hasDownwardTrend == -1) {
                    //System.out.println("downward trend noted..start=" + (i-1));
                    hasDownwardTrend = 1;
                    start = i-1;
                    System.out.println("start="+start);
                }
            }
        }

        //System.out.println("start=" + start + ", end = " + end);
        boolean isRestOfArrayIncrement = true;
        for (int j=end+1; j<arr.length; j++) {
            int pre = arr[j-1];
            if (j == end+1) {
                pre = arr[start];
            }
            if (pre > arr[j]) {
                System.out.println("no");
                return;
            }
        }

        if (start >=0 && start < arr.length && end >=0 && end <arr.length) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        if (start == end - 1 || start == end - 2) {
            System.out.println("swap " + (start+1) + " " + (end+1));
        } else {
            boolean isDescending = true;
            boolean isAscending = true;
            for (int i=start+2; i<end; i++) {
                //System.out.println("comparing " +arr[i] + " and " + arr[i-1]);
                isDescending = isDescending && (arr[i] < arr[i-1]);
                isAscending = isAscending && (arr[i] > arr[i-1]);
            }
            if (isDescending) {
                System.out.println("reverse " + (start+1) + " " + (end+1));
            } else {
                System.out.println("swap " + (start+1) + " " + (end+1));
            }
        }
        //System.out.println("start=" + start+", end="+end);


        return;
    }	*/
	
	public static void main(String[] args) {
		int[] arrr = {4104, 8529, 49984, 54956, 63034, 82534, 84473, 86411, 92941, 95929, 108831 ,894947, 125082,
				137123, 137276, 142534, 149840, 154703, 174744, 180537, 207563, 221088,
				223069, 231982, 249517, 252211, 255192, 260283, 261543, 262406, 270616,
				274600, 274709, 283838, 289532, 295589, 310856, 314991, 322201, 339198,
				343271, 383392, 385869, 389367, 403468, 441925, 444543, 454300, 455366,
				469896 ,478627, 479055, 484516, 499114, 512738, 543943, 552836, 560153,
				578730, 579688, 591631, 594436, 606033, 613146, 621500, 627475, 631582,
				643754, 658309, 666435, 667186, 671190 ,674741, 685292, 702340, 705383,
				722375, 722776, 726812, 748441, 790023, 795574, 797416, 813164, 813248,
				827778, 839998, 843708, 851728, 857147, 860454, 861956, 864994, 868755,
				116375, 911042, 912634, 914500, 920825, 979477};
		
		int[] arr = {1, 2, 4, 3, 5, 6};
		almostSorted(arr);
	}

}
