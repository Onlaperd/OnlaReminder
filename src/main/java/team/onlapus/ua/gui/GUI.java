package team.onlapus.ua.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import team.onlapus.ua.Data.ColorNames;
import team.onlapus.ua.actions.Load;

public class GUI extends JPanel {
    public GUI() {
        this.setPreferredSize(new Dimension(800, 500));
        this.setBackground(ColorNames.darkBlue);
        this.setLayout(null);

        JLabel title = new JLabel("OnlaReminder");
        title.setBounds(200, 5, 600, 50);
        title.setForeground(Color.white);
        title.setFont(new Font("BV Boli", Font.BOLD, 50));

        JButton loadButton = new JButton("load");
        loadButton.setBounds(5, 5, 380, 495);
        loadButton.setFocusable(false);
        loadButton.addActionListener(new Load());

        JButton createButton = new JButton("create");
        createButton.setBounds(390, 5, 385, 495);
        createButton.addActionListener((e) -> JOptionPane.showMessageDialog(null,
                "sorry, this functionality is currently under development"
        ));
        createButton.setFocusable(false);

        JPanel workSpace = new JPanel();
        workSpace.setBackground(ColorNames.gray);
        workSpace.setBounds(10, 60, 780, 430);
        workSpace.setLayout(null);
        workSpace.add(loadButton);
        workSpace.add(createButton);

        this.add(title);
        this.add(workSpace);
    }
}
