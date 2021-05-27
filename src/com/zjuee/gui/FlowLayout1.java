package com.zjuee.gui;

import com.zjuee.util.SwingConsole;

import javax.swing.*;
import java.awt.*;

public class FlowLayout1 extends JFrame {
    public FlowLayout1() {
        setLayout(new FlowLayout());
        for (int i = 0; i < 10; i++) {
            add(new JButton("Button " + i));
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new FlowLayout1(), 300, 300);
    }
}
