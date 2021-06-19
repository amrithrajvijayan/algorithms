package preparations.unionfind;

import java.util.*;

public class GraphCycleDetection {
	
	static class Edge {
		int src;
		int dest;
		public Edge(int src, int dest) {
			this.src=  src;
			this.dest = dest;
		}
	}
	static class Graph {
		List<Edge> edges;
		
		public Graph() {
			edges = new ArrayList<Edge>();
		}
		
		public void addEdge(Edge e) {
			edges.add(e);
		}
		
		public List<Edge> getEdges() {
			return edges;
		}
		
	}
	
	
	/*
              1 -------------- 2
              |                    \ 
              |                     \
              3                      \
              |                        \
              |                         \
              4-----------5----------6
   */
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addEdge(new Edge(1, 2));
		g.addEdge(new Edge(1, 3));
		g.addEdge(new Edge(3, 4));
		g.addEdge(new Edge(4, 5));
		g.addEdge(new Edge(5, 6));
		g.addEdge(new Edge(2, 6));
		
		System.out.println("Is graph cyclic ? " + isCyclicGraph(g));
	}
	
	private static boolean isCyclicGraph(Graph g) {
		
		UnionFind uf = new UnionFind(g.edges.size());
		
		for (Edge e : g.edges) {
			// if parents are same for src and dest, before they are added to union-find, there will be a cycle.
			int p1 = uf.find(e.src);
			int p2 = uf.find(e.dest);
			
			if (p1 == p2)
				return true;
			
			uf.union(p1, p2);
		}
		
		
		return false;
	}
	
	
	static class UnionFind {
		int[] parent;
		public UnionFind(int size) {
			this.parent = new int[size+1];
			Arrays.fill(this.parent, -1);
		}
		
		public void union(int i, int j) {
			parent[i] = j;
		}
		
		public int find(int i) {
			if (parent[i] == -1)
				return i;
			else return find(parent[i]);
		}
		
	}
	
	
	

}
