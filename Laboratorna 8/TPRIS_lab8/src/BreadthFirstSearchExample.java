import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchExample
{

    private Queue<Node> queue;
    static ArrayList<Node> nodes=new ArrayList<>();
    static class Node
    {
        int  data;
        boolean visited;

        Node(int data)
        {
            this.data=data;

        }
    }

    public BreadthFirstSearchExample()
    {
        queue = new LinkedList<>();
    }

    public ArrayList<Node> findNeighbours(int adjacency_matrix[][],Node x)
    {
        int nodeIndex=-1;

        ArrayList<Node> neighbours=new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i).equals(x))
            {
                nodeIndex=i;
                break;
            }
        }

        if(nodeIndex!=-1)
        {
            for (int j = 0; j < adjacency_matrix[nodeIndex].length; j++) {
                if(adjacency_matrix[nodeIndex][j]==1)
                {
                    neighbours.add(nodes.get(j));
                }
            }
        }
        return neighbours;
    }

    public void bfs(int adjacency_matrix[][], Node node)
    {
        queue.add(node);
        node.visited=true;
        while (!queue.isEmpty())
        {

            Node element=queue.remove();
            System.out.print(element.data + " ");
            ArrayList<Node> neighbours=findNeighbours(adjacency_matrix,element);
            for (int i = 0; i < neighbours.size(); i++) {
                Node n = neighbours.get(i);
                if(n != null && !n.visited)
                {
                    queue.add(n);
                    n.visited = true;

                }
            }

        }
    }
}