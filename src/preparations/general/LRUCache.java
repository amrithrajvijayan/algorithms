package preparations.general;

import java.util.*;

public class LRUCache {
	static class LruCache {
		int maxSize;
		Map<String, Integer> map = new HashMap<>();
		Deque<String> queue = new LinkedList<>();

		public LruCache(int maxSize) {
			this.maxSize = maxSize > 1 ? maxSize : 1;
		}

		public void insertKeyValuePair(String key, int value) {
			if (!map.containsKey(key)) {
				if (map.size() >= this.maxSize) {
					String removed = queue.remove();
					map.remove(removed);
				}
				map.put(key, value);
				queue.add(key);
			} else {
				queue.remove(key);
				queue.add(key);
				map.put(key, value);
			}
		}

		public LRUResult getValueFromKey(String key) {
			Integer value = map.get(key);
			if (value != null) {
				queue.remove(key);
				queue.add(key);
				return new LRUResult(true, value);
			}
			return null;
		}

		public String getMostRecentKey() {
			String key = queue.getLast();
			return key;
		}
	}

	static class LRUResult {
		boolean found;
		int value;

		public LRUResult(boolean found, int value) {
			this.found = found;
			this.value = value;
		}
	}
}
