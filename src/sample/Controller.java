package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {

    @FXML public Button loginButton;
    @FXML public ProgressBar progressBar;
    @FXML public PasswordField passwordField;
    Session session = Session.getCurrentSession();


    public void handleLoginButton(ActionEvent event) throws IOException, InterruptedException {
        if (passwordField.getText().equals("admin")) {
            session.add("userType", 1);
            runProgressBar(event);


        } else if (passwordField.getText().equals("user")) {
            session.add("userType", 2);
            runProgressBar(event);

        } else {
            passwordField.setText("");
            AlertBox.alertBox("Error", "Insert correct password");
        }


    }

    /**
     * This method change scenes
     * @param event
     * @throws IOException
     */
    private void sceneChange(ActionEvent event) throws IOException {

        Parent MainLayoutParent = FXMLLoader.load(getClass().getResource("MainLayout.fxml"));
        Scene MainLayoutScene = new Scene(MainLayoutParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setResizable(false);

        window.setScene(MainLayoutScene);
        window.show();
    }

    /**
     * This method create progressBar and handle it
     * @param event
     * @throws InterruptedException
     */
    private void runProgressBar(ActionEvent event) throws InterruptedException{

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    try {
                        final int a = i;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                if( a==50){
                                    try {
                                        Thread.sleep(1000);
                                        progressBar.setProgress(1/2);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } else{
                                    progressBar.setProgress(a / 100.0);
                                }
                                if(progressBar.getProgress()==1) {
                                    try {
                                        sceneChange(event);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }});
                        Thread.sleep(20);
                    } catch (Exception e) {
                        e.printStackTrace();

              }



                }
            }}).start();


    }

}