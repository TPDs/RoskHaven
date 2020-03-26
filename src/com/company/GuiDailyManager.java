package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiDailyManager extends GuiBoss implements ActionListener {

    static JButton worksheet;
    static JButton dailyOverview;
    static JButton logout;
    static JButton check_kid;


    GuiDailyManager(){}

    public void guiDailyManager(){
        Gui.frame.setTitle("Roskilde frie børnehave - DailyManager");
        l_name.setText("Velkommen " + Gui.user);
        l_name.setVisible(true);

        GuiDailyManager te = new GuiDailyManager();

        worksheet = new JButton("Tjek uge plan");
        dailyOverview = new JButton("Oversigt");
        check_kid = new JButton("Tjek barn");
        logout = new JButton("Log ud");

        worksheet.setBounds(70,220,120,20);
        dailyOverview.setBounds(200,220,120,20);
        check_kid.setBounds(70,250,120,20);
        logout.setBounds(220,250,75,20);

        frame.getContentPane().add(worksheet, BorderLayout.CENTER);
        frame.getContentPane().add(dailyOverview,BorderLayout.CENTER);
        frame.getContentPane().add(check_kid, BorderLayout.CENTER);
        frame.getContentPane().add(logout,BorderLayout.CENTER);

        worksheet.addActionListener(te);
        dailyOverview.addActionListener(te);
        check_kid.addActionListener(te);
        logout.addActionListener(te);

        frame.add(worksheet);
        frame.add(dailyOverview);
        frame.add(check_kid);
        frame.add(logout);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

        if (s == "Tjek uge plan") {
            System.out.println("Test: " + s); //ændres til login();

            clean.guiDailyManagerClear();

            GuiWorksheet worksheet = new GuiWorksheet();
            worksheet.guiWorksheet();

        } else if (s == "Oversigt") {
            System.out.println("Test: " + s);

            clean.guiDailyManagerClear();

            GuiDailyOverview dailyOverview = new GuiDailyOverview();
            dailyOverview.guiDailyOverview();

        } else if (s.equals("Log ud")) {
            System.out.println("Test: " + s);
            user=null;
            password=null;
            clean.guiDailyManagerClear();
            clean.guiLogOut();

        } else if(s == "Liste over børn"){
            clean.guiDailyManagerClear();

            GuiCheckChild checkChild = new GuiCheckChild();
            checkChild.guiCheckChild();
        }

    }
}
