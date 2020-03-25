package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiCheckInChildOrOut extends GuiDailyOverview implements ActionListener {

    static JLabel topText;
    static JLabel child_cpr;

    static JTextField c_cpr;

    static JButton checkInChild;
    static JButton checkOutChild;

    static JButton back;

    static String barn_cpr;

    GuiCheckInChildOrOut(){}

    public void guiCheckInChildOrOut(){
        Gui.frame.setTitle("Roskilde frie børnehave - CheckInChildOrOut");

        GuiCheckInChildOrOut te = new GuiCheckInChildOrOut();

        topText = new JLabel("Indtast CPR-nummeret på barnet");
        child_cpr = new JLabel("CPR-Nummer:");

        c_cpr = new JTextField(null);

        checkInChild = new JButton("Tjek barn ind");
        checkOutChild = new JButton("Tjek barn ud");

        back = new JButton("Tilbage");

        topText.setBounds(90, 25, 200, 20);

        child_cpr.setBounds(40,160,110,20);
        c_cpr.setBounds(140,160,200,20);

        checkInChild.setBounds(70,220,110,20);
        checkOutChild.setBounds(200,220,110,20);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();
        barn_cpr = c_cpr.getText();

        if (s == "Tjek barn ind") {
            clean.guiCheckInChildOrOut();

            GuiCheckInChildConfirm checkInChildConfirm = new GuiCheckInChildConfirm();
            checkInChildConfirm.guiCheckInChildConfirm();

        } else if(s == "Tjek barn ud") {
            clean.guiCheckInChildOrOut();

            GuiCheckOutChildConfirm checkOutChildConfirm = new GuiCheckOutChildConfirm();
            checkOutChildConfirm.guiCheckOutChildConfirm();


        } else if(s == "Tilbage"){
            if(ansatliste.getSelectedItem() == "Daglig leder"){
                clean.guiCheckInChildOrOut();
                Gui.logo.setVisible(true);

                GuiDailyManager dailyManager = new GuiDailyManager();
                dailyManager.guiDailyManager();

            } else if(ansatliste.getSelectedItem() == "pædagog"){
                clean.guiCheckInChildOrOut();
                Gui.logo.setVisible(true);

                GuiEmployee employee = new GuiEmployee();
                employee.guiEmployee();
            }

        }
    }


}
