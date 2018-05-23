package EditingDataBase;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ControllerEditingDataBase {
    @FXML
    private TextField display1;
    @FXML
    private TextField display2;
    @FXML
    private TextField display3;
    @FXML
    private TextField display4;
    @FXML
    private TextField display5;



    @FXML
    private Button addData;
    public void updateData(ActionEvent actionEvent) throws Exception{

            InputStream serviceAccount = new FileInputStream("C:\\Users\\User\\Downloads\\TPRIS-fff677a0ea61.json");
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(credentials)
                    .build();
            FirebaseApp.initializeApp(options);

            Firestore db = FirestoreClient.getFirestore();

            DocumentReference docRef = db.collection("EOM").document(display1.getText());
            Map<String , Object> data = new HashMap<String, Object>();
            data.put("Type" , display2.getText());
            data.put("Frequency" , display3.getText());
            data.put("Capacity of RAM" , display4.getText());
            data.put("Hard disk capacity" , display5.getText());
            ApiFuture<WriteResult> result = docRef.update(data);

            Stage stage = (Stage) addData.getScene().getWindow();
            stage.close();


    }

}
