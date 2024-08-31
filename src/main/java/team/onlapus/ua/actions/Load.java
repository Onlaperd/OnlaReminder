package team.onlapus.ua.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import team.onlapus.ua.Data;
import team.onlapus.ua.ors.ORSLanguage;

public class Load implements ActionListener {
    public Load() {
    }

    public void actionPerformed(ActionEvent e) {
        boolean toContinue = false;
        String code = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose Scenario");
        fileChooser.setCurrentDirectory(new File(Data.PROGRAM_PATH + "\\saves\\"));

        while(true) {
            int userResponse = fileChooser.showOpenDialog(null);
            if (userResponse != 0) {
                break;
            }

            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            toContinue = true;

            try {
                code = new String(Files.readAllBytes(Paths.get(filePath)));
                break;
            } catch (IOException var8) {
                JOptionPane.showMessageDialog(null, "Error: Cannot access the file or file was not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (toContinue) {
            String[] content = code.split("\n");
            if (stringsEquals(content[0], "$ors-valid")) {
                new ORSLanguage(code);
            } else {
                JOptionPane.showMessageDialog(null, "Error: invalid file!", "invalid file error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: use .ors files!", "file extention error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static boolean stringsEquals(String one, String two) {
        char[] oneC = one.toCharArray();
        char[] twoC = two.toCharArray();

        for(int i = 0; i < oneC.length - 1; ++i) {
            if (oneC[i] != twoC[i]) {
                return false;
            }
        }

        return true;
    }
}
