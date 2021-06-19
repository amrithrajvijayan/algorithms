package preparations.queue;
import java.util.*;

public class TopKMostFrequentWords {

	private static List<String> findKMostFrequentWords(String[] arr, int k) {
		Map<String, Integer> countsMap = calculateCountsMaps(arr);
		
		PriorityQueue<String> queue = new PriorityQueue<String>(new Comparator<String>() {
			public int compare(String s1, String s2) {
				return countsMap.get(s1) - countsMap.get(s2);
			}
		});
		
		for (String str : countsMap.keySet()) {
			queue.offer(str);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		
		List<String> retList = new ArrayList<>();
		while(queue.size() > 0) 
			retList.add(queue.poll());
		
		Collections.reverse(retList);
		
		return retList;
		
	}
	
	private static Map<String, Integer> calculateCountsMaps(String[] arr) {
	
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (String str : arr) {
			Integer counts = map.getOrDefault(str, 0);
			counts++;
			map.put(str, counts);
		}
		
		return map;
	}
	
	
	
	public static void main(String[] args) {
		String[] arr = {"abc", "xyz", "hij", "abc", "xyz", "klm", "hel", "xyz", "klm", "klm", "k", "klm"};
		int k = 3;
		System.out.println(findKMostFrequentWords(arr, k));
	}

}
