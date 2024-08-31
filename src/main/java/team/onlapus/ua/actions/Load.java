package team.onlapus.ua.actions;

import team.onlapus.ua.ors.ORSLanguage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

public class Load implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean toContinue = false;
        int userResponse;
        String code = null;

        String filePath = null;

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose Scenario");
        fileChooser.setCurrentDirectory(new File("D:\\my programs\\java\\projects\\OnlaReminder\\src\\main\\java\\team\\onlapus\\ua\\saves"));

        while (true) {
            userResponse = fileChooser.showOpenDialog(null);
            if (userResponse == JFileChooser.APPROVE_OPTION) {
                filePath = fileChooser.getSelectedFile().getAbsolutePath();
                toContinue = true;
            } else {
                break;
            }
            try {
                code = new String(Files.readAllBytes(Paths.get(filePath)));
                break;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,
                        "Error: Cannot access the file or file was not found",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        if (toContinue) {
            String[] content = code.split("\n");


            System.out.println(content[0]);

            if (stringsEquals(content[0], "$ors-valid")) {

                new ORSLanguage(code);

            } else {
                JOptionPane.showMessageDialog(null,
                        "Error: invalid file!",
                        "invalid file error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Error: use .ors files!",
                    "file extention error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }

    public static boolean stringsEquals(String one, String two) {

        char[] oneC = one.toCharArray();
        char[] twoC = two.toCharArray();

        for (int i = 0; i < oneC.length - 1; i++) {
            if (oneC[i] != twoC[i]) {
                return false;
            }
        }

        return true;
    }


}


