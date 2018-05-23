package showDataBase;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ShowDataBase {

    public ShowDataBase() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ShowDataBase.fxml"));
        Pane load = loader.load();
        Stage stage = new Stage();
        stage.setTitle("БД");
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
    }

}
