package com.zjuee.practice.ch22;

import com.zjuee.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoTestRegularExpression extends JFrame {
    JTextArea string =  new JTextArea("string", 1, 10);
    JTextField regex = new JTextField("regex", 10);
    JTextArea txt = new JTextArea("result", 1, 10);
    JButton b = new JButton("run");
    ActionListener bl = e -> {
        Pattern p = Pattern.compile(regex.getText());
        Matcher m = p.matcher(string.getText());
        StringBuilder res = new StringBuilder();
        while (m.find())
            res.append(m.group());
        txt.setText(res.toString());
    };
    public DemoTestRegularExpression() {
        setLayout(new FlowLayout());
        b.addActionListener(bl);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(b);
        add(string);
        add(regex);
        add(txt);
    }
    public static void main(String[] args) {
        SwingConsole.run(new DemoTestRegularExpression(), 400, 200);
    }
}
