package deleteDataBase;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DeleteDataBase {

    public DeleteDataBase() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/DeleteDataBase.fxml"));
        Pane load = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Видалення з бази даних");
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
    }

}
