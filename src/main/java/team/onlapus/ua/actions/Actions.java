package team.onlapus.ua.actions;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import team.onlapus.ua.Data;

public class Actions {

    public static void playTimerSound() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(Data.PROGRAM_PATH + "\\sounds\\timerSound.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(inputStream);
        clip.start();
    }

    public static String displayTime(int time) {
        if (time < 0) {
            JOptionPane.showMessageDialog(null, "ors-file Error, so this action skipped\n", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            if (time <= 60) {
                return time + "s";
            }

            if (time > 61 && time < 3600) {
                return Integer.parseInt(String.valueOf(time / 60)) + "m " + time % 60 + "s";
            }

            if (time > 3600) {
                return Integer.parseInt(String.valueOf(time / 60 / 60)) + "h " + Integer.parseInt(String.valueOf(time / 60 % 60)) + "m " + time % 60 + "s";
            }
        }

        return "-1s";
    }
}
