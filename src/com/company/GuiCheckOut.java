package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GuiCheckOut extends GuiDailyOverview implements ActionListener {

    static JLabel checkOutConfirmed;
    static JButton back;


    GuiCheckOut(){}

    public void guiCheckOut(){
        Gui.frame.setTitle("Roskilde frie børnehave - CheckOut");
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter timenow = DateTimeFormatter.ofPattern("HH:mm dd-MM");
        String adjusted = time.format(timenow);
        GuiCheckOut te = new GuiCheckOut();
        //DailyOverview dailyO = Kindergarten.getInstance().getWorksheetList().get(0).getWorkDays().get(4).getDailyOverview();
        checkOutConfirmed = new JLabel("<html> Du er herved tjekket ud klokken <br><br> \n <center>" + adjusted+ "</html>");

        back = new JButton("Tilbage");

        frame.getContentPane().add(checkOutConfirmed, BorderLayout.CENTER);
        frame.getContentPane().add(back, BorderLayout.CENTER);

        checkOutConfirmed.setBounds(100,170,300,50);

        back.setBounds(30,320,100,20);

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
