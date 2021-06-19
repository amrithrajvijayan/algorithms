package preparations.graphs;
import java.util.*;


public class ShortestPathDijkstra {

	private static class Node implements Comparator<Node> {
		int vertex;
		int cost;
		List<Integer> path;

		public Node() {
			this.vertex = 0;
			this.cost = 0;
			path = new ArrayList<>();
		}

		public Node(int v, int c) {
			this.vertex = v;
			this.cost = c;
			this.path = new ArrayList<>();
		}

		public Node(int v, int c, List<Integer> path) {
			this.vertex = v;
			this.cost = c;
			this.path = path;
		}

		@Override
		public int compare(Node o1, Node o2) {

			return o1.cost - o2.cost;

		}
	}

	private static List<List<Node>> getAdjacencyList() {
		/*               0
		 *        (4)/     \(8)
		 *          v        v   
		 *         1          2
		 *         |        /  |  
		 *   (12)|  (2)/    |(2) 
		 *         V   v      V
		 *         3 <-(1)- 4 ---(6)---> 5
		 *      (4)|  
		 *          | 
		 * 	        V
		 *          6
		 */
		List<List<Node>> adjList = new ArrayList<>();

		adjList.add(new ArrayList<Node>(Arrays.asList(new Node(1, 4), new Node(2, 8)))); // Vertex 0
		adjList.add(new ArrayList<Node>(Arrays.asList(new Node(3, 12)))); // 1
		adjList.add(new ArrayList<Node>(Arrays.asList(new Node(3, 2), new Node(4, 2)))); // 2
		adjList.add(new ArrayList<Node>(Arrays.asList(new Node(6, 4)))); // 3
		adjList.add(new ArrayList<Node>(Arrays.asList(new Node(3, 1), new Node(5, 6)))); // 4
		adjList.add(new ArrayList<Node>()); // 5
		adjList.add(new ArrayList<Node>());

		return adjList;
	}

	public static void main(String[] args) {

		List<List<Node>> adjascency = getAdjacencyList();

		Map<Integer, Integer> distances = new HashMap<>();
		Map<Integer, List<Integer>> paths = new HashMap<>();

		List<Integer> vertices = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));

		dijkstra(adjascency, vertices, distances, paths);

		System.out.println("distances = " + distances);
		System.out.println("paths = " + paths);
	}

	private static void dijkstra(List<List<Node>> adjascencyList, List<Integer> vertices,
			Map<Integer, Integer> distances, Map<Integer, List<Integer>> paths) {

		Set<Integer> visited = new HashSet<>();

		PriorityQueue<Node> pq = new PriorityQueue<Node>(vertices.size(), new Node());
		// add start node to PQ.
		pq.offer(new Node(vertices.get(0), 0, new ArrayList<>(Arrays.asList(vertices.get(0)))));
		visited.add(vertices.get(0));
		distances.put(vertices.get(0), 0);
		paths.put(vertices.get(0), new ArrayList<>(Arrays.asList(vertices.get(0))));

		while (distances.size() < vertices.size()) {
			// Take the top Node from PQ, which is the one with smallest cost.
			Node closestNode = pq.poll();
			// Get its neighbors.
			List<Node> neighbors = adjascencyList.get(closestNode.vertex);
			for (Node n : neighbors) {
				// If not already processed,
				if (!visited.contains(n.vertex)) {
					// recalculate cost and put to PQ as new node.
					Node newNode = new Node(n.vertex, closestNode.cost + n.cost);
					// calculate path
					newNode.path = new ArrayList(closestNode.path);
					newNode.path.add(n.vertex);
					pq.offer(newNode);
				}
			}
			// mark current node as processed
			visited.add(closestNode.vertex);
			// record current node cost.
			distances.put(closestNode.vertex, closestNode.cost);
			// record path
			paths.put(closestNode.vertex, closestNode.path);
		}

	}

}
