package sample;


import javafx.scene.control.TextField;

public class ValidationClass {

    static boolean isInt(TextField txt, String message,String lbl){

        try{
            int id = Integer.parseInt(message);

            return true;

        }catch(NumberFormatException e){
            AlertBox.alertBox("Error","Wartość w polu '" +lbl+"' nie jest liczbą");
            return false;
        }
    }
    static boolean isString(TextField txt,String message,String lbl){

        message = message.trim();
        if(message.matches("^[a-zA-Z]+$")){
            return true;
        }
        if(message == null || message.equals("")){
            AlertBox.alertBox("Error","Pole '" +lbl+"' jest puste");
            return false;
        }

        AlertBox.alertBox("Error","Wartość w polu '" +lbl+"' nie może być liczbą");
        return false;
    }

}
