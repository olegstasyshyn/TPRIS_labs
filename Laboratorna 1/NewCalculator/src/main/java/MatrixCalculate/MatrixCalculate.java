package MatrixCalculate;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MatrixCalculate {

     public MatrixCalculate() throws Exception{
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/MatrixCalculate.fxml"));
         AnchorPane load = (AnchorPane) loader.load();
         Stage stage = new Stage();
         stage.setTitle("MatrixCalculate");
         Scene scene = new Scene(load);
         stage.setScene(scene);
         stage.show();

     }
}
