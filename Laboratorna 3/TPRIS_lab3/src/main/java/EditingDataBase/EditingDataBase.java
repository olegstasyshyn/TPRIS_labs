package EditingDataBase;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EditingDataBase {
    public EditingDataBase() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/EditingDataBase.fxml"));
        Pane load = (Pane) loader.load();
        Stage stage = new Stage();
        stage.setTitle("Редагування");
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
    }
}
