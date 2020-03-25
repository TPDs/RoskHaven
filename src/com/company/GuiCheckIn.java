package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiCheckIn extends GuiDailyOverview implements ActionListener {

    static JLabel checkInConfirmed;
    static JButton back;


    GuiCheckIn(){}

    public void guiCheckIn(){
        Gui.frame.setTitle("Roskilde frie børnehave - CheckIn");

        GuiCheckIn te = new GuiCheckIn();

        checkInConfirmed = new JLabel("Du er herved tjekket ind");

        back = new JButton("Tilbage");

        Gui.frame.getContentPane().add(checkInConfirmed, BorderLayout.CENTER);

        Gui.frame.getContentPane().add(back, BorderLayout.CENTER);

        checkInConfirmed.setBounds(130,200,200,20);

        back.setBounds(40, 320, 100, 20);

        back.addActionListener(te);

        frame.add(checkInConfirmed);
        frame.add(back);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

        if(s == "Tilbage"){
            if(ansatliste.getSelectedItem() == "Daglig leder"){
                clean.guiCheckInClear();
                Gui.logo.setVisible(true);

                GuiDailyManager dailyManager = new GuiDailyManager();
                dailyManager.guiDailyManager();

            } else if(ansatliste.getSelectedItem() == "pædagog"){
                clean.guiCheckInClear();
                Gui.logo.setVisible(true);

                GuiEmployee employee = new GuiEmployee();
                employee.guiEmployee();
            }

        }
    }

}
