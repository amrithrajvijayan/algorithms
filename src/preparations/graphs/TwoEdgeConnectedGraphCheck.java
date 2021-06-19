package preparations.graphs;

import java.util.*;

/*

You're given a list of <span>edges</span> representing an unweighted and
undirected graph. Write a function that returns a boolean representing whether
the given graph is two-edge-connected.


A graph is connected if, for every pair of vertices in the graph, there's a
path of one or more edges connecting the given vertices. A graph that isn't
connected is said to be disconnected.


A graph is two-edge-connected if, for every one of its edges, the edge's
removal from the graph doesn't cause the graph to become disconnected. If the
removal of any single edge disconnects the graph, then it isn't
two-edge-connected. If the given graph is already disconnected, then it also
isn't two-edge-connected. An empty graph is considered two-edge-connected.


The input list is what's called an adjacency list, and it represents a graph.
The number of vertices in the graph is equal to the length of
<span>edges</span>, where each index <span>i</span> in
<span>edges</span> contains vertex <span>i</span>'s outbound edges, in no
particular order. Each outbound edge is represented by a positive integer that
denotes an index (a destination vertex) in the list that this vertex is
connected to. Note that these edges are undirected, meaning that you can
travel from a particular vertex to its destination and from the destination
back to that vertex. Since these edges are undirected, if vertex
<span>i</span> has an outbound edge to vertex <span>j</span>, then vertex
<span>j</span> is guaranteed to have an outbound edge to vertex
<span>i</span>. For example, an undirected graph with two vertices and one
edge would be represented by the following adjacency list
<span>edges = [[1], [0]]</span>.


Note that the input graph will never contain parallel edges (edges that share
the same source and destination vertices). In other words, there will never be
more than one edge than connects the same two vertices to each other.

*/

public class TwoEdgeConnectedGraphCheck {

	public boolean twoEdgeConnectedGraph(int[][] edges) {
		if (edges.length == 0)
			return true;

		int[] arrivalTimes = new int[edges.length];
		Arrays.fill(arrivalTimes, -1);
		int start = 0;

		if (getMinArrTimeOfAncestors(start, -1, 0, arrivalTimes, edges) == -1) {
			return false;
		}

		return allVerticesVisited(arrivalTimes);
	}

	public int getMinArrTimeOfAncestors(int currentVertex, int parent, int currentTime, int[] arrivalTimes,
			int[][] edges) {

		arrivalTimes[currentVertex] = currentTime;
		int minArrivalTime = currentTime;

		for (int destination : edges[currentVertex]) {
			if (arrivalTimes[destination] == -1) {
				minArrivalTime = Math.min(minArrivalTime,
						getMinArrTimeOfAncestors(destination, currentVertex, currentTime + 1, arrivalTimes, edges));
			} else if (destination != parent) {
				minArrivalTime = Math.min(minArrivalTime, arrivalTimes[destination]);
			}
		}

		if (minArrivalTime == currentTime && parent != -1) {
			return -1;
		}

		return minArrivalTime;
	}

	private boolean allVerticesVisited(int[] arrivalTimes) {
		for (int time : arrivalTimes) {
			if (time == -1)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
