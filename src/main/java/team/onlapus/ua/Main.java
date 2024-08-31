package team.onlapus.ua;

import team.onlapus.ua.gui.GUI;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {


    static boolean stopSound = false;
    static boolean startListeningSound = false;
    static boolean exitLoop = false;
    static boolean listenPause;

    public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {

        JFrame frame = new JFrame(Data.PROGRAM_NAME);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new GUI());
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    public static void playSound() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("D:\\my programs\\java\\projects\\Reminder\\src\\main\\java\\org\\example\\sounds\\PERERVA.wav"));
        Clip clip = AudioSystem.getClip();

        clip.open(inputStream);
        clip.start();
    }

    public static void makeBreak ( int minutes) throws InterruptedException, IOException {
        for (int i = minutes * 60; i >= 0; i--) {
            System.out.println("break ends in " + Integer.parseInt(String.valueOf(i / 60)) + "m " + i % 60 + "s");
            Thread.sleep(1000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
    }
}