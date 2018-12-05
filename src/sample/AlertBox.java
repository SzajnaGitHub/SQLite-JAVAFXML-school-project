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

import static sample.CDatabaseComm.Delete;
import static sample.CDatabaseComm.InsertProduct;


public class AlertBox{

     static void editBox(){
        Stage windows = new Stage();

        //Blocking interactions with other event
        windows.initModality(Modality.APPLICATION_MODAL);
        windows.setResizable(false);
        windows.setTitle("Shansky.app");//setting windows title

        Label label1 = new Label();//Main label message
        label1.setText("Edycja");
        label1.setFont(new Font(30));
        label1.setPadding(new Insets(-5,10,0,10));

        Label label2 = new Label();
        label2.setText("Nazwa");
        Label label3 = new Label();
        label3.setText("Ilość");
        Label label4 = new Label();
        label4.setText("Cena");

        Button Addbutton = new Button();//add button

        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();


        Addbutton.setOnAction(e->{
            System.out.println(ValidationClass.isInt(textField2,textField2.getText(),label3.getText()));
            System.out.println(ValidationClass.isString(textField1,textField1.getText(),label2.getText()));

            if (ValidationClass.isInt(textField2,textField2.getText(),label3.getText())==true &&
                    ValidationClass.isString(textField1,textField1.getText(),label2.getText()) == true){
                //System.out.println("it works beaches!");
                InsertProduct(textField1.getText(),999,Double.parseDouble(textField2.getText()));
                textField1.setText("");
                textField2.setText("");
            } else {
                windows.close();
            }
        });



        Addbutton.setText("Edytuj");

        VBox siatkapoziomaVBox1 = new VBox(5);
        siatkapoziomaVBox1.getChildren().addAll(label2,textField1);
        siatkapoziomaVBox1.setPadding(new Insets(5,35,5,35));

        VBox siatkapoziomaVBox2 = new VBox(5);
         siatkapoziomaVBox1.getChildren().addAll(label3,textField2);
         siatkapoziomaVBox2.setPadding(new Insets(0,35,10,35));

         VBox siatkapoziomaVBox3 = new VBox(5);
         siatkapoziomaVBox1.getChildren().addAll(label4,textField3);
         siatkapoziomaVBox2.setPadding(new Insets(0,35,10,35));

        VBox siatkapionowaVBox = new VBox(1);
        siatkapionowaVBox.getChildren().addAll(label1,siatkapoziomaVBox1,siatkapoziomaVBox2,siatkapoziomaVBox3,Addbutton);
        siatkapionowaVBox.setAlignment(Pos.CENTER);

        Scene popupScene = new Scene(siatkapionowaVBox,350,270);
        windows.setScene(popupScene);
        windows.showAndWait();

    }
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
        Label label4 = new Label();
        label4.setText("Cena");

        Button Addbutton = new Button();//add button

        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();


        Addbutton.setOnAction(e->{
            System.out.println(ValidationClass.isInt(textField2,textField2.getText(),label3.getText()));
            System.out.println(ValidationClass.isString(textField1,textField1.getText(),label2.getText()));

            if (ValidationClass.isInt(textField2,textField2.getText(),label3.getText())==true &&
                    ValidationClass.isString(textField1,textField1.getText(),label2.getText()) == true &&
                        ValidationClass.isInt(textField3,textField3.getText(),label4.getText())==true
            ){

                InsertProduct(textField1.getText(),999,Double.parseDouble(textField2.getText()));
                textField1.setText("");
                textField2.setText("");
            } else {
                windows.close();
            }
        });



        Addbutton.setText(buttonName);

            VBox siatkapoziomaVBox1 = new VBox(5);
                siatkapoziomaVBox1.getChildren().addAll(label2,textField1);
                siatkapoziomaVBox1.setPadding(new Insets(5,35,5,35));

            VBox siatkapoziomaVBox2 = new VBox(5);
                siatkapoziomaVBox1.getChildren().addAll(label3,textField2);
                siatkapoziomaVBox2.setPadding(new Insets(0,35,10,35));

            VBox siatkapoziomaVBox3 = new VBox(5);
                siatkapoziomaVBox1.getChildren().addAll(label4,textField3);
                siatkapoziomaVBox2.setPadding(new Insets(0,35,10,35));

        VBox siatkapionowaVBox = new VBox(1);
        siatkapionowaVBox.getChildren().addAll(label1,siatkapoziomaVBox1,siatkapoziomaVBox2,siatkapoziomaVBox3,Addbutton);
        siatkapionowaVBox.setAlignment(Pos.CENTER);

        Scene popupScene = new Scene(siatkapionowaVBox,300,235);
        windows.setScene(popupScene);
        windows.showAndWait();
    }

    static void popupDel(){
        Stage windows = new Stage();
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
        DelButton.setOnAction(e-> {
            if(ValidationClass.isInt(textField,textField.getText(),label.getText())==false){
                Delete(Integer.parseInt(textField.getText()));
            }
            else{
                windows.close();
            }
        });
        DelButton.setText("Delete");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,tfVBox,DelButton);
        layout.setAlignment(Pos.CENTER);

        Scene alertBoxScene = new Scene(layout,250,150);
        windows.setScene(alertBoxScene);
        windows.showAndWait();
    }

     static void popupEdit(){
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

             if(ValidationClass.isInt(textField,textField.getText(),label.getText())==false){
                 //db.Update();

             }
             else {
                 editBox();
             }

         });



            Pane buttonPane = new Pane();
            buttonPane.getChildren().addAll(EditButton);


         VBox layout = new VBox(5);
         layout.getChildren().addAll(label,tfVBox,buttonPane);
         layout.setAlignment(Pos.CENTER);

         Scene alertBoxScene = new Scene(layout,250,100);
         windows.setScene(alertBoxScene);
         windows.showAndWait();

     }

}
