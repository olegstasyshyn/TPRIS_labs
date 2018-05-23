package showDataBase;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class ControllerShowDataBase implements Initializable {
    private ObservableList<showDataBase.EOM> eomData = FXCollections.observableArrayList();

    @FXML
    private TableView<showDataBase.EOM> tableEOM;

    @FXML
    private TableColumn<showDataBase.EOM, String> company;
    @FXML
    private TableColumn<showDataBase.EOM, String> Type;
    @FXML
    private TableColumn<showDataBase.EOM, String> frequency;
    @FXML
    private TableColumn<showDataBase.EOM, String> RAM;
    @FXML
    private TableColumn<showDataBase.EOM, String> hardDrive;


    @FXML
    public void initialize(URL location, ResourceBundle resources){
        try {
            initData();

            company.setCellValueFactory(new PropertyValueFactory<showDataBase.EOM, String>("company"));
            Type.setCellValueFactory(new PropertyValueFactory<showDataBase.EOM, String>("typeProcessor"));
            frequency.setCellValueFactory(new PropertyValueFactory<showDataBase.EOM, String>("frequency"));
            RAM.setCellValueFactory(new PropertyValueFactory<showDataBase.EOM, String>("RAM"));
            hardDrive.setCellValueFactory(new PropertyValueFactory<showDataBase.EOM, String>("hardDrive"));

            tableEOM.setItems(eomData);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void initData() throws Exception{
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
            eomData.add(new showDataBase.EOM(document.getId(), document.getString("Type"),
                    document.getString("Frequency"), document.getString("Capacity of RAM"), document.getString("Hard disk capacity")));

        }

    }
}
