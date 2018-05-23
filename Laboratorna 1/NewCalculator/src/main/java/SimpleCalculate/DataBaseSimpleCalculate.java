package SimpleCalculate;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataBaseSimpleCalculate {
    private DocumentReference documentReference;
    Firestore db;
    DataBaseSimpleCalculate(){
        try {
            InputStream serviceAccount = new FileInputStream("C:\\Users\\User\\Downloads\\tpris-a7cca-a1a6eeff232e.json");
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(credentials)
                    .build();
            FirebaseApp.initializeApp(options);


            db = FirestoreClient.getFirestore();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addDataBase(String operation , double result){
        try {
            String nameDocument = result + "";

            documentReference = db.collection("Calculate").document(nameDocument);
            Map<String , Double> data = new LinkedHashMap<String , Double>();

            data.put(operation, result);
            ApiFuture<WriteResult> apiFuture = documentReference.set(data);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void clearDataBase(double result){
        try {

            documentReference = db.collection("Calculate").document(result + "");

            ApiFuture<WriteResult> apiFuture = documentReference.delete();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
