package preparations.graphs;
import java.util.*;

public class TraversalBreadthFirst {
	
	private static List<List<Integer>> getAdjacencyList() {
		/*               0
		 *            /     \
		 *          v        v   
		 *         1          2
		 *         |        /  |  
		 *         |      /    | 
		 *         V   v      V
		 *         3 <------ 4 ---------> 5
		 *         |   
		 * 	       V
		 *        6
		 */
		List<List<Integer>> adjList = new ArrayList<>();
		
		adjList.add(new ArrayList<Integer>(Arrays.asList(1, 2))); // Vertex 0
		adjList.add(new ArrayList<Integer>(Arrays.asList(3))); // 1
		adjList.add(new ArrayList<Integer>(Arrays.asList(3, 4))); // 2
		adjList.add(new ArrayList<Integer>(Arrays.asList(6))); // 3
		adjList.add(new ArrayList<Integer>(Arrays.asList(3, 5))); // 4
		adjList.add(new ArrayList<Integer>()); // 5
		adjList.add(new ArrayList<Integer>());
		
		return adjList;
	}
	
	private static void breadthFirstTraversal(List<List<Integer>> adjacencyList, 
			List<Integer> vertices,
			List<Integer> results) {
		
		Queue<Integer> queue = new LinkedList<>();
		int[] visited = new int[vertices.size()];
		queue.add(vertices.get(0));
		visited[vertices.get(0)] = 1;
		
		while(!queue.isEmpty()) {
			Integer vertex = queue.remove();
			results.add(vertex);
			List<Integer> neighbors = adjacencyList.get(vertex);
			for (Integer neighbor : neighbors) {
				if (visited[neighbor] == 0) {
					queue.add(neighbor);
					visited[neighbor] = 1;
				}
			}
		}
		
		return;
	}
	

	public static void main(String[] args) {

		List<List<Integer>> adjascency = getAdjacencyList();
		
		List<Integer> bfsResults = new ArrayList<>();
		List<Integer> vertices = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
		
		breadthFirstTraversal(adjascency, vertices, bfsResults);
		
		System.out.println(bfsResults);

	}

}
