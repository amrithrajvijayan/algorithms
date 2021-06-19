package preparations.skiplist;

public class SkipList {
	static class Node {
		int value;
		Node firstLevelPtr;
		Node secondLevelPtr;

		public Node(int v) {
			this.value = v;
		}
	}

	private static boolean searchElement(Node root, int n) {

		Node node = root;
		Node pre = null;
		while (node != null && node.value < n) {
			pre = node;
			node = node.firstLevelPtr;
		}
		node = pre;
		while (node != null && node.value < n) {
			pre = node;
			node = node.secondLevelPtr;
		}
		if (node != null && node.value == n)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {

		Node root = createNodes();
		printPointers(root);
		int n = 27;
		System.out.println("\n\nSearch result for element " + n + " is " + searchElement(root, n));
	}

	private static void printPointers(Node root) {
		Node n = root;
		System.out.println("First Level Pointers");
		while (n != null) {
			System.out.print(n.value + " -> ");
			n = n.firstLevelPtr;
		}
		n = root;
		System.out.println("\n\nSecond Level Pointers");
		while (n != null) {
			System.out.print(n.value + " -> ");
			n = n.secondLevelPtr;
		}
	}

	private static Node createNodes() {
		Node root = null, pre = null;
		Node topLevelPre = null;
		for (int i = 0; i <= 50; i++) {

			if (i == 27) // just for testing
				continue;

			Node n = new Node(i);
			if (i == 0) {
				root = n;
				pre = root;
				topLevelPre = root;
			} else {
				pre.secondLevelPtr = n;
				pre = n;
			}
			if (i % 10 == 0) {
				topLevelPre.firstLevelPtr = n;
				topLevelPre = n;
			}

		}
		return root;
	}

}
