package com.zjuee.gui;

import com.zjuee.util.Countries;
import com.zjuee.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TextArea extends JFrame {
    private JButton b = new JButton("Add Data");
    private JButton c = new JButton("Clear Data");
    private JTextArea t = new JTextArea(20, 40);
    private Map<String, String> m = new HashMap<>();
    public TextArea() {
        m.putAll(Countries.capitals());
        b.addActionListener(e -> {
            for (Map.Entry<String, String> me : m.entrySet()) {
                t.append(me.getKey() + ": " + me.getValue());
            }
        });
        c.addActionListener(e -> {
            t.setText("");
        });
        setLayout(new FlowLayout());
        add(b);
        add(c);
        add(new JScrollPane(t));
    }

    public static void main(String[] args) {
        SwingConsole.run(new TextArea(), 475, 425);
    }
}
