package preparations.graphs;
import java.util.*;

public class BreadthFirst {
	
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
	

	public static void main(String[] args) {

		List<List<Integer>> adjascency = getAdjacencyList();
		
		

	}

}
