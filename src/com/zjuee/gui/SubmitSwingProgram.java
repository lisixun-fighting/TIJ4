package com.zjuee.gui;

import com.zjuee.util.SwingConsole;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class SubmitSwingProgram extends JFrame {
    JLabel label;
    public SubmitSwingProgram() {
        super("Hello Swing");
        label = new JLabel("A Label");
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setVisible(true);
    }
    static SubmitSwingProgram ssp;
    public static void main(String[] args) throws InterruptedException {
//        SwingUtilities.invokeLater(() ->
//                ssp = new SubmitSwingProgram());
        ssp = new SubmitSwingProgram();
        SwingConsole.run(ssp, 300, 100);
        TimeUnit.SECONDS.sleep(2);
        SwingUtilities.invokeLater(() ->
                ssp.label.setText("Hey! This is Different!"));

    }
}
