package sample;

import MatrixCalculate.MatrixCalculate;
import SimpleCalculate.SimpleCalculate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    public void MatrixCalculate(ActionEvent actionEvent) throws IOException {
        try{
            new MatrixCalculate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public void SimpleCalculate(ActionEvent actionEvent) throws IOException {
        try{
            new SimpleCalculate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
