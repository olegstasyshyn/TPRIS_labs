import java.util.Scanner;

public class Main {
        public static void main(String[] args) {

            BTree bstree = new BTree(5);
            bstree.insertBST(3);
            bstree.insertBST(1);
            bstree.insertBST(4);
            bstree.insertBST(10);
            bstree.insertBST(15);
            bstree.insertBST(7);
            bstree.insertBST(11);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Дерево до змін: ");
            bstree.printLinebyLine(bstree);
            System.out.println();
            System.out.println("Введіть вершину для зміни: ");
            int node = scanner.nextInt();
            System.out.println("Введіть змінену вершину: ");
            int changeNode = scanner.nextInt();
            bstree.search(node , changeNode);
            System.out.println("Дерево пісял змін: ");
            bstree.printLinebyLine(bstree);
        }
}