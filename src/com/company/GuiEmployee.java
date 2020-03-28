package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class GuiEmployee extends GuiBoss implements ActionListener {

    static JButton worksheet;
    static JButton dailyOverview;
    static JButton logout;


    GuiEmployee(){}

    public void guiEmployee(){
        Gui.frame.setTitle("Roskilde frie børnehave - Employee");
        String brugerNavn ="";
        for (int i=0; i< Kindergarten.getInstance().getEmployeesInGarten().size();i++ )
        {
            if (user.equals(Kindergarten.getInstance().getEmployeesInGarten().get(i).getCPR())) {
                brugerNavn= Kindergarten.getInstance().getEmployeesInGarten().get(i).getCPR(); // Ændres til getName
            }
        }

        System.out.println(brugerNavn);
        l_name.setVisible(true);

        GuiEmployee te = new GuiEmployee();

        worksheet = new JButton("Tjek uge plan");
        dailyOverview = new JButton("Oversigt");
        logout = new JButton("Log ud");

        worksheet.setBounds(70,220,120,20);
        dailyOverview.setBounds(200,220,120,20);
        logout.setBounds(220,250,75,20);

        frame.getContentPane().add(worksheet, BorderLayout.CENTER);
        frame.getContentPane().add(dailyOverview,BorderLayout.CENTER);
        frame.getContentPane().add(logout,BorderLayout.CENTER);

        worksheet.addActionListener(te);
        dailyOverview.addActionListener(te);
        logout.addActionListener(te);

        frame.add(worksheet);
        frame.add(dailyOverview);
        frame.add(logout);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

        if (s == "Tjek uge plan") {
            System.out.println("Test: " + s); //ændres til login();

            clean.guiEmployeeClear();
        //try {
            //GuiWorksheetWeek.label.setText("Ugeplanen for uge " /* + week*/);
            //GuiWorksheetWeek.edit_worksheet.setVisible(false);

            GuiWorksheet worksheet = new GuiWorksheet();
            worksheet.guiWorksheet();
        //}
        //catch(NullPointerException n){
            //System.out.println("NullPointerException catched");
            //}
            //GuiAddChild child = new GuiAddChild();
            //child.guiAddChild();

        } else if (s == "Oversigt") {
            System.out.println("Test: " + s);

            clean.guiEmployeeClear();

            GuiDailyOverview dailyOverview = new GuiDailyOverview();
            dailyOverview.guiDailyOverview();

        } else if (s.equals("Log ud")) {
            System.out.println("Test: " + s);
            user=null;
            password=null;
            l_name.setText("CPR: ");
            clean.guiEmployeeClear();
            clean.guiLogOut();

        }

    }

}
