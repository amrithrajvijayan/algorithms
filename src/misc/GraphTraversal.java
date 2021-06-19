package misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphTraversal {
	public static class Node {
		int value;
		public Node(int n) {
			this.value = n;
		}
	}
	
	public class Graph {
		List<Node> nodes = new ArrayList<Node>();
		List<List<Integer>> adjacencyList;
		
		public Graph(int size) {
			 adjacencyList = new ArrayList<List<Integer>>();
			 for (int i=1; i<=size+1; i++) {
				 adjacencyList.add(new ArrayList<Integer>());
			 }
		}
		public void addNode(int n) {
			nodes.add(new Node(n));
		}
		public void addEdge(int data, int neighbor) {
			adjacencyList.get(data).add(neighbor);
		}
		
		
		public void breadthFirst(int start) {
			
			Queue<Integer> queue = new LinkedList<>();
			queue.add(start);
			int[] visited = new int[nodes.size()+1];
			while(!queue.isEmpty()) {
				int current = queue.poll();
				if (visited[current] != 1) {
					System.out.println(current + " " );
					visited[current] = 1;
					List<Integer> neighbors = adjacencyList.get(current);
					for (int neighbor : neighbors) {
						queue.offer(neighbor);
					}
				}
			}
			return;
		}
	}
	
	
	
	

	public static void main(String[] args) {
		GraphTraversal.Graph g = new GraphTraversal().new Graph(5);
		g.addNode(1);
		g.addNode(2);
		g.addNode(3);
		g.addNode(4);
		g.addNode(5);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.breadthFirst(1);
		System.out.println("done");
	}

}
