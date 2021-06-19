package preparations.graphs;
import java.util.*;

public class MinimumSpanningTreePrims {
	
	private static class Node {
		int vertex;
		int cost;
		List<Integer> path;
		
		public Node() {
			this.vertex=0;
			this.cost=0;
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
	
	private static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int cost;
		public Edge(int s, int e, int c) {
			this.start = s;
			this.end = e;
			this.cost = c;
		}
		
		public String toString() {
			return "[" + this.start + " : " + this.end +"] ->  " + this.cost;
		}
		
		public int compareTo(Edge newEdge) {
			return this.cost - newEdge.cost;
		}
	}
	
	private static List<List<Node>> getAdjacencyList() {
		/*               0
		 *        (4)/     \(8)
		 *          /        \   
		 *         1          2
		 *         |        /  |  
		 *   (12)|   (2)/   |(2) 
		 *         |    /      |
		 *         3 ---(1)- 4 ---(6)---- 5
		 *      (4)|  
		 *          | 
		 * 	         |
		 *          6
		 */
		List<List<Node>> adjList = new ArrayList<>();
		
		adjList.add(new ArrayList<Node>(Arrays.asList(new Node(1, 4), new Node(2, 8)))); // Vertex 0
		adjList.add(new ArrayList<Node>(Arrays.asList(new Node(0, 4), new Node(3, 12)))); // 1
		adjList.add(new ArrayList<Node>(Arrays.asList(new Node(0, 8), new Node(3, 2), new Node(4, 2)))); // 2
		adjList.add(new ArrayList<Node>(Arrays.asList(new Node(1, 12), new Node(2, 2), new Node(4, 1), new Node(6, 4)))); // 3
		adjList.add(new ArrayList<Node>(Arrays.asList(new Node(2, 2), new Node(3, 1), new Node(5, 6)))); // 4
		adjList.add(new ArrayList<Node>(Arrays.asList(new Node(4, 6)))); // 5
		adjList.add(new ArrayList<Node>(Arrays.asList(new Node(3, 4)))); // 6
		
		return adjList;
	}
	
	// Convert adj list to edge list.
	private static List<Edge> calculateEdges(List<List<Node>> adjList) {
		List<Edge> edgeList = new ArrayList<>();
		
		for (int i=0; i<adjList.size(); i++) {
			List<Node> neighbors = adjList.get(i);
			for (Node neighbor : neighbors) {
				edgeList.add(new Edge(i, neighbor.vertex, neighbor.cost));				
			}
		}
		
		return edgeList;
	}
	

	public static void main(String[] args) {
		// Get adjList
		List<List<Node>> adjascencyList = getAdjacencyList();
		// List of all vertexes
		List<Integer> vertices = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
		// Find edges from adjList
		List<Edge> edgeLists = calculateEdges(adjascencyList);
		// Run Prims algorithm
		int cost = primsMST(adjascencyList, vertices, edgeLists);
		// Print results
		System.out.println("MST Cost = " + cost);
	}


    /*
     * The idea here is that, out of all the edges, take the one with the lowest cost. Then for both the vertices of the same edge,
     * take the edge with lowest cost and add to tree. ( this is the difference between prims and kruskals ) 
     * Again, consider the associated edges of the nodes present in the tree to find next lowest cost edge
     * keep iterating till all vertices are covered.
     */
	private static int primsMST(List<List<Node>> adjascencyList, List<Integer> vertices, 
			List<Edge> edgeList) {
		int minimumCost = 0;
		
		Edge smallestCostEdge = null;
		
		// Find out lowest cost edge.
		for (Edge e : edgeList) {
			if (smallestCostEdge == null) 
				smallestCostEdge = e;
			else if (smallestCostEdge.cost > e.cost) {
				smallestCostEdge = e;
			}
		}
		
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		// to start with smallest cost edge, add it to queue.
		pq.offer(smallestCostEdge);
		
		Set<Integer> processedNode = new HashSet<>();

		
		while(!pq.isEmpty() && processedNode.size() < vertices.size()) {
						
			Edge edge = pq.poll();
			
			// If this edge is an already processed one, skip it
			if (processedNode.contains(edge.start) && processedNode.contains(edge.end)) {
				continue;
			}
			// mark the start and end vertices as processed.
			processedNode.add(edge.start);
			processedNode.add(edge.end);
			// update minimum cost.
			minimumCost = minimumCost + edge.cost;

			// add the neighbors of start node to the queue
			for (Node node : adjascencyList.get(edge.start)) {
				if (!processedNode.contains(node.vertex)) {
					Edge e = new Edge(edge.start, node.vertex, node.cost);
					pq.offer(e);
				}
			}
			
			// add neighbors of end node to queue
			for (Node node : adjascencyList.get(edge.end)) {
				if (!processedNode.contains(node.vertex)) {
					Edge e = new Edge(edge.end, node.vertex, node.cost);
					pq.offer(e);
				}
			}
			

		}
		
		
		return minimumCost;
	}

}
