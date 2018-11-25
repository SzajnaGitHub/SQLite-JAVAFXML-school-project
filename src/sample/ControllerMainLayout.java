package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;


public class ControllerMainLayout implements Initializable{


   @FXML private Label logedAs;
   @FXML private Label IdDate;
   @FXML private Label IdTime;
   @FXML private Label MainLabel;
   @FXML private Button showDB2Button;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setLogedAsMethod();
        setIdTime();
        setIdDate();
        if(Session.getCurrentSession().get("userType").equals("User")){
            showDB2Button.setDisable(true);//wyłączanie przycisków
        }
    }



    private void setLogedAsMethod(){
            logedAs.setText(Session.getCurrentSession().get("userType"));
    }
    private void setIdTime(){
        LocalTime today = LocalTime.now();
            if(today.getHour()<=9) {
                IdTime.setText("0"+today.getHour() + ":" + today.getMinute() + ":" + today.getSecond());
            }
            else{
                IdTime.setText(today.getHour() + ":" + today.getMinute() + ":" + today.getSecond());

            }
    }
    private void setIdDate(){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");
        String dateString = dateFormat.format(currentDate);
        IdDate.setText(dateString);
    }
    public void hanglewarehouseButton(){
        CDatabaseComm db = new CDatabaseComm("test.db");
        MainLabel.setText("Stan Magazynu");
        db.ViewDB("warehouses");
    }
    public void hangleAddButton(){
        MainLabel.setText("Dodawanie elementów");
        AlertBox.popupAdd("Dodawanie","Nazwa", "Ilość","Add");
    }
    public void hangleDeleteButton(){
        MainLabel.setText("Usuwanie elementów");
        AlertBox.popupDel();
    }
    public void hangleEditButton(){
        MainLabel.setText("Edycja elementów");
        AlertBox.popupEdit();
    }
    public void hangleShowDB2Button(){
        MainLabel.setText("Finanse");
    }

}





