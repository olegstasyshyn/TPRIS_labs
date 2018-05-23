import java.util.Random;

class Test{
    public static void main(String[] args) {

        /*BreadthFirstSearchExample.Node node4 = new BreadthFirstSearchExample.Node('A');
        BreadthFirstSearchExample.Node node1 = new BreadthFirstSearchExample.Node('B');
        BreadthFirstSearchExample.Node node2 = new BreadthFirstSearchExample.Node('C');
        BreadthFirstSearchExample.Node node3 = new BreadthFirstSearchExample.Node('D');
        BreadthFirstSearchExample.Node node6 = new BreadthFirstSearchExample.Node('E');
        BreadthFirstSearchExample.Node node5 = new BreadthFirstSearchExample.Node('F');
        BreadthFirstSearchExample.Node node7 = new BreadthFirstSearchExample.Node('E');

        BreadthFirstSearchExample.nodes.add(node4);
        BreadthFirstSearchExample.nodes.add(node1);
        BreadthFirstSearchExample.nodes.add(node2);
        BreadthFirstSearchExample.nodes.add(node3);
        BreadthFirstSearchExample.nodes.add(node6);
        BreadthFirstSearchExample.nodes.add(node5);
        BreadthFirstSearchExample.nodes.add(node7);
        int adjacency_matrix2[][] = {
                {0,1,1,0,0,0,0},
                {0,0,0,1,0,0,0},
                {0,1,0,1,1,1,0},
                {0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1},
                {0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0},
        };*/
        Random random = new Random();
        /*char [] newArr = new char[5];
        for(int i = 0; i < newArr.length; i++){
            newArr[i] = (char) random.nextInt();
            System.out.println(newArr[i]);
        }
*/
        BreadthFirstSearchExample.Node [] namesNode = new BreadthFirstSearchExample.Node[5000];
        for(int i = 0 ; i < namesNode.length; i++){
            namesNode[i] = new BreadthFirstSearchExample.Node(i);
            BreadthFirstSearchExample.nodes.add(namesNode[i]);
        }


        int [][] adjacency_matrix2 = new int[5000][5000];
        for(int i = 0; i < adjacency_matrix2.length; i++){
            for(int j= 0; j < adjacency_matrix2[i].length; j++){
                adjacency_matrix2[i][j] = (int) Math.round(Math.random());
                System.out.print(adjacency_matrix2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The BFS traversal of the graph is ");
        BreadthFirstSearchExample bfsExample = new BreadthFirstSearchExample();
        bfsExample.bfs(adjacency_matrix2, namesNode[0]);


    }
}
