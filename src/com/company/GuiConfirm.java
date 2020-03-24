package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GuiConfirm extends GuiAddGuardian {
    static JTextArea box_info;
    static JLabel confirm_lable;
    static JButton confirm_button;
    static JButton quit_button;

    GuiConfirm() {

    }


    public void guiConfirm() {
        Gui.frame.setTitle("Roskilde frie børnehave - Godkend");

        GuiConfirm te = new GuiConfirm();

        quit_button = new JButton("Afbryd");
        box_info = new JTextArea();
        confirm_lable = new JLabel("Godkend information");
        confirm_button = new JButton("Godkend");


        box_info.setLineWrap(true);
        Gui.frame.getContentPane().add(confirm_lable, BorderLayout.NORTH);
        Gui.frame.getContentPane().add(confirm_button, BorderLayout.CENTER);

        confirm_lable.setBounds(130, 40, 150, 20);
        box_info.setBounds(50, 80, 280, 200);
        confirm_button.setBounds(275, 320, 95, 20);
        quit_button.setBounds(40,320,100,20);

        Gui.frame.add(quit_button);
        Gui.frame.add(box_info);
        Gui.frame.add(confirm_lable);
        Gui.frame.add(confirm_button);

        quit_button.addActionListener(te);
        confirm_button.addActionListener(te);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

    }

}
