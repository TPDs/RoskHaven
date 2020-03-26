package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GuiCheckOutChildConfirm extends GuiCheckInChildOrOut implements ActionListener {

    static JLabel check_out_confirm;

    static JButton back2;

    GuiCheckOutChildConfirm(){}

    public void guiCheckOutChildConfirm(){
        Gui.frame.setTitle("Roskilde frie børnehave - CheckOutChildConfirm");

        logo.setVisible(true);

        GuiCheckInChildConfirm te = new GuiCheckInChildConfirm();

        check_out_confirm = new JLabel("Barnet " + barn2_cpr + " er herved tjekket ind");

        back2 = new JButton("Tilbage2");

        check_out_confirm.setBounds(90,200,300,20);

        back2.setBounds(40,320,100,20);

        back2.addActionListener(te);

        Gui.frame.getContentPane().add(check_out_confirm, BorderLayout.CENTER);

        Gui.frame.getContentPane().add(back2, BorderLayout.CENTER);

        frame.add(check_out_confirm);

        frame.add(back2);

        System.out.println(ansatliste.getSelectedItem());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

        if(s.equals("Tilbage2")){
            if(ansatliste.getSelectedItem().equals("Daglig leder")){
                clean.guiOutChildConfirm();
                Gui.logo.setVisible(true);

                System.out.println("Colamanden25");

                GuiDailyManager dailyManager = new GuiDailyManager();
                dailyManager.guiDailyManager();

            } else if(ansatliste.getSelectedItem().equals("pædagog")){
                clean.guiOutChildConfirm();
                Gui.logo.setVisible(true);

                System.out.println("Colamanden23");

                GuiEmployee employee = new GuiEmployee();
                employee.guiEmployee();
            }

        }
    }

}
