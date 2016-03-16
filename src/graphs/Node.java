package graphs;

import graphs.State;

public class Node {

    public Node[] child;
    public int childCount;
    private int vertex;
    public State state;

    public Node(int vertex)
    {
        this.vertex = vertex;
    }

    public Node(int vertex, int childlen)
    {
        this.vertex = vertex;
        childCount = 0;
        child = new Node[childlen];
    }

    public void addChildNode(Node newChild)
    {
        newChild.state = State.Unvisited;
        if(childCount < 30)
        {
            this.child[childCount] = newChild;
            childCount++;
        }
    }

    public Node[] getChild()
    {
        return child;
    }

    public int getVertex()
    {
        return vertex;
    }

}