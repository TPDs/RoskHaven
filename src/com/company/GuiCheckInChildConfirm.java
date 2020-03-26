package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiCheckInChildConfirm extends GuiCheckInChildOrOut implements ActionListener {

    static JLabel check_in_confirm;
    static JButton back1;

    GuiCheckInChildConfirm(){}

    public void guiCheckInChildConfirm(){
        Gui.frame.setTitle("Roskilde frie børnehave - CheckInChildConfirm");

        logo.setVisible(true);

        GuiCheckInChildConfirm te = new GuiCheckInChildConfirm();

        check_in_confirm = new JLabel("Barnet" + barn1_cpr + " er herved tjekket ind");

        back1 = new JButton("Tilbage1");

        check_in_confirm.setBounds(80,200,300,20);

        back1.setBounds(40,320,100,20);

        back1.addActionListener(te);

        Gui.frame.getContentPane().add(check_in_confirm, BorderLayout.CENTER);

        Gui.frame.getContentPane().add(back1, BorderLayout.CENTER);

        frame.add(check_in_confirm);

        frame.add(back1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

        if(s == "Tilbage1"){
            if(ansatliste.getSelectedItem() == "Daglig leder"){
                clean.guiInChildConfirm();
                Gui.logo.setVisible(true);

                GuiDailyManager dailyManager = new GuiDailyManager();
                dailyManager.guiDailyManager();

            } else if(ansatliste.getSelectedItem() == "pædagog"){
                clean.guiInChildConfirm();
                Gui.logo.setVisible(true);

                GuiEmployee employee = new GuiEmployee();
                employee.guiEmployee();
            }

        }
    }
}
