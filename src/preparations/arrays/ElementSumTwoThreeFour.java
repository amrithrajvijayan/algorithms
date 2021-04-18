package preparations.arrays;
import java.util.*;

public class ElementSumTwoThreeFour {

	private static List<Integer> twoSum(int[] arr, int target) {
		List<Integer> retList = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for (int i : arr) {
			if (set.contains(target-i)) {
				retList.add(i);
				retList.add(target-i);
				break;
			} else {
				set.add(i);
			}
		}
		return retList;
	}
	
	private static List<List<Integer>> threeSum(int[] inputs, int target) {
		List<List<Integer>> retList = new ArrayList<List<Integer>>();
		int[] arr = Arrays.copyOf(inputs, inputs.length);
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 2; i++) {
			int j = i + 1;
			int k = arr.length - 1;
			int element = arr[i];
			while (j < k) {
				int partialSum = element + arr[j] + arr[k];
				if (partialSum == target) {
					List<Integer> lst = new ArrayList<>();
					lst.add(element);
					lst.add(arr[j]);
					lst.add(arr[k]);
					retList.add(lst);
					break;
				} else {
					if (partialSum > target) {
						k--;
					} else {
						j++;
					}
				}
			}
		}
		return retList;
	}

	private static List<List<Integer>> fourSum(int[] arr, int target) {
		List<List<Integer>> retList = new ArrayList<List<Integer>>();
		Map<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();

		for (int i = 0; i <= arr.length - 2; i++) {
			for (int j = i + 1; j <= arr.length - 1; j++) {
				int sum = arr[i] + arr[j];
				int diff = target - sum;
				if (map.containsKey(diff)) {
					List<List<Integer>> list = map.get(diff);
					for (List<Integer> lis : list) {
						List<Integer> ret = new ArrayList<Integer>();
						ret.add(arr[i]);
						ret.add(arr[j]);
						ret.add(lis.get(0));
						ret.add(lis.get(1));
						retList.add(ret);
					}
				}
			}

			for (int k = 0; k < i; k++) {
				int sum = arr[i] + arr[k];
				List<List<Integer>> list = map.getOrDefault(sum, new ArrayList<List<Integer>>());
				List<Integer> ret = new ArrayList<Integer>();
				ret.add(arr[i]);
				ret.add(arr[k]);
				list.add(ret);
				map.put(sum, list);
			}
		}

		return retList;
	}

	public static void main(String[] args) {
		int[] arr = {4, 20, 3, 12, 5, 22, 2, 40, 1};
		int target = 45;
		System.out.println("Two sum =" + twoSum(arr, target));
		System.out.println("Three sum =" + threeSum(arr, target));
		System.out.println("Four sum =" + fourSum(arr, target));
	}

}
