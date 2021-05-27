package com.zjuee.practice.ch22;

import com.zjuee.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoButton extends JFrame {
    private JButton b1 = new JButton("yellow");
    private JButton b2 = new JButton("red");
    private JButton b3 = new JButton("blue");
    private JTextField txt = new JTextField(9);
    private ActionListener bl = e -> {
        String name = ((JButton) e.getSource()).getName();
        txt.setText(name);
    };
    public DemoButton() throws HeadlessException {
        b1.addActionListener(bl);
        b2.addActionListener(bl);
        b3.addActionListener(bl);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(b3);
        add(txt);
    }

    public static void main(String[] args) {
        SwingConsole.run(new DemoButton(), 300, 150);
    }
}
