package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        label = new JLabel("Arbejsplan for uge: "+week_nr);

        worksheet_info = new JTextArea(10,10);

        edit_worksheet = new JButton("Ændre uge plan");
        back = new JButton("Tilbage");

        scroll3 = new JScrollPane(worksheet_info);
        scroll3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        worksheet_info.setLineWrap(true);

        Gui.frame.getContentPane().add(label, BorderLayout.CENTER);
        //Gui.frame.getContentPane().add(worksheet_info, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(edit_worksheet, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(back, BorderLayout.CENTER);

        label.setBounds(95,25,360,20);

        scroll3.setBounds(20,50,340,230);
        worksheet_info.setEditable(false);

        //edit_worksheet.setBounds(130,290,140,20);
        back.setBounds(20,330,90,20);
         Kindergarten.getInstance().findWorksheet(2020,3).getWorkDays().get(2).getWorkHours().get(2).getEmployeeAtWork();
        worksheet_info.setText(Kindergarten.getInstance().findWorksheet(2020,3).getWorkDays().get(2).getWorkHours().get(2).getEmployeeAtWork().toString());
        //edit_worksheet.addActionListener(te);
        back.addActionListener(te);
        frame.getContentPane().add(scroll3);
        frame.add(label);
        //frame.add(worksheet_info);
        // frame.add(edit_worksheet);
        edit_worksheet.setVisible(false);
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

        if (s == "Ændre uge plan") {
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
