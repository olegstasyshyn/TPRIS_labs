package sample;

import EditingDataBase.EditingDataBase;
import addDataBase.AddDataBase;
import deleteDataBase.DeleteDataBase;
import javafx.event.ActionEvent;
import searchDataBase.SearchDataBase;
import showDataBase.ShowDataBase;

public class Controller {


    public void addDataBase(ActionEvent actionEvent) {
        try{
            new AddDataBase();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteDataBase(ActionEvent actionEvent) {

        try{
            new DeleteDataBase();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void editingDataBase(ActionEvent actionEvent) {
        try{
            new EditingDataBase();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void searchDataBase(ActionEvent actionEvent) {
        try{
            new SearchDataBase();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void comparsionDataBase(ActionEvent actionEvent) {
    }

    public void showDataBase(ActionEvent actionEvent) {
        try{

            new ShowDataBase();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
