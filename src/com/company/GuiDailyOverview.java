package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiDailyOverview extends GuiEmployee implements ActionListener {
    static JLabel topText;

    static JButton check_child_in_or_out;
    static JButton employee_check_in;
    static JButton employee_check_out;

    static JButton back;


    GuiDailyOverview(){}

    public void guiDailyOverview(){
        Gui.frame.setTitle("Roskilde frie børnehave - DailyOverview");

        GuiDailyOverview te = new GuiDailyOverview();

        topText = new JLabel("Hvad kunne du tænke dig at gøre?");

        check_child_in_or_out = new JButton("Tjek barn ind eller ud");
        employee_check_in = new JButton("Tjek ind");
        employee_check_out = new JButton("Tjek ud");

        back = new JButton("Tilbage");

        topText.setBounds(90, 25, 200, 20);

        check_child_in_or_out.setBounds(130, 200, 110, 20);
        employee_check_in.setBounds(70, 230, 110, 20);
        employee_check_out.setBounds(200, 230, 110, 20);

        back.setBounds(40, 320, 100, 20);

        frame.getContentPane().add(topText, BorderLayout.CENTER);

        frame.getContentPane().add(check_child_in_or_out,BorderLayout.CENTER);
        frame.getContentPane().add(employee_check_in,BorderLayout.CENTER);
        frame.getContentPane().add(employee_check_out, BorderLayout.CENTER);

        frame.getContentPane().add(back,BorderLayout.CENTER);

        check_child_in_or_out.addActionListener(te);
        employee_check_in.addActionListener(te);
        employee_check_out.addActionListener(te);

        back.addActionListener(te);

        frame.add(topText);
        frame.add(check_child_in_or_out);
        frame.add(employee_check_in);
        frame.add(employee_check_out);
        frame.add(back);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

        if (s == "Tjek barn ind eller ud") {
            clean.guiDailyOverviewClean();

            GuiCheckInChildOrOut checkInChildOrOut = new GuiCheckInChildOrOut();
            checkInChildOrOut.guiCheckInChildOrOut();

        } else if(s == "Tjek ind") {
                clean.guiDailyOverviewClean();
                Gui.logo.setVisible(true);

                GuiCheckIn checkIn = new GuiCheckIn();
                checkIn.guiCheckIn();


        } else if(s == "Tjek ud") {
                clean.guiDailyOverviewClean();
                Gui.logo.setVisible(true);

                GuiCheckOut checkOut = new GuiCheckOut();
                checkOut.guiCheckOut();

        } else if(s == "Tilbage"){
            if(ansatliste.getSelectedItem() == "Daglig leder"){
                clean.guiDailyOverviewClean();
                Gui.logo.setVisible(true);

                GuiDailyManager dailyManager = new GuiDailyManager();
                dailyManager.guiDailyManager();

            } else if(ansatliste.getSelectedItem() == "pædagog"){
                clean.guiDailyOverviewClean();
                Gui.logo.setVisible(true);

                GuiEmployee employee = new GuiEmployee();
                employee.guiEmployee();
            }

        }
    }

}
