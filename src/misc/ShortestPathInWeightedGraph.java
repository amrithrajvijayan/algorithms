package misc;

import java.util.HashMap;
import java.util.Map;

public class ShortestPathInWeightedGraph {

	/*
	 * a ---------5---------- b | | 2 | | | c 6 \ | 1 | \ | d----1--- e --2-- f
	 * ---1--- g
	 * 
	 */

	class Node {
		String data;
		int cost;
		Node immediateNeighbor;

		public Node(String data, int cost) {
			this.data = data;
			this.cost = cost;
		}
	}

	public static void main(String args[]) {

		ShortestPathInWeightedGraph sp = new ShortestPathInWeightedGraph();
		Node[] nodes = new Node[7];
		Node a = sp.new Node("a", 0);
		Node b = sp.new Node("b", 5);
		Node c = sp.new Node("c", 2);
		a.immediateNeighbor = b;
		b.immediateNeighbor = c;
		// c.immediateNeighbor = a;
		nodes[0] = a;

		b = sp.new Node("b", 0);
		Node f = sp.new Node("f", 6);
		b.immediateNeighbor = f;
		// f.immediateNeighbor = b;
		nodes[1] = b;

		c = sp.new Node("c", 0);
		Node d = sp.new Node("d", 1);
		c.immediateNeighbor = d;
		// d.immediateNeighbor = c;
		nodes[2] = c;

		d = sp.new Node("d", 0);
		Node e = sp.new Node("e", 1);
		d.immediateNeighbor = e;
		// e.immediateNeighbor = d;
		nodes[3] = d;

		e = sp.new Node("e", 0);
		f = sp.new Node("f", 2);
		e.immediateNeighbor = f;
		// e.immediateNeighbor = d;
		nodes[4] = e;

		f = sp.new Node("f", 0);
		Node g = sp.new Node("g", 2);
		f.immediateNeighbor = g;
		// e.immediateNeighbor = d;
		nodes[5] = f;

		nodes[6] = sp.new Node("g", 0);

		sp.findShortestPath(sp, nodes, "a", "g");

	}

	class RouteInfo {
		String name;
		int cost;
		String path = "";

		public RouteInfo(String name, int cost) {
			this.name = name;
			this.cost = cost;
		}
	}

	private void findShortestPath(ShortestPathInWeightedGraph sp, Node[] nodes, String string, String string2) {

		Map<String, RouteInfo> routes = new HashMap<String, RouteInfo>();
		routes.put("a", new RouteInfo("a", 0));
		routes.put("b", new RouteInfo("b", 0));
		routes.put("c", new RouteInfo("c", 0));
		routes.put("d", new RouteInfo("d", 0));
		routes.put("e", new RouteInfo("e", 0));
		routes.put("f", new RouteInfo("f", 0));
		routes.put("g", new RouteInfo("g", 0));
		
		for (int i = 0; i < nodes.length; i++) {
			
			Node currentNode = nodes[i];
			while(currentNode.immediateNeighbor != null) {
				Node neighbor = currentNode.immediateNeighbor;
				RouteInfo r = routes.get(neighbor.data);
				
				if (r.cost != 0 && r.cost > neighbor.cost || r.cost == 0) {
					r.cost = r.cost + neighbor.cost;
					r.path = r.path + neighbor.data;
				}
				currentNode = currentNode.immediateNeighbor;
			}
			
			
			
		}
		
		
		
		
	}

}
