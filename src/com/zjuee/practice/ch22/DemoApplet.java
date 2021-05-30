package com.zjuee.practice.ch22;

import com.zjuee.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class DemoApplet extends JFrame {
    JButton b1 = new MyButton("test");
    JTextField text = new JTextField(10);
    class MyButton extends JButton {
        private boolean avail = false;
        private Random random = new Random(47);
        private MyButton(String name) {
            super(name);
            addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    avail = true;
                }
                public void mouseExited(MouseEvent e) {
                    avail = false;
                }
                public void mouseClicked(MouseEvent e) {
                    changeColor();
                }
            });
            addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (avail)
                        text.setText(String.valueOf(e.getKeyChar()));
                }
            });
        }
        private void changeColor() {
            switch (random.nextInt(5)) {
                case 0:
                    this.setBackground(Color.BLUE);
                    break;
                case 1:
                    this.setBackground(Color.RED);
                    break;
                case 2:
                    this.setBackground(Color.YELLOW);
                    break;
                default:
                    this.setBackground(Color.GREEN);
            }
        }
    }
    public DemoApplet() {
        setLayout(new FlowLayout());
        add(b1);
        add(text);
    }

    public static void main(String[] args) {
        SwingConsole.run(new DemoApplet(), 400, 300);
    }
}
