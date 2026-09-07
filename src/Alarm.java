import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Alarm implements Runnable{

    boolean stop = true;

    public void run(){

//      Alarm song input
        File alarmSong = new File("src/lucid dreams - juice wrld [edit audio](MP3_320K).wav");
        try{
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(alarmSong);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

//          Alarm is turned on!
            System.out.println("Alarm is on");
            clip.start();

//          Stopping the alarm
            while(stop) {
                try {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){
                    System.out.println("Thread is interrupted");
                }
            }
            clip.stop();
            clip.close();
        }
        catch(IOException e){
            System.out.println("Something went wrong");
        }
        catch (UnsupportedAudioFileException e) {
            System.out.println("File not supported");
        }
        catch(LineUnavailableException e){
            System.out.println("Line is not available");
        }
    }
}