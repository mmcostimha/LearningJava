package AlarmClock;

import java.time.LocalTime;

public class AlarmClock implements Runnable{

    private final LocalTime alarmTime;

    public AlarmClock(LocalTime alarmTime){
        this.alarmTime = alarmTime;
    }

    @Override
    public void run(){

        while (LocalTime.now().isBefore(alarmTime)){
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("Thread was interrupted");
            }
        }
        System.out.println("Alarm Jump scare!!!");
        System.exit(0);

    }
}
