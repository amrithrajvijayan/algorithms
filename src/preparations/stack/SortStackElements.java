package preparations.stack;

import java.util.Stack;

public class SortStackElements {
	
	private static Stack<Integer> sortStack(Stack<Integer> stack) {
		Stack<Integer> targetStack = new Stack<>();
		while(stack.size() > 0) {
			Integer top = stack.pop();
			insertIntoStack(targetStack, top);
		}
		
		return targetStack;
	}
	
	private static void insertIntoStack(Stack<Integer> stack, Integer element) {
	
		if (stack.size() == 0) {
			stack.push(element);
			return;
		}
		
		if (stack.peek() < element) {
			stack.push(element);
			return;
		} else {
			Integer t = stack.pop();
			insertIntoStack(stack, element);
			stack.push(t);
		}
		
	}
	
	

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(10);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(6);
		
		System.out.println("Before : " + stack);
		
		Stack<Integer> targetStack = sortStack(stack);
		
		System.out.println("After  : " + targetStack);

	}

}
