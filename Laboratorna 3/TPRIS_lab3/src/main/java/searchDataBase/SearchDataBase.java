package searchDataBase;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SearchDataBase {
    public SearchDataBase() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/SearchDataBase.fxml"));
        Pane load = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Пошук за фірмою EOM");
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
    }
}
