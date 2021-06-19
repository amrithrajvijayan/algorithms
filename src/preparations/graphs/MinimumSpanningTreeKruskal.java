package preparations.graphs;
import java.util.*;

public class MinimumSpanningTreeKruskal {
	
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
		// Run Kruskals Alg
		int cost = kruskalsMST(adjascencyList, vertices, edgeLists);
		// Print results
		System.out.println("MST Cost = " + cost);
	}


    /*
     * The idea here is that, out of all the edges, keep taking the edges with lowest cost and add to tree
     * such that cycles are not formed. if adding an edge will result in cycle, ignore that edge.
     * Keep doing this till all vertices are covered.
     */
	private static int kruskalsMST(List<List<Node>> adjascencyList, List<Integer> vertices, 
			List<Edge> edgeList) {
		int minimumCost = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		// add all edges to the queue.
		for (Edge edge : edgeList) {
			pq.offer(edge);
		}
		
		Set<Integer> processedNode = new HashSet<>();
		int numberOfEdgesProcessed = 0;
		
		while(!pq.isEmpty() && numberOfEdgesProcessed < (vertices.size() -1) ) {
						
			Edge edge = pq.poll();
			System.out.println("\n got edge " + edge);
			
			// If this edge is an already processed one, skip it ( avoid cycles )
			// Refer https://www.youtube.com/watch?v=wU6udHRIkcc
			// Need to use Union-find. Below logic is not proper
			if (processedNode.contains(edge.start) && processedNode.contains(edge.end)) {
				System.out.println("its already processed.. skipping");
				continue;
			}
			 
			// mark the start and end vertices as processed.
			processedNode.add(edge.start);
			processedNode.add(edge.end);
			System.out.println("updated processedNodes = " + processedNode);
			
			// update minimum cost.
			minimumCost = minimumCost + edge.cost;
			System.out.println("updated minimumCost = " + minimumCost);
			
			numberOfEdgesProcessed++;
			System.out.println("numberOfEdgesProcessed = " + numberOfEdgesProcessed);
		}
		
		
		return minimumCost;
	}

}
