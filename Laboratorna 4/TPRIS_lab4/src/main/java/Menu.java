import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Menu {
    Menu() throws Exception{
        menu();
    }

    public void menu() throws Exception{
        InputStream serviceAccount = new FileInputStream("C:\\Users\\User\\Downloads\\TPRIS-fff677a0ea61.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        FirebaseApp.initializeApp(options);

        Firestore db = FirestoreClient.getFirestore();

        DocumentReference docRef = db.collection("TPRIS_lab4").document("Deque");

        Deque deque = new Deque();
        String change = "";
        System.out.println("1.Додавання в початок деку." +
                "\n2.Додавання в кінець деку." +
                "\n3.Видалення з початку деку:." +
                "\n4.Видалення з кінця деку." +
                "\n5.Занесення в базу даних." +
                "\n6.Відображення деку." +
                "\n7.Вихід");
        Scanner scanner = new Scanner(System.in);
        while(!change.equals("7")){
            System.out.print("Виберіть пункт меню: ");
            change = scanner.nextLine();
            switch (Integer.parseInt(change)){
                case 1:
                    System.out.print("Введіть елемент: ");
                    deque.getArrayDeque().addFirst(Integer.parseInt(scanner.nextLine()));
                    break;
                case 2:
                    System.out.print("Введіть елемент: ");
                    deque.getArrayDeque().addLast(Integer.parseInt(scanner.nextLine()));
                    break;
                case 3:
                    deque.getArrayDeque().removeFirst();
                    System.out.println("Елемент видалений.");
                    break;
                case 4:
                    deque.getArrayDeque().removeLast();
                    System.out.println("Елемент видалений.");
                    break;
                case 5:
                    try {
                        deque.addDataBase(docRef);
                        System.out.println("Дані занесені в БД");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    for (Object i : deque.getArrayDeque()){
                        System.out.println(i + " ");
                    }
                    break;
                default:
                    System.out.println("Попробуйте ще раз :)");
            }
        }
    }
}
