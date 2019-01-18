package sample;

import javafx.scene.control.TextField;

    /**
     * This class validates Textfields in AlertBox Class.
     */
public class ValidationClass {

    /**
     * this method tests if value from textField is Integer
     * @param txt = textField
     * @param message = textField.getText() function
     * @param lbl = Label
     * @return true if value in textField is Integer or false when value in textField is not Integer
     */
    static boolean isInt(TextField txt, String message,String lbl){

        try{
            int id = Integer.parseInt(message);

            return true;

        }catch(NumberFormatException e){
            AlertBox.alertBox("Error","Wartość w polu '" +lbl+"' nie jest liczbą");
            return false;
        }
    }

    /**
     * this method tests if value from textField is String
     * @param txt = textField
     * @param message = textField.getText() function
     * @param lbl = Label
     * @return true if value in textField is String or false when value in textField is not String
     */
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
