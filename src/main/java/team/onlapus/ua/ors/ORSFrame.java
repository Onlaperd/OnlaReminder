package team.onlapus.ua.ors;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import team.onlapus.ua.Data;
import team.onlapus.ua.Data.ColorNames;

class ORSFrame extends JFrame {
    public JLabel label;

    ORSFrame() {
        this.setTitle(Data.PROGRAM_NAME);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        JPanel main = new JPanel();
        main.setPreferredSize(new Dimension(500, 500));
        main.setBackground(ColorNames.darkBlue);
        main.setLayout(null);
        JPanel workspace = new JPanel();
        workspace.setBounds(10, 10, 480, 480);
        workspace.setBackground(ColorNames.gray);
        workspace.setLayout(new GridBagLayout());
        this.label = new JLabel("waiting you to continue");
        this.label.setFont(new Font("MV Boli", Font.BOLD, 30));
        this.label.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = 10;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = 0;
        workspace.add(this.label, gbc);
        main.add(workspace);
        this.add(main);
        this.pack();
        this.setVisible(true);
    }
}
