package com.company;

import javax.swing.*;
import java.awt.*;

public class GuiConfirm {
    static JTextArea box_info;
    static JLabel confirm_lable;
    static JButton confirm_button;

    GuiConfirm() {

    }


    public void guiConfirm() {
        Gui.frame.setTitle("Roskilde frie børnehave - Godkend");

        GuiConfirm te = new GuiConfirm();

        box_info = new JTextArea();
        confirm_lable = new JLabel("Godkend information");
        confirm_button = new JButton("Godkend");


        box_info.setLineWrap(true);
        Gui.frame.getContentPane().add(confirm_lable, BorderLayout.NORTH);
        Gui.frame.getContentPane().add(confirm_button, BorderLayout.CENTER);

        confirm_lable.setBounds(130, 40, 150, 20);
        box_info.setBounds(50, 80, 280, 200);
        confirm_button.setBounds(275, 320, 95, 20);


        Gui.frame.add(box_info);
        Gui.frame.add(confirm_lable);
        Gui.frame.add(confirm_button);


    }
}
