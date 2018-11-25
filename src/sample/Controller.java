package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Controller {

    @FXML public Button loginButton;
    @FXML public ProgressBar progressBar;
    @FXML public PasswordField passwordField;
    Session session = Session.getCurrentSession();







    public void handleLoginButton(ActionEvent event) throws IOException{
        if(passwordField.getText().equals("admin")){
            session.add("userType","Admin");
            //runProgressBar();
            sceneChange(event);

        }
        else if(passwordField.getText().equals("user")){
            session.add("userType","User");
            sceneChange(event);
        }
        else{
            AlertBox.alertBox("Error","Insert correct password");
        }


    }

    private void sceneChange(ActionEvent event) throws IOException{

        Parent MainLayoutParent = FXMLLoader.load(getClass().getResource("MainLayout.fxml"));
        Scene MainLayoutScene = new Scene(MainLayoutParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(MainLayoutScene);
        window.show();
    }

    private void runProgressBar() throws InterruptedException {

        for (int i = 0; i < 100; i++){
            progressBar.setProgress(i/100);
            Thread.sleep(100);

        }

    }

}
