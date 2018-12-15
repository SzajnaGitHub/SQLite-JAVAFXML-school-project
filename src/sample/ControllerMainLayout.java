package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

import static sample.CDatabaseComm.Connect;
import static sample.CLineChart.DrawLineChart;


public class ControllerMainLayout implements Initializable{


    public TableColumn<?,?> colID;
    public TableColumn<?,?> colName;
    public TableColumn<?,?> colPrice;
    public TableColumn<?,?> colCapacity;
    @FXML private Label logedAs;
    @FXML private Label IdDate;
    @FXML private Label IdTime;
    @FXML private Label MainLabel;
    @FXML private Button showDB2Button;
    @FXML private Button grahpDrawingButton;
    @FXML private TableView<CDataClass> Table;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        grahpDrawingButton.setVisible(false);
        setLogedAsMethod();
        setIdTime();
        setIdDate();
        TableViewFillMethod();
        if(Session.getCurrentSession().get("userType")==2){
            showDB2Button.setDisable(true);//wyłączanie przycisków
        }

    }

    /**
     * This method set "logedAs" Label text as "Admin" when value of Session "userType" is 1
     */
    private void setLogedAsMethod(){
        if(Session.getCurrentSession().get("userType")==1){
            logedAs.setText("Admin");
        }
        else{
            logedAs.setText("User");

        }

    }

    /**
     * This method set "IdTime" Label as actual time in Thread
     */
    private void setIdTime() {
         new Thread(new Runnable() {
            @Override public void run() {
                for (int i = 1; i <5; i++) {
                    try {
                        LocalTime today = LocalTime.now();

                        Platform.runLater(new Runnable() {
                            @Override public void run() {
                                if (today.getHour() <= 9) {
                                    IdTime.setText("0" + today.getHour() + ":" + today.getMinute());
                                }
                                if (today.getMinute() <= 9) {
                                    IdTime.setText(today.getHour() + ":0" + today.getMinute());
                                }
                                if(today.getMinute() <= 9 &&today.getHour() <= 9 ){
                                    IdTime.setText("0" + today.getHour() + ":0" + today.getMinute());
                                }
                                else {
                                    IdTime.setText(today.getHour() + ":" + today.getMinute());
                                }
                            }
                        });
                        Thread.sleep(60000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                }}}
            }).start();

    }
    /**
     * This method set "IdDate" Label as actual date
     */
    private void setIdDate(){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");
        String dateString = dateFormat.format(currentDate);
        IdDate.setText(dateString);
    }

    public void hanglewarehouseButton(){
        grahpDrawingButton.setVisible(true);
        MainLabel.setText("Stan Magazynu");
        TableViewFillMethod();
    }
    public void hangleAddButton(){
        MainLabel.setText("Dodawanie elementów");
        grahpDrawingButton.setVisible(false);
        AlertBox.popupAdd("Dodawanie","Nazwa", "Ilość","Add");
        TableViewFillMethod();

    }
    public void hangleDeleteButton(){
        grahpDrawingButton.setVisible(false);
        MainLabel.setText("Usuwanie elementów");
        AlertBox.popupDel();
        TableViewFillMethod();
    }
    public void hangleEditButton(){
        grahpDrawingButton.setVisible(false);
        MainLabel.setText("Edycja elementów");
        AlertBox.popupEdit();
        TableViewFillMethod();

    }
    public void hangleShowDB2Button(){
        grahpDrawingButton.setVisible(true);
        MainLabel.setText("Finanse");
        DrawLineChart();
    }

    /**
     * this method draws Graph
     */
    public void DrawGraph(){
        CBarChart chart = new CBarChart();
        chart.DrawBarChart();
    }

    /**
     * this method fills JavaFX TableView
     */
    private void TableViewFillMethod(){
        ObservableList<CDataClass> data  = FXCollections.observableArrayList();

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colCapacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));

        String sql = "select * from warehouses";
        try(Connection conn = Connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                data.add(new CDataClass(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getDouble("capacity")));
            }
        }catch (SQLException e){e.getMessage();}
        Table.setItems(data);
    }
}





