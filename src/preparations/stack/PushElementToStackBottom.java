package preparations.stack;

import java.util.Stack;

public class PushElementToStackBottom {

	private static void pushToBottom(Stack<Integer> stack, int number) {
		if (stack.isEmpty()) {
			stack.push(number);
			return;
		}

		Integer n = stack.pop();
		pushToBottom(stack, number);
		stack.push(n);
	}

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();

		stack.push(10);
		stack.push(9);
		stack.push(8);
		stack.push(7);
		stack.push(6);

		System.out.println("Before : " + stack);

		pushToBottom(stack, 12);

		System.out.println("After  : " + stack);

	}

}
