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
        String brugerNavn= "";
        for (int i=0; i< Kindergarten.getInstance().getDailyManagersInGarten().size(); )
        {
            if (user.equals(Kindergarten.getInstance().getDailyManagersInGarten().get(i).getCPR())) {
                brugerNavn= Kindergarten.getInstance().getDailyManagersInGarten().get(i).getName();
            }
            i++;
        }

        l_name.setText("Velkommen "+ brugerNavn);
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

            clean.guiDailyManagerClear();

            GuiWorksheet worksheet = new GuiWorksheet();
            worksheet.guiWorksheet();

        } else if (s == "Oversigt") {

            clean.guiDailyManagerClear();

            GuiDailyOverview dailyOverview = new GuiDailyOverview();
            dailyOverview.guiDailyOverview();

        } else if (s.equals("Log ud")) {
            user=null;
            password=null;
            l_name.setText("CPR: ");
            Gui.frame.setTitle("Roskilde frie børnehave");
            clean.guiDailyManagerClear();
            clean.guiLogOut();

        } else if(s == "Tjek barn"){
            clean.guiDailyManagerClear();

            GuiCheckChild checkChild = new GuiCheckChild();
            checkChild.guiCheckChild();
        }

    }
}
