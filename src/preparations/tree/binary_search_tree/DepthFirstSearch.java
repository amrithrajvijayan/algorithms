package preparations.tree.binary_search_tree;

import java.util.*;

public class DepthFirstSearch {
  static class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }

		
		private void dfs(List<String> list, Node node) {
			if (node == null) {
				return;
			}
			list.add(node.name);
			for (int i=0; i<node.children.size(); i++) {
				dfs(list, node.children.get(i));
			}
			return;
		}
		
		
		
    public List<String> depthFirstSearch(List<String> array) {
      // Write your code here.
			dfs(array, this);
      return array;
    }

    public Node addChild(String name) {
      Node child = new Node(name);
      children.add(child);
      return this;
    }
  }
}
