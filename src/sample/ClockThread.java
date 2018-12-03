package sample;

import java.time.LocalTime;

public class ClockThread implements Runnable {

    Thread thread;
    int getHour;
    int getMinute;

    ClockThread() {
        thread = new Thread(this, "my runnable thread");
        System.out.println("my thread created" + thread);
        thread.start();

    }


    public void run(){
        try {
            for (int i = 12; i > 10; i++) {

                LocalTime today = LocalTime.now();
                getHour = today.getHour();
                getMinute = today.getMinute();

                System.out.println("0"+today.getHour() + ":"+ today.getMinute());

                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
    public int getGetHour(){
        return getHour;
    }

    public int getGetMinute(){
        return getMinute;
    }

}