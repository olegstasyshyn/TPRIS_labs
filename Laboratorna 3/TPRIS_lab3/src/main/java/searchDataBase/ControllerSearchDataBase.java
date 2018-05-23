package searchDataBase;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;


public class ControllerSearchDataBase {

    @FXML
    private TextField searchData;

    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;

    public void searchDataButton(ActionEvent actionEvent) throws Exception {


        InputStream serviceAccount = new FileInputStream("C:\\Users\\User\\Downloads\\TPRIS-fff677a0ea61.json");
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .build();
        FirebaseApp.initializeApp(options);

        Firestore db = FirestoreClient.getFirestore();

        ApiFuture<QuerySnapshot> future = db.collection("EOM").get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for(QueryDocumentSnapshot document : documents) {
            /*eomData.add(new showDataBase.EOM(document.getId(), document.getString("Type"),
                    document.getString("Frequency"), document.getString("Capacity of RAM"), document.getString("Hard disk capacity")));*/
            if(searchData.getText().equals(document.getId())){
                label1.setText(document.getId());
                label2.setText(document.getString("Type"));
                label3.setText(document.getString("Frequency"));
                label4.setText(document.getString("Capacity of RAM"));
                label5.setText(document.getString("Hard disk capacity"));


            }

        }


    }
}
