package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiCheckOut extends GuiDailyOverview implements ActionListener {

    static JLabel checkOutConfirmed;
    static JButton back;


    GuiCheckOut(){}

    public void guiCheckOut(){
        Gui.frame.setTitle("Roskilde frie børnehave - CheckOut");

        GuiCheckOut te = new GuiCheckOut();

        checkOutConfirmed = new JLabel("Du er herved tjekket ud");

        back = new JButton("Tilbage");

        frame.getContentPane().add(checkOutConfirmed, BorderLayout.CENTER);
        frame.getContentPane().add(back, BorderLayout.CENTER);

        checkOutConfirmed.setBounds(130,200,200,20);

        back.setBounds(40,320,100,20);

        back.addActionListener(te);

        frame.add(checkOutConfirmed);
        frame.add(back);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

        if(s == "Tilbage"){
            if(ansatliste.getSelectedItem() == "Daglig leder"){
                clean.guiCheckOutClear();
                Gui.logo.setVisible(true);

                GuiDailyManager dailyManager = new GuiDailyManager();
                dailyManager.guiDailyManager();

            } else if(ansatliste.getSelectedItem() == "pædagog"){
                clean.guiCheckOutClear();
                Gui.logo.setVisible(true);

                GuiEmployee employee = new GuiEmployee();
                employee.guiEmployee();
            }

        }
    }
}
