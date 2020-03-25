package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.GuiCheckInChildOrOut.barn_cpr;

public class GuiCheckOutChildConfirm extends GuiDailyOverview implements ActionListener {

    static JLabel check_out_confirm;

    static JButton back;

    GuiCheckOutChildConfirm(){}

    public void guiCheckOutChildConfirm(){
        Gui.frame.setTitle("Roskilde frie børnehave - CheckOutChildConfirm");

        logo.setVisible(true);

        GuiCheckInChildConfirm te = new GuiCheckInChildConfirm();

        check_out_confirm = new JLabel("Barnet " + barn_cpr + " er herved tjekket ind");

        back = new JButton("Tilbage");

        check_out_confirm.setBounds(90,200,300,20);

        back.setBounds(40,320,100,20);

        back.addActionListener(te);

        Gui.frame.getContentPane().add(check_out_confirm, BorderLayout.CENTER);

        Gui.frame.getContentPane().add(back, BorderLayout.CENTER);

        frame.add(check_out_confirm);

        frame.add(back);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

        if(s == "Tilbage"){
            if(ansatliste.getSelectedItem() == "Daglig leder"){
                clean.guiOutChildConfirm();
                Gui.logo.setVisible(true);

                GuiDailyManager dailyManager = new GuiDailyManager();
                dailyManager.guiDailyManager();

            } else if(ansatliste.getSelectedItem() == "pædagog"){
                clean.guiOutChildConfirm();
                Gui.logo.setVisible(true);

                GuiEmployee employee = new GuiEmployee();
                employee.guiEmployee();
            }

        }
    }

}
