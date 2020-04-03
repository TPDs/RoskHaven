package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiWorksheetWeek extends GuiWorksheet implements ActionListener {

    static JLabel label;
    static JTextArea worksheet_info;
    static JButton edit_worksheet;
    static JButton back;
    static JScrollPane scroll3;


    GuiWorksheetWeek(){}
    public void guiWorksheetWeek(){
        Gui.frame.setTitle("Roskilde frie børnehave - WorksheetWeek");

        GuiWorksheetWeek te = new GuiWorksheetWeek();

        label = new JLabel("Arbejsplan for dag:\n "+week_nr + " Måned: \n" + mb + " År: \n " + yr);

        worksheet_info = new JTextArea(10,10);

        edit_worksheet = new JButton("Ændre plan");
        back = new JButton("Tilbage");


        worksheet_info.setText("");
        String weekliste = Kindergarten.getInstance().findWorksheet(yr,mb).workScheduleOfDay(Integer.parseInt(week_nr));
        worksheet_info.append(weekliste);
        scroll3 = new JScrollPane(worksheet_info);
        scroll3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        worksheet_info.setLineWrap(true);

        Gui.frame.getContentPane().add(label, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(edit_worksheet, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(back, BorderLayout.CENTER);

        label.setBounds(75,25,360,20);
        edit_worksheet.setBounds(200,330,150,20);
        scroll3.setBounds(35,50,320,250);
        worksheet_info.setEditable(false);
        back.setBounds(20,330,90,20);

        back.addActionListener(te);
        edit_worksheet.addActionListener(te);
        frame.getContentPane().add(scroll3);
        frame.add(label);
        //edit_worksheet.setVisible(false);
        frame.add(back);

        if(ansatliste.getSelectedItem() == "Boss"){
            edit_worksheet.setVisible(true);
        } else if(ansatliste.getSelectedItem() == "pædagog"){
            edit_worksheet.setVisible(false);
        } else if(ansatliste.getSelectedItem() == "Daglig leder"){
            edit_worksheet.setVisible(false);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

        if (s == "Ændre plan") {
            clean.guiWorksheetWeek();

            GuiEditWorksheet editWorksheet = new GuiEditWorksheet();
            editWorksheet.guiEditWorksheet();


        } else if(s =="Tilbage") {
            if(ansatliste.getSelectedItem() == "Daglig leder"){
                clean.guiWorksheetWeek();
                Gui.logo.setVisible(true);

                GuiDailyManager dailyManager = new GuiDailyManager();
                dailyManager.guiDailyManager();

            } else if(ansatliste.getSelectedItem() == "Boss"){
                clean.guiWorksheetWeek();
                Gui.logo.setVisible(true);

                GuiBoss bigboss = new GuiBoss();
                bigboss.GuiBoss();

            } else if(ansatliste.getSelectedItem().equals("pædagog")){
                clean.guiWorksheetWeek();
                Gui.logo.setVisible(true);

                GuiEmployee emp = new GuiEmployee();
                emp.guiEmployee();
            }
        }
    }

}
