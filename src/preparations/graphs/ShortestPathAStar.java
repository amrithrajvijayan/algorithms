package preparations.graphs;

import java.util.*;

public class ShortestPathAStar {

	class Node {
		String id;
		int row;
		int col;
		int value;
		int distanceFromStart;
		int estimatedDistanceToEnd;
		Node cameFrom;

		Node(int row, int col, int value) {
			this.id = String.valueOf(row) + '-' + String.valueOf(col);
			this.row = row;
			this.col = col;
			this.value = value;
			this.distanceFromStart = Integer.MAX_VALUE;
			this.estimatedDistanceToEnd = Integer.MAX_VALUE;
			this.cameFrom = null;
		}
	};

	public int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {

		List<List<Node>> nodes = initializeNodes(graph);
		Node startNode = nodes.get(startRow).get(startCol);
		Node endNode = nodes.get(endRow).get(endCol);
		
		startNode.distanceFromStart=0;

		List<Node> nodesToVisit = new ArrayList<Node>();
		nodesToVisit.add(startNode);
		PriorityQueue<Node> nodeQueue = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				int s1 = n1.distanceFromStart + n1.estimatedDistanceToEnd;
				int s2 = n2.distanceFromStart + n2.estimatedDistanceToEnd;
				return s1 - s2;
			}
		});
		nodeQueue.offer(startNode);
		
		while (!nodeQueue.isEmpty()) {
			Node currentMinNode = nodeQueue.remove();

			if (currentMinNode == endNode) {
				break;
			}

			List<Node> neighbors = getNeighboringNodes(currentMinNode, nodes);

			for (Node neighbor : neighbors) {
				if (neighbor.value == 1)
					continue;

				int tentativeDistToNeighbor = currentMinNode.distanceFromStart + 1;

				if (tentativeDistToNeighbor >= neighbor.distanceFromStart) {
					continue;
				}

				neighbor.cameFrom = currentMinNode;
				neighbor.distanceFromStart = tentativeDistToNeighbor;
				neighbor.estimatedDistanceToEnd = tentativeDistToNeighbor + calculateManhattanDist(neighbor, endNode);

				if (!nodesToVisit.contains(neighbor)) {
					nodeQueue.offer(neighbor);
				} else {
					nodeQueue.remove(neighbor);
					nodeQueue.offer(neighbor);
				}

			}
		}
		return reconstructPath(endNode);
	}

	int calculateManhattanDist(Node currentNode, Node endNode) {
		int currentRow = currentNode.row;
		int currentCol = currentNode.col;
		int endRow = endNode.row;
		int endCol = endNode.col;

		return Math.abs(currentRow - endRow) + Math.abs(currentCol - endCol);
	}

	List<Node> getNeighboringNodes(Node node, List<List<Node>> nodes) {
		List<Node> neighbors = new ArrayList<>();

		int numRows = nodes.size();
		int numCols = nodes.get(0).size();

		int row = node.row;
		int col = node.col;

		if (row < numRows - 1) {
			neighbors.add(nodes.get(row + 1).get(col));
		}

		if (row > 0) {
			neighbors.add(nodes.get(row - 1).get(col));
		}

		if (col < numCols - 1) {
			neighbors.add(nodes.get(row).get(col + 1));
		}

		if (col > 0) {
			neighbors.add(nodes.get(row).get(col - 1));
		}
		return neighbors;

	}

	int[][] reconstructPath(Node endNode) {
		if (endNode.cameFrom == null) {
			return new int[0][0];
		}
		Node currentNode = endNode;
		List<List<Integer>> path = new ArrayList<List<Integer>>();
		while (currentNode != null) {
			List<Integer> nodeData = new ArrayList<>();
			nodeData.add(currentNode.row);
			nodeData.add(currentNode.col);
			path.add(nodeData);
			currentNode = currentNode.cameFrom;
		}

		int[][] res = new int[path.size()][2];
		for (int i = 0; i < res.length; i++) {
			res[i][0] = path.get(res.length - 1 - i).get(0);
			res[i][1] = path.get(res.length - 1 - i).get(1);
		}
		return res;
	}

	List<List<Node>> initializeNodes(int[][] graph) {
		List<List<Node>> nodes = new ArrayList<List<Node>>();
		for (int i = 0; i < graph.length; i++) {
			List<Node> nodeList = new ArrayList<Node>();
			nodes.add(nodeList);
			for (int j = 0; j < graph[i].length; j++) {
				nodes.get(i).add(new Node(i, j, graph[i][j]));
			}
		}
		return nodes;
	}

	public static void main(String[] args) {
		
		

		  int[][] graph = {
		    {0, 0, 0, 0, 0},
		    {0, 1, 1, 1, 0},
		    {0, 0, 0, 0, 0},
		    {1, 0, 1, 1, 1},
		    {0, 0, 0, 0, 0},
		  };

			int startRow = 0;
			int startCol = 1;
			int endRow = 4;
			int endCol = 3;

			
		  /*
		int startRow = 0;
		int startCol = 0;
		int endRow = 2;
		int endCol = 2;
		int[][] graph = { 
				{0, 0, 1},
				{0, 1, 0},
				{0, 0, 0},
		};*/
		
		ShortestPathAStar astar = new ShortestPathAStar();
		int[][] path = astar.aStarAlgorithm(startRow, startCol, endRow, endCol, graph) ;
		
		System.out.println("Path is ");
		for (int i=0; i<path.length; i++) {
			for (int j=0; j<path[0].length; j++) {
				System.out.print(path[i][j]);
			}
			System.out.println("");
		}
	}

}
