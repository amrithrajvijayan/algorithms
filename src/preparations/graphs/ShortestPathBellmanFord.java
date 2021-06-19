package preparations.graphs;

import java.util.*;

public class ShortestPathBellmanFord {


		/*               0
		 *        (4)/     \(8)
		 *          v        v   
		 *         1          2
		 *         |        /  |  
		 *   (12)|   (2)/   |(2) 
		 *         V   v      V
		 *         3 <-(1)- 4 ---(6)---> 5
		 *      (4)|  
		 *          | 
		 * 	        V
		 *          6
		 */	
	public static void main(String[] args) {
		// Get adjList
		List<List<Node>> adjascencyList = getAdjacencyList();
		// For storing final distance results
		Map<Integer, Integer> distances = new HashMap<>();
		// List of all vertexes
		List<Integer> vertices = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
		// Find edges from adjList
		List<Edge> edges = calculateEdges(adjascencyList);
		// Run Bellman Ford algorithm
		bellmanFord(vertices, distances, edges);
		// Print results
		System.out.println("distances = " + distances);
	}	
	
	private static class Node {
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

	}

	private static class Edge {
		int start;
		int end;
		int cost;

		public Edge(int s, int e, int c) {
			this.start = s;
			this.end = e;
			this.cost = c;
		}
	}

	private static List<List<Node>> getAdjacencyList() {

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

	// Convert adj list to edge list.
	private static List<Edge> calculateEdges(List<List<Node>> adjList) {
		List<Edge> edgeList = new ArrayList<>();

		for (int i = 0; i < adjList.size(); i++) {
			List<Node> neighbors = adjList.get(i);
			for (Node neighbor : neighbors) {
				edgeList.add(new Edge(i, neighbor.vertex, neighbor.cost));
			}
		}

		return edgeList;
	}

	private static void bellmanFord(List<Integer> vertices,
			Map<Integer, Integer> distances, List<Edge> edges) {

		distances.put(vertices.get(0), 0);
		// iterate vertex count - 1 times
		for (int i = 1; i < vertices.size(); i++) {
			// for each edge, calculate the cost
			for (int j = 0; j < edges.size(); j++) {

				Edge edge = edges.get(j);
				
				int edgeStart = edge.start;
				int edgeEnd = edge.end;
				int edgeCost = edge.cost;
				
				// if the start was not processed, we cannot do end calculation..else do it
				if (distances.containsKey(edgeStart)) {
					// calculate new cost to end node of the current edge
					int costOfEnd = distances.get(edgeStart) + edgeCost;
					// if the cost was never calculated earlier, store it.. else check if the new
					// cost is less than already existing cost..if yes, replace
					// existing cost with new cost
					if (!distances.containsKey(edgeEnd)) {
						distances.put(edgeEnd, costOfEnd);
					} else {
						if (distances.get(edgeEnd) > costOfEnd) {
							distances.put(edgeEnd, costOfEnd);
						}
					}
				}

			} // edgelist loop end
		} // vertex loop end

		// Bellman-ford wont work if the graph has cycles.. if the above loop was run
		// once again and still the value are changing, then
		// there is a cycle
	}

}
