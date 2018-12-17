package sample;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.time.LocalTime;

/**
 * Object of this class is Thread.
 * This class is used to create clock
 */
public class CClockThread implements Runnable {

    Label IdTime;

    public CClockThread(Label IdTime) {
        this.IdTime = IdTime;
    }

    @Override
    public void run() {


            while (1 == 1) {
                try {
                    LocalTime today = LocalTime.now();

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if (today.getHour() <= 9) {
                                IdTime.setText("0" + today.getHour() + ":" + today.getMinute());
                            }
                            if (today.getMinute() <= 9) {
                                IdTime.setText(today.getHour() + ":0" + today.getMinute());
                            }
                            if (today.getMinute() <= 9 && today.getHour() <= 9) {
                                IdTime.setText("0" + today.getHour() + ":0" + today.getMinute());
                            } else {
                                IdTime.setText(today.getHour() + ":" + today.getMinute());
                            }
                        }
                    });
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        }
    }





