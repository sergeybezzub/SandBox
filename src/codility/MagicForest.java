package codility;

import java.util.ArrayList;
import java.util.List;

public class MagicForest {

	static class Node {
		private List<Node> edges = new ArrayList<Node>();
		private int id;
		boolean isVisited=false;

		public Node(int id) {
			this.id = id;
		}

		public boolean equals(Node node) {

			return this.id == node.id;
		}

		public int hashCode() {

			return this.id;
		}
	}
	
	private List<Node> nodes = new ArrayList<Node>();
	
	
	/**
	 * @param nodes
	 *            Number of nodes in the magic forest. Nodes are numbered 0 ..
	 *            nodes-1.
	 * @param edges
	 *            List of edges.
	 */
	public MagicForest(int nodes, List<Edge> edges) {

		for(int i=0; i<nodes; i++)
		{
			this.nodes.add(new Node(i));
		}
		
		for(Edge edge : edges)
		{
			int from = edge.getFrom();
			int to = edge.getTo();
			
			this.nodes.get(from).edges.add(this.nodes.get(to));
		}
	}

	public int countTrees() {
		int count = 0;

		for(int i=0; i< this.nodes.size(); i++)
		{
			if(nodes.get(i).isVisited)
			{
				continue;
			}
			
			if(nodes.get(i).edges.size() < 2)
			{
				count++;
			}
			else
			{
				if( investigateEdges(nodes.get(i)) == 0)
				{
					count++;
				}
			}
		}
		
		return count-1;
	}

	private int investigateEdges(Node node)
	{
		int result = 0;
		
		for(Node nodeEdge : node.edges)
		{
			if(nodes.get(nodeEdge.id).isVisited)
			{
				return 1;
			}
			else
			{
				nodes.get(nodeEdge.id).isVisited=true;
			}
			
			if(nodeEdge.edges != null)
			{
				result = investigateEdges(nodes.get(nodeEdge.id));
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		List<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge(1, 2));
		edges.add(new Edge(3, 4));
		edges.add(new Edge(3, 5));
		edges.add(new Edge(4, 5));
		edges.add(new Edge(6, 7));
		edges.add(new Edge(6, 8));
		edges.add(new Edge(6, 9));

		MagicForest magicForest = new MagicForest(10, edges);
		System.out.println(magicForest.countTrees());
	}
}

class Edge {
	private int from;
	private int to;

	public Edge(int from, int to) {
		this.from = from;
		this.to = to;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}
}