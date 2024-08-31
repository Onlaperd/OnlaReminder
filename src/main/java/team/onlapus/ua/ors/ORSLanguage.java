package team.onlapus.ua.ors;

import javax.swing.*;

public class ORSLanguage {

    public ORSLanguage(String code) {
        ORSFrame frame = new ORSFrame();
        String[] content = code.split("\n");

        programLoop:
        while (true) {
            for (int i = 0; i < content.length; i++) {
                if (content[i].charAt(0) == '$') {
                    String[] line = content[i].split("/");
                    switch (line[0]) {
                        case "$MSG":
                            JOptionPane.showMessageDialog(null, line[1], "message", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "$BREAK":
                            break programLoop;
                    }
                }
            }
        }


    }

}

/*
$WAIT/5/test

$CHOOSE
-$CWAIT/300/coffee break
-$CWAIT/0/no break

$TIME/22:00
-$MSG/Go to sleep

$Date/01-01-9999
-msg/Happy new year!

$BREAK
*/