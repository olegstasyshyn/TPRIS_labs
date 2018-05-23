package addDataBase;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class AddDataBase {
    public AddDataBase() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AddDataBase.fxml"));
        Pane load = (Pane) loader.load();
        Stage stage = new Stage();
        stage.setTitle("Додавання до бази даних");
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
    }

}
