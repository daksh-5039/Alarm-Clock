import java.time.LocalTime;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        boolean timer = false;
        Scanner sc = new Scanner(System.in);
        Alarm alarm = new Alarm();

        Thread thread = new Thread(alarm);

//      Inputs in alarm clock
        System.out.print("Enter hours: ");
        int hh = sc.nextInt();
        System.out.print("Enter minutes: ");
        int mm = sc.nextInt();
        System.out.print("Enter seconds: ");
        int ss = sc.nextInt();
        sc.nextLine();

        LocalTime now = LocalTime.now();
        LocalTime alarmTime = LocalTime.of(hh, mm, ss);

//      Alarm is triggered
        while(!timer){
            now = LocalTime.now().withNano(0);
            if(now.equals(alarmTime)){
                thread.start();
                timer = true;
            }
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                System.out.println("Process is interrupted");
            }
        }

//      Stopping the alarm
        String stop = "";
        while(true) {
            System.out.print("Type Stop to turn off the alarm: ");
            stop = sc.nextLine().toUpperCase();
            if (stop.equals("STOP")) {
                alarm.stop = false;
                break;
            }
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                System.out.println("Thread is interrupted");
            }
        }
    }
}