package SimpleCalculate;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SimpleCalculate {
    public SimpleCalculate() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/SimpleCalculate.fxml"));
        AnchorPane load = (AnchorPane) loader.load();
        Stage stage = new Stage();
        stage.setTitle("SimpleCalculate");
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
    }
}
