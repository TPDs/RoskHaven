package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiRemoveChild extends GuiViewChild implements ActionListener {

    static JLabel confirmationText1;
    static JLabel confirmationText2;
    static JButton back;
    static JButton confirm;



    GuiRemoveChild(){}

    public void guiRemoveChild(){
        Gui.frame.setTitle("Roskilde frie børnehave - RemoveChild");
        logo.setVisible(true);

        GuiRemoveChild te = new GuiRemoveChild();

        confirmationText1 = new JLabel("Er du sikker på, at " + barn_cpr);
        confirmationText2 = new JLabel(" skal blive fjernet fra børnehaven?");

        back = new JButton("Tilbage");
        confirm = new JButton("Bekræft");

        confirmationText1.setBounds(110,150,300,20);
        confirmationText2.setBounds(100,180,300,20);

        back.setBounds(40,320,100,20);
        confirm.setBounds(250,320,100,20);

        Gui.frame.getContentPane().add(confirmationText1, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(confirmationText2, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(confirm, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(back, BorderLayout.CENTER);

        back.addActionListener(te);
        confirm.addActionListener(te);

        frame.add(confirmationText1);
        frame.add(confirmationText2);
        frame.add(back);
        frame.add(confirm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

        if (s == "Tilbage") {
            clean.guiRemoveChild();

            GuiBoss bigboss = new GuiBoss();
            bigboss.GuiBoss();

        } else if (s == "Bekræft") {
            confirmationText1.setText(barn_cpr);
            confirmationText2.setText("er blevet fjernet fra børnehaven");

            confirmationText1.setBounds(160,150,300,20);
            confirmationText2.setBounds(110,180,300,20);

            confirm.setVisible(false);
        }
    }

}
