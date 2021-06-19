package preparations.stack;

import java.util.*;

public class MinMaxStack {
	static class MinMaxStackImpl {
		List<Integer> stack = new ArrayList<Integer>();
		List<Map<String, Integer>> minMaxStack = new ArrayList<Map<String, Integer>>();

		public int peek() {
			return stack.get(stack.size() - 1);
		}

		public int pop() {
			minMaxStack.remove(minMaxStack.size() - 1);
			return stack.remove(stack.size() - 1);
		}

		public void push(Integer number) {
			Map<String, Integer> newMinMax = new HashMap<>();
			newMinMax.put("min", number);
			newMinMax.put("max", number);
			if (minMaxStack.size() > 0) {
				Map<String, Integer> lastMinMax = minMaxStack.get(minMaxStack.size() - 1);
				newMinMax.replace("min", Math.min(lastMinMax.get("min"), number));
				newMinMax.replace("max", Math.max(lastMinMax.get("max"), number));
			}
			minMaxStack.add(newMinMax);
			stack.add(number);
		}

		public int getMin() {
			return minMaxStack.get(minMaxStack.size() - 1).get("min");
		}

		public int getMax() {
			return minMaxStack.get(minMaxStack.size() - 1).get("max");
		}
	}
}
