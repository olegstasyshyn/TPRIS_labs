package MatrixCalculate;

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

public class DataBaseMatrixCalculate {
    private DocumentReference documentReference;
    Firestore db;
    DataBaseMatrixCalculate(){
        try {
            InputStream serviceAccount = new FileInputStream("C:\\Users\\User\\Downloads\\TPRIS-fff677a0ea61.json");
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

    public void addDataBase(int[][] matrixOne , int[][] matrixTwo , int[][] matrixResult){
        try {

            Date now = new Date();
            String stringMatrixOne = "" , stringMatrixTwo = "" , stringMatrixResult = "";
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    stringMatrixOne += matrixOne[i][j] + " ";
                    stringMatrixTwo += matrixTwo[i][j] + " ";
                    stringMatrixResult += matrixResult[i][j] + " ";

                }
                stringMatrixOne += "/";
                stringMatrixTwo += "/";
                stringMatrixResult += "/";
            }
            System.out.println(stringMatrixOne);
            documentReference = db.collection("Matrix calculate").document(DateFormat.getTimeInstance().format(now));
            Map<String , String> data = new LinkedHashMap<String , String>();
            data.put("Matrix 1" , stringMatrixOne);
            data.put("Matrix 2" , stringMatrixTwo);
            data.put("Result" , stringMatrixResult);

            ApiFuture<WriteResult> apiFuture = documentReference.set(data);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
