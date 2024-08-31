package team.onlapus.ua.ors;

import team.onlapus.ua.Data;

import javax.swing.*;
import java.awt.*;

class ORSFrame extends JFrame {

    public JLabel label;

    ORSFrame(){
        this.setTitle(Data.PROGRAM_NAME);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        JPanel main = new JPanel();
        main.setPreferredSize(new Dimension(500,500));
        main.setBackground(Data.ColorNames.darkBlue);
        main.setLayout(null);

        JPanel workspace = new JPanel();
        workspace.setBounds(10, 10, 480, 480);
        workspace.setBackground(Data.ColorNames.gray);
        workspace.setLayout(new GridBagLayout());

        label = new JLabel("waiting you to continue");
        label.setFont(new Font("MV Boli", Font.BOLD, 30));
        label.setForeground(Color.white);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;

        workspace.add(label, gbc);

        main.add(workspace);

        this.add(main);
        this.pack();
        this.setVisible(true);

    }

}
