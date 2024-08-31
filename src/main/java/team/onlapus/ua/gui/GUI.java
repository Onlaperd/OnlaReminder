package team.onlapus.ua.gui;

import team.onlapus.ua.Data;
import team.onlapus.ua.actions.Load;

import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel {




    public GUI(){
        this.setPreferredSize(new Dimension(Data.PANEL_WIDTH, Data.PANEL_HEIGHT));
        this.setBackground(Data.ColorNames.darkBlue);
        this.setLayout(null);

        JLabel title = new JLabel(Data.PROGRAM_NAME);
        title.setBounds((int) ((Data.PANEL_WIDTH /2)/2), 5, 600, 50);
        title.setForeground(Color.white);
        title.setFont(new Font("BV Boli", Font.BOLD, 50));

        JButton loadButton = new JButton("load");
        loadButton.setBounds(5, 5, (Data.PANEL_WIDTH - 20)/2-10, Data.PANEL_HEIGHT - 5);
        loadButton.addActionListener(new Load());

        JButton createButton = new JButton("create");
        createButton.setBounds((Data.PANEL_WIDTH - 20)/2, 5, (Data.PANEL_WIDTH - 20)/2-5, Data.PANEL_HEIGHT - 5);
        createButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "sorry, this functionality is currently under development"));

        JPanel workSpace = new JPanel();
        workSpace.setBackground(Data.ColorNames.gray);
        workSpace.setBounds(10, 60, Data.PANEL_WIDTH - 20, Data.PANEL_HEIGHT - 70);
        workSpace.setLayout(null);
        workSpace.add(loadButton);
        workSpace.add(createButton);

        this.add(title);
        this.add(workSpace);


    }


}
