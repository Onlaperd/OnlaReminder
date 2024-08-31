package team.onlapus.ua.ors;

import team.onlapus.ua.actions.Actions;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class ORSLanguage {
    static final String WAITING_YOU_TO_CONTINUE = "waiting you to continue";
    Thread commandExecuting;
    private final Object lock = new Object();

    public ORSLanguage(String code) {
        ORSFrame frame = new ORSFrame();
        String[] content = code.split("\n");
        this.commandExecuting = new Thread(() -> {
            while(true) {
                for(int i = 0; i < content.length; ++i) {
                    if (content[i].charAt(0) == '$') {
                        String[] line = content[i].trim().split("/");
                        switch (line[0]) {
                            case "$MSG":
                                JOptionPane.showMessageDialog(null, line[1], "message", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            case "$WAIT":
                                this.orsWait(frame.label, Integer.parseInt(line[1]), line[2]);

                                try {
                                    synchronized(this.lock) {
                                        this.lock.wait();
                                        break;
                                    }
                                } catch (InterruptedException var18) {
                                    throw new RuntimeException(var18);
                                }
                            case "$CHOOSE":
                                int j = 1;
                                boolean tmp4Exit = false;

                                ArrayList<CWait> CWaits = new ArrayList<>();

                                String[] variations;
                                while(!tmp4Exit) {
                                    if (content[i + j].charAt(0) == '-') {
                                        variations = content[i + j].split("/");
                                        CWaits.add(new CWait(Integer.parseInt(variations[1]), variations[2]));
                                    } else {
                                        tmp4Exit = true;
                                    }
                                    j++;
                                }

                                variations = new String[CWaits.size()];

                                int userChoice;
                                for(userChoice = 0; userChoice < variations.length; ++userChoice) {
                                    variations[userChoice] = (CWaits.get(userChoice)).toString();
                                }

                                userChoice = JOptionPane.showOptionDialog(null,
                                        "Choose what to do next",
                                        "choose next",
                                        JOptionPane.YES_NO_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        variations,
                                        0
                                );
                                this.orsWait(frame.label, CWaits.get(userChoice).getTime(), CWaits.get(userChoice).getMessage());
                                synchronized(this.lock) {
                                    try {
                                        this.lock.wait();
                                        break;
                                    } catch (InterruptedException var15) {
                                        throw new RuntimeException(var15);
                                    }
                                }
                            case "$BREAK":
                                frame.dispose();
                                return;
                        }
                    }
                }
            }
        });
        this.commandExecuting.start();
    }

    private void orsWait(JLabel label, int time, String message) {
        new SwingWorker<Void, Integer>() {

            protected Void doInBackground() throws Exception {
                for(int i = time; i > -1; --i) {
                    this.publish(i);
                    Thread.sleep(1000L);
                }

                return null;
            }

            protected void process(List<Integer> chunks) {
                int i = chunks.get(chunks.size() - 1);
                label.setText("until " + message + " " + Actions.displayTime(i));
            }

            protected void done() {
                label.setText(WAITING_YOU_TO_CONTINUE);
                boolean[] stopSound = new boolean[]{false};
                (new Thread(() -> {
                    while(!stopSound[0]) {
                        try {
                            Actions.playTimerSound();
                            Thread.sleep(1700);
                        } catch (LineUnavailableException e) {
                            JOptionPane.showMessageDialog(null,
                                    "Error! LineUnavailableException\n" + e.getMessage(),
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null,
                                    "Error! IOException\n" + e.getMessage(),
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        } catch (UnsupportedAudioFileException e) {
                            JOptionPane.showMessageDialog(null,
                                    "Error! UnsupportedAudioFileException\n" + e.getMessage(),
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        } catch (InterruptedException e) {
                            JOptionPane.showMessageDialog(null,
                                    "Error! InterruptedException\n" + e.getMessage(),
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }
                    }

                })).start();
                JOptionPane.showMessageDialog(null,
                        "press OK to continue",
                        "press OK",
                        JOptionPane.INFORMATION_MESSAGE);
                stopSound[0] = true;
                synchronized(lock) {
                    lock.notify();
                }
            }
        }.execute();
    }
}
