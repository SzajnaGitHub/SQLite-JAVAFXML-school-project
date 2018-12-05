package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

import static sample.CDatabaseComm.ViewDB;


public class ControllerMainLayout implements Initializable{


   @FXML private Label logedAs;
   @FXML private Label IdDate;
   @FXML private Label IdTime;
   @FXML private Label MainLabel;
   @FXML private Button showDB2Button;
   @FXML private Button grahpDrawingButton;
   @FXML private TableView Table;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        grahpDrawingButton.setVisible(false);
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
    private void setIdTime() {
         new Thread(new Runnable() {
            @Override public void run() {
                for (int i = 1; i >0; i++) {
                    try {
                        LocalTime today = LocalTime.now();

                        Platform.runLater(new Runnable() {
                            @Override public void run() {
                                if (today.getHour() <= 9) {
                                    IdTime.setText("0" + today.getHour() + ":" + today.getMinute());
                                }
                                if (today.getMinute() <= 9) {
                                    IdTime.setText(today.getHour() + ":0" + today.getMinute());
                                } else {
                                    IdTime.setText(today.getHour() + ":" + today.getMinute());
                                }
                            }
                        });
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                }}}
            }).start();

    }
    private void setIdDate(){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");
        String dateString = dateFormat.format(currentDate);
        IdDate.setText(dateString);
    }
    public void hanglewarehouseButton(){

        grahpDrawingButton.setVisible(true);
        MainLabel.setText("Stan Magazynu");
        ViewDB("warehouses");
    }
    public void hangleAddButton(){
        MainLabel.setText("Dodawanie elementów");
        grahpDrawingButton.setVisible(false);
        AlertBox.popupAdd("Dodawanie","Nazwa", "Ilość","Add");

    }
    public void hangleDeleteButton(){
        grahpDrawingButton.setVisible(false);
        MainLabel.setText("Usuwanie elementów");
        AlertBox.popupDel();
    }
    public void hangleEditButton(){
        grahpDrawingButton.setVisible(false);
        MainLabel.setText("Edycja elementów");
        AlertBox.popupEdit();

    }
    public void hangleShowDB2Button(){
        CDatabaseComm db = new CDatabaseComm("test.db");
        grahpDrawingButton.setVisible(true);
        MainLabel.setText("Finanse");
        ViewDB("balance");
    }
    public void DrawGraph(){
        //funckja do rysowania grafu, specjalnie dla Ciebie
    }
    public void TableViewFillMethod(){


    }


}





