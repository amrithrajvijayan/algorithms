package misc;

import java.util.*;

public class StackTest {

	
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);

        int command = 1;
        Stack<Integer> stack = new Stack<>();
        int currentMax = -1;
        while (scanner.hasNextLine()) {
        	
        	System.out.println("\n-----stack-----");
            Iterator<Integer> iterr = stack.iterator();
            while(iterr.hasNext()) {
                int iterValue = iterr.next();
               System.out.print(iterValue + "  ");
            }
        	System.out.println("\n-----end of stack-----");

        	
        	
            command = scanner.nextInt();
            if (command == 1) {
                int input = scanner.nextInt();
                //System.out.println("input is " + input);
                stack.push(input);
                if (input > currentMax ) {
                    currentMax = input;
                }
            } else if (command == 2) {
                if (!stack.isEmpty()) {
                    int element = stack.pop();
                        currentMax = -1;
                }
            } else if (command == 3) {
            	            	
            	if (stack.isEmpty()) {
                    System.out.println("");
                } else {
                    if (currentMax > -1) {
                        System.out.println(currentMax);
                    } else {
                        int max = 0;
                        Iterator<Integer> iter = stack.iterator();
                        while(iter.hasNext()) {
                            int iterValue = iter.next();
                            if (max < iterValue) {
                                max = iterValue;
                            }
                        }
                        currentMax = max;
                        System.out.println(max);
                    }
                }
            }

        }

    }	
}
