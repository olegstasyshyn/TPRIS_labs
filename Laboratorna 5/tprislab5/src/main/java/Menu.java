import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {

    Menu() {
        try {
            menuList();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void menuList() throws Exception{
        InputStream serviceAccount = new FileInputStream("C:\\Users\\User\\Downloads\\TPRIS-fff677a0ea61.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        FirebaseApp.initializeApp(options);

        Firestore db = FirestoreClient.getFirestore();

        DocumentReference docRef = db.collection("TPRIS_lab5").document("List");
        DocumentReference docTree = db.collection("TPRIS_lab5").document("Tree");

        ListParam listParam = new ListParam();
        String change = "";
        System.out.println("Лабораторна 1:");
        System.out.println("1.Додавання елементів." +
                "\n2.Занесення в базу даних." +
                "\n3.Відображення списку");
        System.out.println("Лабораторна 2");
        System.out.println("4.Додавання елементів." +
                "\n5.Занесення в базу даних." +
                "\n6.Відображення дерева" +
                "\n7.Листи дерева: " +
                "\n8.Вихід");

        Scanner scanner = new Scanner(System.in);

        BTree tree = new BTree(10);

        while(!change.equals("8")){
            System.out.print("Виберіть пункт меню: ");
            change = scanner.nextLine();
            switch (Integer.parseInt(change)){
                case 1:
                    System.out.print("Введіть кількість елементів: ");
                    int numberOfElement = Integer.parseInt(scanner.nextLine());
                    int k = 1;
                    for (int i = 0; i < numberOfElement ; i++) {
                        System.out.print("Введіть " + (i + 1) + " елемент: ");
                        listParam.getListParam().add(k , scanner.nextLine());
                        k += 2;
                    }
                    break;
                case 2:
                    try {
                        listParam.addDataBase(docRef);
                        System.out.println("Дані занесені в БД");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    for (Object i : listParam.getListParam()){
                        System.out.println(i + " ");
                    }
                    break;
                case 4:
                    System.out.print("Введіть кількість елементів: ");
                    int numberOfElementTree = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < numberOfElementTree ; i++) {
                        System.out.print("Введіть " + (i + 1) + " елемент: ");
                        tree.insertBST(Integer.parseInt(scanner.nextLine()));
                    }
                    break;
                case 5:
                    try{
                        tree.addDataBaseTree(docTree);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("Дерево: ");
                    //tree.levelOrderTraversal(tree);
                    tree.printLinebyLine(tree);
                    break;
                case 7:
                    tree.howManyLeaves();
                    break;
                default:
                    System.out.println("Попробуйте ще раз :)");
            }
        }
    }

}
