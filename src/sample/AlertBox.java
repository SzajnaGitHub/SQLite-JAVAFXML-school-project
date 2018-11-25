package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;


    public class AlertBox{

    static void alertBox(String title, String message){
        Stage windows = new Stage();

        //Blocking interactions with other event
        windows.initModality(Modality.APPLICATION_MODAL);
        windows.setResizable(false);
        windows.setTitle(title);


        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button();
        closeButton.setOnAction(e-> windows.close());
        closeButton.setText("Exit");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene alertBoxScene = new Scene(layout,200,100);
        windows.setScene(alertBoxScene);
        windows.showAndWait();
    }

    static void popupAdd(String title,String labelname1,String labelname2,String buttonName){
        Stage windows = new Stage();
        CDatabaseComm db = new CDatabaseComm("test.db");

        //Blocking interactions with other event
        windows.initModality(Modality.APPLICATION_MODAL);
        windows.setResizable(false);
        windows.setTitle("Shansky.app");//setting windows title

        Label label1 = new Label();//Main label message
        label1.setText(title);
        label1.setFont(new Font(30));
        label1.setPadding(new Insets(-5,10,0,10));

        Label label2 = new Label();
        label2.setText(labelname1);
        Label label3 = new Label();
        label3.setText(labelname2);

        Button Addbutton = new Button();//add button

        TextField textField1 = new TextField();
        TextField textField2 = new TextField();

        //Addbutton.setOnAction(e-> windows.close());
        Addbutton.setOnAction(e->{db.InsertProduct(textField1.getText(),999,Double.parseDouble(textField2.getText()));
        windows.close();});
        Addbutton.setText(buttonName);

            VBox siatkapoziomaVBox1 = new VBox(5);
                siatkapoziomaVBox1.getChildren().addAll(label2,textField1);
                siatkapoziomaVBox1.setPadding(new Insets(5,35,5,35));

            VBox siatkapoziomaVBox2 = new VBox(5);
                siatkapoziomaVBox1.getChildren().addAll(label3,textField2);
                 siatkapoziomaVBox2.setPadding(new Insets(0,35,10,35));

        VBox siatkapionowaVBox = new VBox(1);
        siatkapionowaVBox.getChildren().addAll(label1,siatkapoziomaVBox1,siatkapoziomaVBox2,Addbutton);
        siatkapionowaVBox.setAlignment(Pos.CENTER);

        Scene popupScene = new Scene(siatkapionowaVBox,300,220);
        windows.setScene(popupScene);
        windows.showAndWait();
    }

    static void popupDel(){
        Stage windows = new Stage();
        CDatabaseComm db = new CDatabaseComm("test.db");
        //Blocking interactions with other event
        windows.initModality(Modality.APPLICATION_MODAL);
        windows.setResizable(false);
        windows.setTitle("Shansky.app");


        Label label = new Label();
        label.setText("Podaj ID elementu do usunięcia");

        TextField textField = new TextField();
        VBox tfVBox = new VBox(0);
        tfVBox.setPadding(new Insets(0,100,0,100));
        tfVBox.getChildren().add(textField);

        Button DelButton = new Button();
        DelButton.setOnAction(e-> {db.Delete(Integer.parseInt(textField.getText()));
        windows.close();});
        DelButton.setText("Delete");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,tfVBox,DelButton);
        layout.setAlignment(Pos.CENTER);

        Scene alertBoxScene = new Scene(layout,250,150);
        windows.setScene(alertBoxScene);
        windows.showAndWait();
    }

     static void popupEdit(){
        CDatabaseComm db = new CDatabaseComm("test.db");
         Stage windows = new Stage();

         //Blocking interactions with other event
         windows.initModality(Modality.APPLICATION_MODAL);
         windows.setResizable(false);
         windows.setTitle("Shansky.app");


         Label label = new Label();
         label.setText("Podaj ID elementu do edytowania");

         TextField textField = new TextField();
         VBox tfVBox = new VBox(0);
         tfVBox.setPadding(new Insets(0,100,0,100));
         tfVBox.getChildren().add(textField);

         Button EditButton = new Button();
         EditButton.setText("Edit");
         EditButton.setLayoutX(160);
         EditButton.setLayoutY(10);
         EditButton.setOnAction(e->{
             popupAdd("Edycja","Nowa nazwa","Ilość","Edit");
         });

        Button exitButton = new Button();
        exitButton.setText("Exit");
        exitButton.setLayoutX(200);
        exitButton.setLayoutY(10);
        exitButton.setOnAction(e-> windows.close());


            Pane buttonPane = new Pane();
            buttonPane.getChildren().addAll(EditButton,exitButton);


         VBox layout = new VBox(5);
         layout.getChildren().addAll(label,tfVBox,buttonPane);
         layout.setAlignment(Pos.CENTER);

         Scene alertBoxScene = new Scene(layout,250,100);
         windows.setScene(alertBoxScene);
         windows.showAndWait();

     }


}
