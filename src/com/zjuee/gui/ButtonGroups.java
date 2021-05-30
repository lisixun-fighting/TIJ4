package com.zjuee.gui;

import com.zjuee.util.SwingConsole;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.lang.reflect.Constructor;

public class ButtonGroups extends JFrame {
    private static String[] ids = {
            "June", "Ward", "Beaver", "Wally", "Eddie", "Lumpy"
    };
    static JPanel makeBPanel(Class<? extends AbstractButton> kind, String[] ids) {
        ButtonGroup bg = new ButtonGroup();
        JPanel jp = new JPanel();
        String title = kind.getName();
        title = title.substring(title.lastIndexOf(".") + 1);
        jp.setBorder(new TitledBorder(title));
        for (String id : ids) {
            AbstractButton ab = new JButton("failed");
            try {
                Constructor<?> ctor = kind.getConstructor(String.class);
                ab = ((AbstractButton) ctor.newInstance(id));
            } catch (Exception e) {
                System.out.println("can't create " + kind);
            }
            bg.add(ab);
            jp.add(ab);
        }
        return jp;
    }
    public ButtonGroups() {
        setLayout(new FlowLayout());
        add(makeBPanel(JButton.class, ids));
        add(makeBPanel(JToggleButton.class, ids));
        add(makeBPanel(JCheckBox.class, ids));
        add(makeBPanel(JRadioButton.class, ids));
    }

    public static void main(String[] args) {
        SwingConsole.run(new ButtonGroups(), 500, 350);
    }
}
