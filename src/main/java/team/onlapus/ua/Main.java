package team.onlapus.ua;

import javax.swing.*;

import team.onlapus.ua.gui.GUI;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame(Data.PROGRAM_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GUI());
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}