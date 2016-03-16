package graphs;

import java.util.*;
import graphs.State;

public class GraphUtils {
	
	public static void dfs(Node root) {
		// Avoid infinite loops
		if (root == null)
			return;

		System.out.print(root.getVertex() + "\t");
		root.state = State.Visited;

		// for every child
		for (Node n : root.getChild()) {
			// if childs state is not visited then recurse
			if (n.state == State.Unvisited) {
				dfs(n);
			}
		}
	}

	public static void bfs(Node root) {
		// Since queue is a interface
		Queue<Node> queue = new LinkedList<Node>();

		if (root == null)
			return;

		root.state = State.Visited;
		// Adds to end of queue
		queue.add(root);

		while (!queue.isEmpty()) {
			// removes from front of queue
			Node r = queue.remove();
			System.out.print(r.getVertex() + "\t");

			// Visit child first before grandchild
			for (Node n : r.getChild()) {
				if (n.state == State.Unvisited) {
					queue.add(n);
					n.state = State.Visited;
				}
			}
		}

	}

	public static Graph createNewGraph() {
		Graph g = new Graph();
		Node[] temp = new Node[8];

		temp[0] = new Node(0, 2);
		temp[1] = new Node(1, 3);
		temp[2] = new Node(2, 1);
		temp[3] = new Node(3, 0);
		temp[4] = new Node(4, 0);
		temp[5] = new Node(5, 1);
		temp[6] = new Node(6, 0);
		temp[7] = new Node(7, 0);

		temp[0].addChildNode(temp[1]);
		temp[0].addChildNode(temp[5]);

		temp[1].addChildNode(temp[2]);
		temp[1].addChildNode(temp[3]);
		temp[1].addChildNode(temp[4]);

		temp[2].addChildNode(temp[7]);
		temp[5].addChildNode(temp[6]);

		for (int i = 0; i < 7; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}

	public static void main(String[] args) {

		Graph gBfs = createNewGraph();
		System.out.println("---------------BFS---------------");
		bfs(gBfs.getNode()[0]);
		System.out.println();
		System.out.println();
		Graph gDfs = createNewGraph();
		System.out.println("--------------DFS---------------");
		dfs(gDfs.getNode()[0]);

	}

}
