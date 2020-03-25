package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GuiCheckInChildOrOut extends GuiDailyOverview implements ActionListener {

    static JLabel topText;
    static JLabel child_cpr;

    static JTextField c_cpr;

    static JButton checkInChild;
    static JButton checkOutChild;

    static JButton back;

    GuiCheckInChildOrOut(){}

    public void guiCheckInChildOrOut(){
        Gui.frame.setTitle("Roskilde frie børnehave - CheckInChild");

        GuiCheckInChildOrOut te = new GuiCheckInChildOrOut();

        topText = new JLabel("Indtast CPR-nummeret på barnet");
        child_cpr = new JLabel("CPR-Nummer:");

        c_cpr = new JTextField(null);

        checkInChild = new JButton("Check barn ind");
        checkOutChild = new JButton("Check barn ud");

        back = new JButton("Tilbage");

        topText.setBounds(90, 25, 200, 20);

        child_cpr.setBounds(40,160,110,20);
        c_cpr.setBounds(120,160,110,20);

        checkInChild.setBounds(70,200,110,20);
        checkOutChild.setBounds(180,200,110,20);

        back.setBounds(40,320,100,20);

        frame.getContentPane().add(topText, BorderLayout.CENTER);

        frame.getContentPane().add(child_cpr, BorderLayout.CENTER);
        frame.getContentPane().add(c_cpr, BorderLayout.CENTER);

        frame.getContentPane().add(checkInChild, BorderLayout.CENTER);
        frame.getContentPane().add(checkOutChild, BorderLayout.CENTER);

        frame.getContentPane().add(back, BorderLayout.CENTER);

        checkInChild.addActionListener(te);
        checkOutChild.addActionListener(te);

        back.addActionListener(te);

        frame.add(topText);
        frame.add(child_cpr);
        frame.add(c_cpr);
        frame.add(checkInChild);
        frame.add(checkOutChild);
        frame.add(back);
    }
}
